package com.daada.hospitalmanagementmavenproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patient_id;

    private String patient_name;
    private String address;
    private int phone;
    private String dob;

    public Patient(int patient_id, String patient_name, String address, int phone, String dob) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
    }

    public Patient() {

    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
     return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDate() {
     return dob;
    }

    public void setDate(String dob) {
        this.dob = dob;
    }
}
