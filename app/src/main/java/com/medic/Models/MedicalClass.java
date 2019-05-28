package com.medic.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class MedicalClass implements Serializable {


    private String id;
    private String name;
    private String description;
    private ArrayList<Medic> medicArrayList;

    public MedicalClass(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public MedicalClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public MedicalClass(String name, String description, ArrayList<Medic> medicArrayList) {
        this.name = name;
        this.description = description;
        this.medicArrayList = medicArrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Medic> getMedicArrayList() {
        return medicArrayList;
    }

    public void setMedicArrayList(ArrayList<Medic> medicArrayList) {
        this.medicArrayList = medicArrayList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
