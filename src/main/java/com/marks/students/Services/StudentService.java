package com.marks.students.Services;

import com.marks.students.DAO.StudentAddRequest;
import com.marks.students.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marks.students.Models.Student;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(
            StudentRepository studentRepository
    ){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll(){
        return studentRepository.getStudents();
    }

    public Student add(StudentAddRequest request){
        Student student = studentRepository.findStudentByNameAndSurname(request.getName(), request.getSurname());
        if(student != null){
            return null;
        }
        student = new Student(request.getName(), request.getSurname());
        studentRepository.add(student.getUuid(), student.getName(), student.getSurname());
        return student;
    }

    public Student getByUuid(String uuid){
        return studentRepository.findStudentByStudentUuid(uuid);
    }

    public void delete(String uuid){
        studentRepository.delete(uuid);
    }
}
