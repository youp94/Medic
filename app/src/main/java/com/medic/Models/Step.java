package com.medic.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Step implements Serializable {

    private String desc;
    private ArrayList<Equipment> equipments;

    public Step() {
    }

    public Step(String desc) {
        this.desc = desc;
    }

    public Step(String desc, ArrayList<Equipment> equipments) {
        this.desc = desc;
        this.equipments = equipments;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(ArrayList<Equipment> equipments) {
        this.equipments = equipments;
    }
}
