package com.varsha.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @GetMapping("/get/all/patient")
    public void getAllPatient() {
    }
    @GetMapping("/get/patient")
    public void getAllPatientByName() {
    }
    @PostMapping("/create/patient")
    public void createPatient() {
    }
    @PutMapping("/update/patient")
    public void updatePatient() {
    }
    @DeleteMapping("delete/patient")
    public void deletePatient() {
    }
}
