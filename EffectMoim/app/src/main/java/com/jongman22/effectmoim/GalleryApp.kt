package com.jongman22.effectmoim

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.jongman22.effectmoim.databinding.ActivityGalleryAppBinding
import com.jongman22.effectmoim.databinding.ActivityMainBinding
import org.jetbrains.anko.*

private val REQUESTED_READ_EXTERNAL_STORAGE = 1000


class GalleryApp : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryAppBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                alert("사진정보를 얻으려면 외부 저장소 권한이 필수로 필요합니다.", "권한이 필요한 이유") {
                    yesButton {
                        //권한요청
                        ActivityCompat.requestPermissions(this@GalleryApp, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                                REQUESTED_READ_EXTERNAL_STORAGE)
                    }
                    noButton { }
                }.show()
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        REQUESTED_READ_EXTERNAL_STORAGE)
            }
        else {
            //권한이 이미 허용됨
            getAllPhotos()
        }
    }
    //사용자가 권한 요청시 호출되는 메서드
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUESTED_READ_EXTERNAL_STORAGE->{
                if((grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED)){
                    getAllPhotos()
                }else{
                    toast("권한이 거부됨")
                }
                return
            }
        }
    }

    private fun getAllPhotos(){
        val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,null,null,
        MediaStore.Images.ImageColumns.DATE_TAKEN+"DESC")
        val uriArr = ArrayList<String>()
        if(cursor!=null){
            while(cursor.moveToNext()){
                val uri = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                uriArr.add(uri)
            }
            cursor.close()
        }
        val adapter = MyAdapter(this,uriArr)
        /*gridView.numColumns=3
        gridView.adapter = adapter*/
    }
}

class MyAdapter(val context: Context, uriArr:ArrayList<String>):BaseAdapter(){
    private var items = ArrayList<String>()
    init{
        this.items = uriArr
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = ImageView(context)
        val display = context.getResources().getDisplayMetrics()
        imageView.padding = 2
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.layoutParams = LinearLayout.LayoutParams(display.widthPixels/3,display.widthPixels/3)
        Glide.with(context)
            .load(items[position])
            .into(imageView)
        return imageView

    }
}