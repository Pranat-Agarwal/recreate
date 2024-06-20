package com.example.recreate.kotlin

fun main(){
    val a=20
    val b=30
    if(a>b){
        println(a)
    }
    else{
        println(b)
    }
    val pets= arrayOf("cat","dog","cow")
    for(elements in pets){
        print(elements+"")
    }

    for((index,element) in pets.withIndex()){
        print("Item at $index is $element")
    }

    for(i in 1 .. 5)print(i)

    fun printhello(name:String?){
        println(name)
    }

    fun drive(speed: String ="fast"){
        println("drive $speed")
    }

    printhello("hello")
    drive()
    drive("slow")

    fun today(day:String,temp:Int){
        println("$day  $temp")
    }
    today("mon",6)
    today(temp=5,day="wed")

    fun add(first:Int,second:Int,operation:Char):Int{
        return first+second
    }

    add(10,20,"+")

    fun double(x:Int):Int=x*2
}