package com.varsha.app.service;



import com.varsha.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

    @Service
    public class PatientService {

        Map<String, Patient> patients = new HashMap<>();

        public Map<String, Patient> readAllPatients() {
            return patients;
        }

        public Patient savePatient(Patient patient) {
            patients.put(patient.getId(),patient);
            return patient;
        }

        public Patient updatePatient(String id, String name) {
            Patient patient = patients.get(id);
            patient.setHospitalName(name);
            return patient;
        }

        public void deletePatient(String id) {
            patients.remove(id);
        }


    }

