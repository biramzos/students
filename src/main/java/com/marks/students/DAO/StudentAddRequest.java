package com.marks.students.DAO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class StudentAddRequest {
    private String name;
    private String surname;
}
