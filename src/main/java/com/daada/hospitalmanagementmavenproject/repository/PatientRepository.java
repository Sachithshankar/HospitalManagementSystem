package com.daada.hospitalmanagementmavenproject.repository;

import com.daada.hospitalmanagementmavenproject.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
