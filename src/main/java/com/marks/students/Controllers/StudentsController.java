package com.marks.students.Controllers;

import com.marks.students.DAO.StudentAddRequest;
import com.marks.students.Models.Student;
import com.marks.students.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/students")
public class StudentsController {

    private StudentService studentService;

    @Autowired
    public StudentsController(
            StudentService studentService
    ){
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> students(){
        return studentService.getAll();
    }

    @GetMapping("/{studentUuid}")
    public Student getStudentByStudentUuid(@PathVariable("studentUuid") String uuid){
        return studentService.getByUuid(uuid);
    }

    @PostMapping("/add")
    public Student add(@RequestBody StudentAddRequest request){
        return studentService.add(request);
    }

    @GetMapping("/remove/{uuid}")
    public ResponseEntity removeStudent(@PathVariable("uuid") String uuid){
        studentService.delete(uuid);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
