package com.daada.hospitalmanagementmavenproject.DoctorRepository;

import com.daada.hospitalmanagementmavenproject.Doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
