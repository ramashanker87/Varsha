package com.varsha.app.controller;

import com.varsha.app.model.Patient;
import com.varsha.app.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @InjectMocks
    PatientController patientController;

    @Mock
    PatientService patientService;

    @Test
    public void testGetAllPatients() {
        Map<String, Patient> patientMap = new HashMap<>();
        Patient p1 = new Patient("roney", "PA1", "Civil Hospital", 23, "Male");
        Patient p2 = new Patient("ankit", "PA2", "Super Hospital", 24, "Male");
        Patient p3 = new Patient("muskan", "PA3", "Non Hospital", 30, "Female");

        patientMap.put(p1.getId(),p1);
        patientMap.put(p2.getId(),p2);
        patientMap.put(p3.getId(),p3);

        when(patientService.readAllPatients()).thenReturn(patientMap);
        Map<String,Patient> resultPatientMap =patientController.getAllPatients();

        assert resultPatientMap!=null;
        assert resultPatientMap.size()==3;
        assert resultPatientMap.get(p1.getId())==p1;
        assert resultPatientMap.get(p2.getId())==p2;
        assert resultPatientMap.get(p3.getId())==p3;

    }

    @Test
    public void testSavePatient(){
        Patient p1 = new Patient("roney", "PA1", "Civil Hospital", 23, "Male");
        when(patientService.savePatient(p1)).thenReturn(p1);
        Patient resultP1 = patientController.createPatients(p1);
        assert resultP1!=null;
        assert resultP1.getId()==p1.getId();
        assert resultP1.getName()==p1.getName();
        assert resultP1.getAge()==p1.getAge();
        assert resultP1.getGender()== p1.getGender();
        assert resultP1.getHospitalName()==p1.getHospitalName();

    }

    @Test
    public void testUpdatePatient(){
        Patient p1 = new Patient("roney", "PA1", "Civil Hospital", 23, "Male");
        when(patientService.updatePatient(anyString(),anyString())).thenReturn(p1);
        Patient resultPatient = patientController.updatePatients(p1.getId(),"roney");
        assert resultPatient!=null;
        assert resultPatient.getId()==p1.getId();
        assert resultPatient.getName().equals("roney");

    }

    @Test
    public void testDeletePatient(){
        doNothing().when(patientService).deletePatient(anyString());
        patientController.deletePatients("PA1");
        verify( patientService,atLeast(1)).deletePatient(anyString());
    }

}
