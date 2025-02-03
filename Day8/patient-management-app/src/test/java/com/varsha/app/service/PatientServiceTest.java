package com.varsha.app.service;


import com.varsha.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {
    @InjectMocks
    private PatientService patientService;

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("p1","patient1",55,"hospital1","M");
        Patient expectedPatient = patientService.createPatient(patient);
        assert expectedPatient != null;
        assert expectedPatient.getId() == patient.getId();
        assert expectedPatient.getAge() == patient.getAge();
        assert expectedPatient.getName()==patient.getName();
        assert expectedPatient.getHospitalName()==patient.getHospitalName();
        assert expectedPatient.getGender()==patient.getGender();
    }

    @Test
    public void testUpdatePatient() {
        Patient patient1 = new Patient("p1","patient1",55,"hospital1","M");
        Patient expectedPatient = patientService.createPatient(patient1);
        //Patient patient2 = new Patient("p2","patient2",46);
        Patient resultPatient =  patientService.updatePatient(patient1,"hospital9");
        assert resultPatient != null;
        assert resultPatient.getId() == patient1.getId();
        assert resultPatient.getAge() == patient1.getAge();
        assert resultPatient.getName() == patient1.getName();
        assert resultPatient.getGender() == patient1.getGender();
        assert resultPatient.getHospitalName() == "hospital9";
    }

    @Test
    public void testDeletePatient() {
        Patient patient1 = new Patient("p1","patient1",55,"hospital1","M");
        Patient expectedPatient = patientService.createPatient(patient1);
        patientService.deletePatient(patient1.getId());
        Patient expectedResult = patientService.readPatientById(patient1.getId());
        assert expectedResult == null;
    }

    @Test
    public void testReadPatientById(){
        Patient patient1 = new Patient("p1","patient1",55,"hospital1","M");
        Patient actualPatient = patientService.createPatient(patient1);
        Patient expectedResult= patientService.readPatientById(patient1.getId());
        assert expectedResult != null;
        assert expectedResult.getName()== actualPatient.getName();
        assert expectedResult.getId()== actualPatient.getId();
        assert expectedResult.getAge()== actualPatient.getAge();
        assert expectedResult.getHospitalName()== actualPatient.getHospitalName();
        assert expectedResult.getGender() == actualPatient.getGender();
    }
}
