package com.daada.hospitalmanagementmavenproject.AppointmentRepository;

import com.daada.hospitalmanagementmavenproject.Appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
