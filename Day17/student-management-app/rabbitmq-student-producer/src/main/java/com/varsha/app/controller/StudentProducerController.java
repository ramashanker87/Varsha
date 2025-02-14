package com.varsha.app.controller;

import com.varsha.app.model.Student;
import com.varsha.app.respository.StudentRespository;
import com.varsha.app.service.RabbitMqSender;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/student")
public class StudentProducerController {
    private static Logger logger = LoggerFactory.getLogger(StudentProducerController.class);
    private final RabbitMqSender rabbitMqSender;
    private final StudentRespository studentRespository;
    public StudentProducerController(RabbitMqSender rabbitMqSender,StudentRespository studentRespository){
        this.rabbitMqSender = rabbitMqSender;
        this.studentRespository = studentRespository;}
    @PostMapping("/save")
    public Student student(@RequestBody Student student) {
        rabbitMqSender.sendStudent(student);
        studentRespository.save(student);
        return student;
    }
    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam String name) {
        rabbitMqSender.deleteName(name);
        studentRespository.deleteName(name);
    }
}
