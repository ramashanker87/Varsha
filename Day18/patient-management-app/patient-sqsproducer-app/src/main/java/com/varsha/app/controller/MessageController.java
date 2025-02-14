package com.varsha.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.varsha.app.model.Patient;
import com.varsha.app.service.PatientSqsService;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class MessageController {

    private final PatientSqsService patientSqsService;
    private final ObjectMapper objectMapper;

    public MessageController(PatientSqsService patientSqsService, ObjectMapper objectMapper) {
        this.patientSqsService = patientSqsService;
        this.objectMapper = objectMapper;
    }
    @PostMapping("/send")
    public String sendMessage(@RequestBody Patient patient, @RequestHeader("disease") String disease) throws JsonProcessingException {
        Map<String, Object> headers = new HashMap<>();
        String correlationId = UUID.randomUUID().toString();
        headers.put("disease", disease);
        headers.put("correlationId", correlationId);
        String requestMessage = objectMapper.writeValueAsString(patient);
        patientSqsService.sendMessage(requestMessage, headers);
        return disease;

    }

}
