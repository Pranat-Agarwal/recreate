package com.example.recreate.kotlin

fun main(){
    var l : (Int,Int) -> Int ={ a:Int,b:Int -> a+b}
    println(l(10,20))

    fun square(x:Int)=x*x

    fun operation():(Int)->Int{
        return ::square
    }

    fun main(){
        val func=operation()
        println(func(2))
    }

    var lam :(Int)->Int={a->a*a}
}