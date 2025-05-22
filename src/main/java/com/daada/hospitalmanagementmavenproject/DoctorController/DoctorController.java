package com.daada.hospitalmanagementmavenproject.DoctorController;

import com.daada.hospitalmanagementmavenproject.Doctor.Doctor;
import com.daada.hospitalmanagementmavenproject.DoctorService.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    Logger log =  LoggerFactory.getLogger(DoctorController.class);
    @GetMapping
    public List<Doctor> findAllDoctors() {
        log.info("API call: Get All Doctors");
        return doctorService.findAllDoctors();
    }

    @GetMapping("/{doctor_id}")
    public Doctor findDoctorById(@PathVariable int doctor_id) {
        log.info("API call: Get Doctor with id: "+doctor_id);
        return doctorService.findDoctorById(doctor_id);
    }
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        log.info("API call: Add Doctor with id: " +doctor);
        return doctorService.createDoctor(doctor);
    }
    @DeleteMapping("/{doctor_id}")
    public void deleteDoctorById(@PathVariable int doctor_id) {
        log.warn("API call: Delete Doctor with id: "+ doctor_id);
        doctorService.deleterDoctorById(doctor_id);
    }
}
