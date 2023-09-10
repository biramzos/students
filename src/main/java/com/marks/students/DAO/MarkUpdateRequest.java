package com.marks.students.DAO;

import jdk.jfr.StackTrace;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MarkUpdateRequest {
    private Integer point;
    private Integer date;
    private String uuid;
}
