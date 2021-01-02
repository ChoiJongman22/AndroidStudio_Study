package com.jongman22.todolist_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

    }

}


class TV(val channels: List<String>) {
    var onOroff: Boolean = false //True : On False : Off

    fun switch(){
        onOroff = !onOroff
    }

}


//이 계좌 클래스는 마이너스 통장을 지원한다.
//돈이 없는 생활은 괜찮아도 빚있는 생활은 진짜 안되니까.
class Account(var Name: String, var Date: String, var Balance: Int) {

    fun checkBalance(): Int {
        return Balance
    }

    fun withdraw(amount: Int): Boolean {
        if (Balance >= amount) {
            Balance -= amount
            return true
        } else {
            return false
        }
        //return Balance >= amount
    }

    fun save(amount: Int) {
        Balance += amount
    }
}

class Account2 {

    var name: String
    var date: String
    var balance: Int

    constructor(Name: String, Date: String, Balance: Int) {
        this.name = Name
        this.date = Date
        //이 부분을 관리해주어야 한다.
        //생성자를 통해서 관리해줄 수 있다.
        if (Balance >= 0) {
            this.balance = Balance
        } else {
            this.balance = 0
        }

    }

    fun checkBalance(): Int {
        return balance
    }

    fun withdraw(amount: Int): Boolean {
        if (balance >= amount) {
            balance -= amount
            return true
        } else {
            return false
        }
        //return Balance >= amount
    }

    fun save(amount: Int) {
        balance += amount
    }
}

//생성자에 default값 넣어주기
class Account3(var Name: String, var Date: String, var Balance: Int = 1000) {

    fun checkBalance(): Int {
        return Balance
    }

    fun withdraw(amount: Int): Boolean {
        if (Balance >= amount) {
            Balance -= amount
            return true
        } else {
            return false
        }
        //return Balance >= amount
    }

    fun save(amount: Int) {
        Balance += amount
    }
}

class Account4(initialBalance: Int) {

    val balance: Int = if (initialBalance >= 0) initialBalance else 0
    fun checkBalance(): Int {
        //return initialBalance 이건 안된다!! 생성자에 있는 val/var로 안되어있는 변수는 바로 리턴불가
        return balance
    }

}


class Operator() {
    fun plus(a: Int, b: Int): Int {
        return a + b
    }

    fun minus(a: Int, b: Int): Int {
        return a - b
    }

    fun multi(a: Int, b: Int): Int {
        return a * b
    }

    fun divi(a: Int, b: Int): Int {
        return a / b
    }
}

class Operator2() {
    fun plus(vararg number: Int): Int {
        var result = 0
        number.forEach {
            result = result + it
        }
        return result
    }

    fun minus(vararg number: Int): Int {
        var result: Int = number[0]
        for (i in 0 until number.size) {
            if (i != 0) {
                result -= number[i]
            }
        }
        return result
    }

    fun multi(vararg number: Int): Int {
        var result: Int = 1 //0으로 두면 안 된다.
        number.forEach {
            result = result * it
        }
        return result
    }

    fun divide(vararg number: Int): Int {
        var result: Int = number[0] //0으로 두면 안 된다.
        number.forEachIndexed { index, value ->
            if (index != 0 && value != 0) {
                result /= value
            }
        }
        return result
    }
}

class Operator3(val initialValue: Int) {
    fun plus(number: Int): Operator3 {
        val result = this.initialValue + number
        return Operator3(result)
    }

    fun minus(number: Int): Operator3 {
        val result = this.initialValue - number
        return Operator3(result)
    }

    fun multi(number: Int): Operator3 {
        val result = this.initialValue * number
        return Operator3(result)
    }

    fun divide(number: Int): Operator3 {
        val result = this.initialValue / number
        return Operator3(result)
    }
}

