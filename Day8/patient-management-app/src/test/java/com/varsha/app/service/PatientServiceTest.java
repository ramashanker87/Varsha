package com.varsha.app.service;

import com.varsha.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {
    @InjectMocks
    PatientService patientService;

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("p1","patient1",55,"hospital1","M");
        Patient expectedPatient=patientService.createPatient(patient);
        assert expectedPatient != null;
        assert expectedPatient.getId()== patient.getId();
        assert expectedPatient.getName()== patient.getName();
        assert expectedPatient.getAge()== patient.getAge();
        assert expectedPatient.getHospitalName()==patient.getHospitalName();
        assert expectedPatient.getGender()==patient.getGender();
    }

    @Test
    public void testUpdatePatient() {
        Patient patient1 = new Patient("p1","patient1",55,"hospital1","M");
        Patient expectedPatient=patientService.createPatient(patient1);
        Patient resultPatient=patientService.updatePatient(patient1.getId(),"hospital9");
        assert resultPatient != null;
        assert resultPatient.getId()== patient1.getId();
        assert resultPatient.getName()== patient1.getName();
        assert resultPatient.getAge()== patient1.getAge();
        assert resultPatient.getGender() == patient1.getGender();
        assert resultPatient.getHospitalName() == "hospital9";
    }

    @Test
    public void testDeletePatient() {
        Patient patient1 = new Patient("p1","patient1",55,"hospital1","M");
        Patient expectedPatient=patientService.createPatient(patient1);
        patientService.deletePatient(patient1.getName());
        Patient expectedResult=patientService.readPatientByName(patient1.getName());
        assert expectedResult== null;

    }
    @Test
    public void testReadPatientBYName() {
        Patient patient1 = new Patient("p1","patient1",55,"hospital1","M");
        Patient actualPatient=patientService.createPatient(patient1);
        Patient expectedResult=patientService.readPatientByName(patient1.getId());
        assert expectedResult != null;
        assert expectedResult.getId()== actualPatient.getId();
        assert expectedResult.getName()== actualPatient.getName();
        assert expectedResult.getAge()== actualPatient.getAge();
    }
    @Test
    public void testReadAllPatient() {
        Patient patient1 = new Patient("p1","patient1",55,"hospital1","M");
        Patient patient2 = new Patient("p2","patient2",43,"hospital2","M");
        Patient patient3 = new Patient("p3","patient3",32,"hospital3","F");
        patientService.createPatient(patient1);
        patientService.createPatient(patient2);
        patientService.createPatient(patient3);
        Map<String,Patient> resultPatient= patientService.readAllPatient();
        assert resultPatient.size()==3;
        assert resultPatient.containsKey(patient1.getId());
        assert resultPatient.containsKey(patient2.getId());
        assert resultPatient.containsKey(patient3.getId());
    }
}

