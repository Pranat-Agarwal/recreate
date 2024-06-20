package com.example.recreate.java;

public class student {
    String name;
    int age;
    String pa;

    public student(String name, int age, String pa){
        this.name=name;
        this.age=age;
        this.pa=pa;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(){
        this.age=age;
    }

    public String getPa(){
        return pa;
    }

    public void setPa(){
        this.pa=pa;
    }
}
