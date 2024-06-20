package com.example.recreate.java;

public class demo {
    public static  void  main( String [] args){
        jprints m =new jprints();
        m.send();

        jprint rint =() -> {
            System.out.println("go");
        };
        rint.send();
    }
}
