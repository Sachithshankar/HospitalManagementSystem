package com.daada.hospitalmanagementmavenproject.Billing;

import jakarta.persistence.*;

@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int billing_id;

    public int patient_id;
    public int appointment_id;
    public int total_amount;
    public String billing_date;

    public Billing(int billing_id, int patient_id, int appointment_id, String billing_date, int total_amount) {
    }

    public Billing() {

    }

    public int getBilling_id(int billing_id) {
        return billing_id;
    }

    public void setBilling_id() {
        this.billing_id = billing_id;
    }

    public int getPatient_id(int patient_id) {
        return patient_id;
    }

    public void setPatient_id() {
        this.patient_id = patient_id;
    }

    public int getAppointment_id(int appointment_id) {
        return appointment_id;
    }

    public void setAppointment_id() {
        this.appointment_id = appointment_id;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount() {
        this.total_amount = total_amount;
    }
}
