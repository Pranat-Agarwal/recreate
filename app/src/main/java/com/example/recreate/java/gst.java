package com.example.recreate.java;

public class gst extends income{

    String phone;

    int caltax(int tax){
        int oldtax=super.caltax(tax);
        int newtax=1000;
        return oldtax+newtax;
    }
}
