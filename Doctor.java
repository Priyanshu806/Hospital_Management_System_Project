package com.hospital.management;

public class Doctor {
    private static int idcounter = 0;
    private int id;
    private String name;
    private String spec;

    public Doctor(String name, String spec){
        this.id = ++idcounter;
        this.name = name;
        this.spec = spec;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return "Doctor ID: " + id + ", Name: " + name + ", Speciality: " + spec;
    }
}