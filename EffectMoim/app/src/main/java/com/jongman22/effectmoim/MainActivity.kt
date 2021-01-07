package com.jongman22.effectmoim

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import com.jongman22.effectmoim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view  =binding.root
        setContentView(view)
        val student__=Student__()
        student__.eat()
        student__.sleep()


    }
}


//인터페이스는 약속!
//인터페이스는 생성자가 없다.  --> 인스턴스화 될 수 없다. 즉, 설명서가 아니다.
//인터페이스는 지침서다. --> 이것을 구현하고 싶다면  반드시 아래 기능을 구현해라
//인터페이스는 상속과 달리 아래 클래스에서 구현하는 함수들의 내용이 많이 달라도 된다.

interface Person__
{
    fun eat(){
        Log.d("기능","먹는다.")
    }
    fun sleep(){
        Log.d("기능","잔다.")
    }
    abstract fun study()
    //abstract로 만들어 놓으면 반드시 구현해야 합니다. 아래에서서}
}
class Student__:Person__
{
    //이렇게 interface를 사용하게 되면 override를 하지 않아도 오류가 나지 않는다.
    override fun study() {

    }
}






interface Person_{
    fun eat()
    fun sleep()
}

class Student_:Person_
{
    //override를 하지 않으면 오류가 난다.
    override fun eat() {

    }

    override fun sleep() {

    }
}


open class Person(){
    open fun eat(){

    }
    fun sleep(){

    }

}

class Student():Person(){
    override fun eat() {
        super.eat()
    }
}

