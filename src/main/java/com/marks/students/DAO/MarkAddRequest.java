package com.marks.students.DAO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MarkAddRequest {
    private Integer point;
    private Integer date;
    private String uuid;
}
