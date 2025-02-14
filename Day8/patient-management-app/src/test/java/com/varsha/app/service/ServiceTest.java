package com.varsha.app.service;
import com.varsha.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
        import static org.mockito.Mockito.atLeast;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @InjectMocks
    PatientService patientService;

    @Test
    public void testSavePatient(){
        Patient p1 = new Patient("roney", "PA1", "Civil Hospital", 23, "Male");
        Patient resultP1 = patientService.savePatient(p1);
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
        Patient p2 = new Patient("ankit", "PA2", "Super Hospital", 24, "Male");
        Patient resultP1 = patientService.savePatient(p1);
        Patient resultP2 = patientService.savePatient(p2);
        Patient resultPatient = patientService.updatePatient(p1.getId(),"Civil Hospital");
        assert resultPatient!=null;
        assert resultPatient.getId()==p1.getId();
        assert resultPatient.getHospitalName().equals("Civil Hospital");

    }

    @Test
    public void testDeletePatient(){
        Patient p1 = new Patient("roney", "PA1", "Civil Hospital", 23, "Male");
        Patient resultP1 = patientService.savePatient(p1);
        patientService.deletePatient(p1.getId());
        Map<String,Patient> resultMap= patientService.readAllPatients();
        System.out.println(resultMap);
        assert resultMap.isEmpty();
    }

    @Test
    public void testReadAllPatients(){
        Patient p1 = new Patient("roney", "PA1", "Civil Hospital", 23, "Male");
        Patient p2 = new Patient("ankit", "PA2", "Super Hospital", 24, "Male");
        Patient p3 = new Patient("muskan", "PA3", "Non Hospital", 30, "Female");
        patientService.savePatient(p1);
        patientService.savePatient(p2);
        patientService.savePatient(p3);
        Map<String,Patient> resultMap = patientService.readAllPatients();
        assert resultMap.size()==3;
        assert resultMap.containsKey(p1.getId());
        assert resultMap.containsKey(p2.getId());
        assert resultMap.containsKey(p3.getId());
    }

}
