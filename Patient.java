package com.hospital.management;

public class Patient{
    private static int idcounter = 0;
    private int id;
    private String name;
    private String gender;
    private int age;

    public Patient(String name, String gender, int age){
        this.id = ++idcounter;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public int getid(){
        return id;
    }
    public String toString(){
        return "Patient ID: "+id + ", Name: "+name+ ", Gender: "+ gender+ ", Age: "+age;
    }
    
}
