package com.example.recreate.java;

public class employee {
        String name;
        int age;
        String pa;

        public employee(String name, int age, String pa){
            student vit = new student("pranat",20,"meerut");
            System.out.println(vit.getName());
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
