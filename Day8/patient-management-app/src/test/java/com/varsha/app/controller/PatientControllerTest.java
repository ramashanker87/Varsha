package com.varsha.app.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
   public class PatientControllerTest {
    @InjectMocks
    PatientController patientController;

    @Test
    public void testGetAllPatient() {
        patientController.getAllPatient();
    }

    @Test
    public void testGetAllPatientByName() {
        patientController.getAllPatientByName();
    }

    @Test
    public void testCreatePatient() {
        patientController.createPatient();
    }

    @Test
    public void testUpdatePatient() {
        patientController.updatePatient();
    }

    @Test
    public void testDeletePatient() {
        patientController.deletePatient();
    }

}
