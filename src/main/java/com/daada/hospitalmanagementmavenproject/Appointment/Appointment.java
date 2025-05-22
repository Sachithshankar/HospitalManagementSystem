package com.daada.hospitalmanagementmavenproject.Appointment;

import jakarta.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int appointment_id;

    public int patient_id;
    public int doctor_id;
    public String appointment_date;
    public String consulting_for;
    public String status;

    public Appointment(int appointment_id, String appointment_date, int patient_id, int doctor_id, String consulting_for, String status) {

    }

    public Appointment() {

    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getConsulted_for() {
        return consulting_for;
    }

    public void setConsulted_for(String consulting_for) {
        this.consulting_for = consulting_for;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
