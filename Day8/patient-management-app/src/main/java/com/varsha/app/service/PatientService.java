/*package com.varsha.app.service;


import com.varsha.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {

    Map<String, Patient> patients = new HashMap<String, Patient>();

   /*public void save(Patient patient) {
        patients.put(patient.getId(), patient);
    }*/

   /* public Patient createPatient(Patient patient) {
        patients.put(patient.getId(), patient);
        return patient;
    }

    public Patient updatePatient(Patient patient, String newhospitalName) {
        Patient patient1 =patients.get(patient.getId());
        patient1.setHospitalName(newhospitalName);
        return patient1;
    }

    public void deletePatient(String id) {
        patients.remove(id);
    }

    public Patient readPatientById(String id) {
       Patient result = patients.get(id);
       return result;
    }
    //public Map<String,Patient> readAllPatient() {
      //  return patients;
    //}
}*/

package com.varsha.app.service;

import com.varsha.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {
    Map<String, Patient> patient = new HashMap<String, Patient>();

    public Patient createPatient(Patient patient) {
        patients.put(patient.getId(),patient);
        return patient;
    }

    public Patient updatePatient(String id, int newhospitalName) {
        Patient patient1= patient.get(id);
        patient1.setHospitalName(newhospitalName);
        return patient1;
    }

    public void deletePatient(String id) {
        patient.remove(id);
    }

    public Patient readPatientById(String name) {
        Patient result=patient.get(name);
        return result;
    }
    public Map<String,Patient> readAllPatient() {
        return patient;
    }
}

