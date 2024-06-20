package com.example.recreate.kotlin

fun main(){

    class sq(val side:Int){
        init {
            println(side*side)
        }
    }

    var s=sq(5)
}