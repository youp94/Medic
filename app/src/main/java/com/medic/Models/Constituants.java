package com.medic.Models;

import java.util.ArrayList;

public class Constituants {

    String name;
    String grade;
    ArrayList<String> properties;
    float quantity;
    String ref;

    public Constituants(String name, String grade, ArrayList<String> properties, float quantity, String ref) {
        this.name = name;
        this.grade = grade;
        this.properties = properties;
        this.quantity = quantity;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ArrayList<String> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<String> properties) {
        this.properties = properties;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
