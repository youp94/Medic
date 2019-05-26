package com.medic.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Constituant implements Serializable {

    String name;
    String grade;
    String properties;
    double quantity;
    String ref;
    String unit;

    public Constituant(String name, String grade, String properties, double quantity, String ref, String unit) {
        this.name = name;
        this.grade = grade;
        this.properties = properties;
        this.quantity = quantity;
        this.ref = ref;
        this.unit = unit;
    }

    public Constituant(String name, String grade, String properties, double quantity, String ref) {
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

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
