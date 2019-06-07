package com.medic.Models;

import java.io.Serializable;

public class Step implements Serializable {

    private String desc;
    Equipment equipments;

    public Step() {
    }

    public Step(String desc) {
        this.desc = desc;
    }

    public Step(String desc, Equipment equipments) {
        this.desc = desc;
        this.equipments = equipments;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Equipment getEquipments() {
        return equipments;
    }

    public void setEquipments(Equipment equipments) {
        this.equipments = equipments;
    }
}
