package com.example.jarnin.quickmed;

/**
 * Created by jarnin on 5/20/16.
 */
public class Patient {
    private int age, weight, height;
    private String name;

    //Setters and Getters
    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}