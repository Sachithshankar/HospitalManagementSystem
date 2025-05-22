package com.daada.hospitalmanagementmavenproject.DoctorService;

import com.daada.hospitalmanagementmavenproject.Doctor.Doctor;
import com.daada.hospitalmanagementmavenproject.DoctorRepository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    Logger log =  LoggerFactory.getLogger(DoctorService.class);

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctorById(int doctor_id) {
        log.info("Getting the doctor with id: "+doctor_id);
        return doctorRepository.findById(doctor_id).orElse(null);
    }

    public Doctor createDoctor(Doctor doctor) {
        log.info("Creating a new doctor ");
        return doctorRepository.save(doctor);
    }

    public void deleterDoctorById(int doctor_id) {
        log.warn("Deleting doctor with id: "+doctor_id);
        doctorRepository.deleteById(doctor_id);
    }
}
