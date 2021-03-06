package com.jongman22.realtodolist

import android.app.Application
import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class CameraViewModelFactory(private val myApplication: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java).newInstance(myApplication)
    }
}

class CameraViewModel(
    private val myApplication: Application
) : ViewModel() {

    fun savePhotoAndroidQ(bitmap: Bitmap): Uri? {
        try {
            val relativePath =
                Environment.DIRECTORY_PICTURES + File.separator + myApplication.getString(R.string.app_name)
            val mimeType = "image/*"
            val fileName = SimpleDateFormat("YYYY_MM_dd_HH_mm:ss").format(Date()) + ".jpg"
            val values = ContentValues().apply {
                put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
                put(MediaStore.Images.Media.MIME_TYPE, mimeType)
                put(MediaStore.Images.Media.IS_PENDING, 1)
                put(MediaStore.Images.Media.RELATIVE_PATH, relativePath)
            }
            val resolver = myApplication.contentResolver ?: return null
            val collection = MediaStore.Images.Media
                .getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
            val uri = resolver.insert(collection, values)
            if (uri == null) {
                Log.e("LOG>>", "Failed to create new  MediaStore record.")
                return null
            }
            val outputStream = resolver.openOutputStream(uri)
            if (outputStream == null) {
                Log.e("LOG>>", "Failed to get output stream.")
            }
            val saved = bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            if (!saved) {
                Log.e("LOG>>", "Fail to save photo to gallery")
            }
            values.clear()
            values.put(MediaStore.Images.Media.IS_PENDING, 0)
            resolver.update(uri, values, null, null)
            return uri
        } catch (e: Exception) {
            Log.e("LOG>>", "error : $e")
            return null
        }
    }

    fun createImageFileAndroidQ(uri: Uri): File? {
        return try {
            val parceFileDescriptor =
                myApplication.contentResolver.openFileDescriptor(uri, "r", null)
            val inputStream = FileInputStream(parceFileDescriptor?.fileDescriptor)
            val file = File(myApplication.cacheDir, myApplication.contentResolver.getFileName(uri))
            val outputStream = FileOutputStream(file)
            inputStream.copyTo(outputStream)
            file
        } catch (e: Exception) {
            Log.e("LOG>>", "createImageFileAndroidQ ERror : $e")
            null
        }
    }

    @Throws(IOException::class)
    fun createImageFile(context: Context): File {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val storageDir: File? =
                myApplication.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            return File.createTempFile(
                SimpleDateFormat("yyMMdd_HH:mm:ss").format(Date()),
                ".jpeg",
                storageDir
            )
        } else {
            val storageDir = context.getExternalFilesDir(
                Environment.DIRECTORY_PICTURES + File.separator + "my_folder"
            )
            storageDir?.let {
                if (!storageDir.exists())
                    storageDir.mkdir()
            }
            return File.createTempFile(
                SimpleDateFormat("yyMMdd_HH:mm:ss").format(Date()),
                "jpeg",
                storageDir
            )
        }
    }

    fun notifyGallery(imageFile: File) {
        myApplication.sendBroadcast(
            Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.fromFile(imageFile!!)
            )
        )
    }


    fun deleteImages(file: File) {
        try {
            file.delete()
        } catch (e: Exception) {
            Log.e("LOG>>", "error while deleting image : $e")
        }
    }

    private fun ContentResolver.getFileName(fileUri: Uri): String {
        var name = ""
        val returnCursor = this.query(fileUri, null, null, null, null)
        if (returnCursor != null) {
            val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            returnCursor.moveToFirst()
            name = returnCursor.getString(nameIndex)
            returnCursor.close()
        }

        return name
    }

}