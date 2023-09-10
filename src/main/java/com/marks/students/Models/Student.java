package com.marks.students.Models;

import jakarta.annotation.Generated;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

@Data
@Getter
@Setter
@Table(name="students")
@NoArgsConstructor
public class Student {
    @Column("uuid")
    private String uuid;
    @Column("name")
    private String name;
    @Column("surname")
    private String surname;

    public Student(
            String name,
            String surname
    ){
        this.uuid = UUID.randomUUID().toString();;
        this.name = name;
        this.surname = surname;
    }

}
