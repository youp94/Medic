package com.medic.Models;

import java.util.ArrayList;

public class Step {

    private String desc;
    private ArrayList<Equipment> equipments;

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
