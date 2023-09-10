package com.marks.students.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Table(name="marks")
public class Mark {
    private Integer point;
    private Integer date;
    private String uuid;

    public Mark(
            Integer point,
            Integer date,
            String uuid
    ) {
        this.point = point;
        this.date = date;
        this.uuid = uuid;
    }
}
