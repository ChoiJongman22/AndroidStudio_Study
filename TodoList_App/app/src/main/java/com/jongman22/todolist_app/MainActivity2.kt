package com.jongman22.todolist_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Car("v8 engine", "big")
        val supercar: SuperCar = SuperCar("good", "big", "white")

        val runableCar:RunableCar= RunableCar("simple engine","simple body")
        runableCar.ride()
        runableCar.run()
        runableCar.navi("서울")

        val runableCar2:RunableCar2= RunableCar2("engine2","body2","door2")
        Log.d("runnableCar2",""+runableCar2.engine)
        Log.d("runnableCar2",""+runableCar2.body)

    }
}

class Car(var engine: String, var body: String) {

}

class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(Engine: String, Body: String, Door: String) {
        this.engine = Engine
        this.body = Body
        this.door = Door
    }
    //constructor는 함수의 형태다. 인수를 갖는 생성자라고 생각하면 좋을 것 같다.
    //this는 현재의 클래스를 가리키는 것이다.
}

class Car1(engine: String, body: String) //Car1(engine, body)이것도 생성자다.
{
    var door: String = ""

    //이것도 생성자다.
    constructor(engine: String, body: String, door: String) : this(engine, body)  //Car1(engine,body)랑 같다.
    {
        this.door = door
    }
}

class Car2 {
    var engine: String = ""
    var body: String = ""
    var door: String = ""

    constructor(Engine: String, Body: String) {
        this.engine = Engine
        this.body = Body
    }

    constructor(Engine: String, Body: String, Door: String) {
        this.engine = Engine
        this.body = Body
        this.door = Door
    }
}

class RunableCar(engine: String, body: String) {
    fun ride() {
        println("탑승하겠습니다.")
    }

    fun run() {
        println("달립니다.")

    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정되었습니다.")
    }
}

class RunableCar2{
    var engine:String
    var body:String
    var door:String

    constructor(Engine: String,Body: String,Door: String){
        this.engine=Engine
        this.body=Body
        this.door=Door
    }

    init{
        Log.d("Runnable2가 만들어졌습니다.","runnable22")
    }
}


