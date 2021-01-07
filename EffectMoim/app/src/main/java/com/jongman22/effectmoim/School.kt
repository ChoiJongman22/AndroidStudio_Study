package com.jongman22.effectmoim

import io.realm.RealmObject


//Realm을 사용하기 위해 Table을 만듬

open class School : RealmObject() {
    var name: String? = null
    var location: String? = null
}