package com.jongman22.effectmoim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jongman22.effectmoim.databinding.ActivityRealmAcitivtyBinding
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmAcitivty : AppCompatActivity() {
    private lateinit var binding :ActivityRealmAcitivtyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRealmAcitivtyBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        Realm.init(this@RealmAcitivty) //사용하기 위해 초기화할게~
        val config:RealmConfiguration=RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()
        //여기까지 Realm을 사용하기 위한 객체를 만들었다.

        binding.save.setOnClickListener {
            realm.executeTransaction{
                with(it.createObject(School::class.java)){
                    this.name="어떤 대학교"
                    this.location="서울 "
                } //데이터생성
            }
        }
        binding.load.setOnClickListener {
            realm.executeTransaction{
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa","data : "+ data)
            }
        }
        binding.delete.setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm()
            }
        }


    }
}