package com.jongman22.viewmodel

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.FutureTarget
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.jongman22.viewmodel.databinding.ActivityGallery2Binding
import java.io.File
import java.io.IOException
import java.lang.Exception
import java.util.ArrayList

class Gallery2 : AppCompatActivity() {
    private lateinit var viewModel: CameraViewModel
    private lateinit var binding: ActivityGallery2Binding


    // file that store a captured image from camera
    private var imageFile: File? = null

    private val takePhoto = 111
    private val takeGallery = 222
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGallery2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(viewModelStore, CameraViewModelFactory(application)).get(
            CameraViewModel::class.java
        )
        binding.tvCtaCamera.setOnClickListener {
            checkCameraPermission(ImageType.CAMERA)
        }
        binding.tvCtaGallery.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
                callGallery()
            else
                checkCameraPermission(ImageType.GALLERY)
        }


    }

    private fun callCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                try {
                    imageFile = viewModel.createImageFile(this@Gallery2)
                    val imageUri =
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            FileProvider.getUriForFile(
                                this,
                                BuildConfig.APPLICATION_ID + ".provider",
                                imageFile!!
                            )
                        else
                            Uri.fromFile(imageFile)
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
                    startActivityForResult(takePictureIntent, takePhoto)
                } catch (e: IOException) {
                    imageFile = null
                    Log.e("LOG>>", "IOException while creating file : $e")
                } catch (e: Exception) {
                    imageFile = null
                    Log.e("LOG>>", "Exception while creating file : $e")
                }
            }
        }
    }

    private fun callGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, takeGallery)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            takePhoto -> {
                if (imageFile == null) {
                    Log.e("LOG>>", "After taking a picture, imageFile null. ....")
                    return
                }
                if (requestCode != Activity.RESULT_OK) {
                    return
                }
                Glide.with(this)
                    .load(imageFile)
                    .into(binding.ivImage)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Thread(Runnable {
                        val futureTarget: FutureTarget<Bitmap> = Glide.with(this)
                            .asBitmap()
                            .load(imageFile)
                            .submit()
                        if (viewModel.savePhotoAndroidQ(futureTarget.get()) == null)
                            runOnUiThread {
                                Toast.makeText(
                                    this,
                                    "Failed to save image in gallery",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        viewModel.deleteImages(imageFile!!)
                    }).start()
                } else
                    viewModel.notifyGallery(imageFile!!)
            }

            takeGallery -> {
                if (requestCode == Activity.RESULT_OK) {
                    val file = viewModel.createImageFileAndroidQ(uri = data?.data!!)
                    Glide.with(this).load(file).into(binding.ivImage)
                }
            }
        }
    }

    private fun checkCameraPermission(type: ImageType) {
        TedPermission.with(this)
            .setPermissionListener(object : PermissionListener {
                override fun onPermissionGranted() {
                    when (type) {
                        ImageType.CAMERA -> callCamera()
                        ImageType.GALLERY -> callGallery()
                    }
                }

                override fun onPermissionDenied(deniedPermissions: ArrayList<String>?) {

                }
            })
            .setDeniedMessage("Please allow permissions to use this app.\uD83D\uDE2D\uD83D\uDE2D")
            .apply {
                when (type) {
                    ImageType.CAMERA -> {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
                            setPermissions(android.Manifest.permission.CAMERA)
                        else
                            setPermissions(
                                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                android.Manifest.permission.CAMERA
                            )
                    }
                    ImageType.GALLERY -> setPermissions(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                }
            }
            .check()
    }
}