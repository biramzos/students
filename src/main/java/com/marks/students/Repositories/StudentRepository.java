package com.marks.students.Repositories;

import com.marks.students.Models.Student;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    @Query("SELECT * FROM students")
    List<Student> getStudents();
    @Query("SELECT * FROM students WHERE students.name=:name AND students.surname=:surname")
    Student findStudentByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
    @Query("SELECT * FROM students WHERE students.uuid=:uuid")
    Student findStudentByStudentUuid(@Param("uuid") String uuid);
    @Modifying
    @Query(value="INSERT INTO students value (:uuid, :name, :surname)")
    void add(@Param("uuid") String uuid, @Param("name") String name, @Param("surname") String surname);
    @Modifying
    @Query(value="DELETE FROM students WHERE students.uuid=:uuid")
    void delete(@Param("uuid") String uuid);
}
