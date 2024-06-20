package com.example.recreate.kotlin

fun main(){

    var name:String="Pranat"
    println(name.commaseparated("some other string"))

    fun commaseparated(values:String):String{
        return "comma separated string "+values
    }
}