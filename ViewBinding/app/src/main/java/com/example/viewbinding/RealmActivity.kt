package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.viewbinding.databinding.ActivityRealmBinding
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityRealmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Realm.init(this@RealmActivity)
        val config:RealmConfiguration=RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)
        val realm=Realm.getDefaultInstance()

        binding.save.setOnClickListener {
            realm.executeTransaction{
                with(it.createObject(School::class.java)){
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }
            }
        }

        binding.load.setOnClickListener {
            realm.executeTransaction{
                val data=it.where(School::class.java).findFirst()
                Log.d("dataa","data : "+data)
            }
        }

        binding.delete.setOnClickListener {
            realm.executeTransaction{
                it.where(School::class.java).findAll().deleteAllFromRealm()

            }
        }






    }
}