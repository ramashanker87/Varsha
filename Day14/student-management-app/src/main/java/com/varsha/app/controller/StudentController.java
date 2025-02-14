package com.varsha.app.controller;
import com.varsha.app.model.Student;
import com.varsha.app.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/read")
    public Iterable<Student> read() {
        return studentRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody final Student student) {
        System.out.println("Saving student: " + student);
        studentRepository.save(student);
        return "save";
    }
}

