
package com.varsha.app.controller;

import com.varsha.app.controller.PatientController;
import com.varsha.app.model.Patient;
import com.varsha.app.service.PatientService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    PatientController patientController;
    @Mock
    PatientService patientService;

    @Test
    public void testGetAllPatient() {
        Map<String, Patient> patientMap = new HashMap<>();
        Patient patient1 = new Patient("p1","patient1",55,"hospital1","M");
        Patient patient2 = new Patient("p2","patient2",43,"hospital2","M");
        Patient patient3 = new Patient("p3","patient3",32,"hospital3","F");
        patientMap.put(patient1.getId(), patient1);
        patientMap.put(patient2.getId(), patient2);
        patientMap.put(patient3.getId(), patient3);
        when(patientService.readAllPatient()).thenReturn(patientMap);
        Map<String, Patient> employeeResultMap=patientController.getAllPatient();
        assert patientResultMap!=null;
        assert patientResultMap.size()==3;
        assert patientResultMap.get(patient1.getId())==patient1;
        assert patientResultMap.get(patient2.getId())==patient2;
        assert patientResultMap.get(patient3.getId())==patient3;
    }

    @Test
    public void testCreatePatient() {
        Patient patient1 = new Patient("p1","patient1",55,"hospital1","M");
        when(patientService.createPatient(patient1)).thenReturn(patient1);
        Patient resultEmployee=patientController.createPatient(patient1);
        assert resultPatient!=null;
        assert resultPatient.getId()==patient1.getId();
        assert resultPatient.getName().equals("Emp1");
        assert resultPatient.getAge()==25;
    }
    @Test
    public void testUpdatePatient() {
        Patient patient1 = new Patient("p1","patient1",55,"hospital1","M");
        Patient patient2 = new Patient("p2","patient2",43,"hospital2","M");
        when(patientService.updatePatient(anyString(),anyInt())).thenReturn(patient2);
        Patient resultPatient=patientController.updatePatient(patient1.getId(),26);
        assert resultPatient!=null;
        assert resultPatient.getId()==patient2.getId();
        assert resultPatient.getName().equals("Patient2");
        assert resultPatient.getAge()==43;
    }
    @Test
    public void testDeletePatient() {
        doNothing().when(patientService).deletePatient(anyString());
        patientController.deletePatient("1");
        verify( patientService, atLeast(1)).deletePatient(anyString());
    }
    @Test
    public void testGetPatientByName() {
        patientController.getAllPatientByName();
    }

}
