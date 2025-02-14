package com.varsha.app.controller;

import com.varsha.app.model.Patient;
import com.varsha.app.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/age/all")
    public Map<String, Patient> getAllPatients(){
        return patientService.readAllPatients();
    }

    @PostMapping("/save")
    public Patient createPatients(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }
    @PutMapping("/update")
    public Patient updatePatients(@RequestParam("id") String id,@RequestParam("hospitalName") String name) {
        return patientService.updatePatient(id,name);
    }
    @DeleteMapping("/delete")
    public void deletePatients(@RequestParam("id") String id) {
        patientService.deletePatient(id);
    }




}

