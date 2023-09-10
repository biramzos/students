package com.marks.students.Repositories;

import com.marks.students.Models.Mark;
import com.marks.students.Models.Student;
import org.springframework.cglib.core.Local;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark, String> {
    @Modifying
    @Query(value="INSERT INTO marks VALUE (:point, :date, :uuid)")
    void add(@Param("point") Integer point, @Param("date") Integer date, @Param("uuid") String uuid);
    @Query("SELECT * FROM marks")
    List<Mark> getMarks();
    @Query("SELECT * FROM marks WHERE marks.date=:date AND marks.uuid=:uuid")
    Mark findMarkByDateAndStudentUuid(@Param("date")Integer date, @Param("uuid") String uuid);
    @Modifying
    @Query(value="DELETE FROM marks WHERE marks.date=:date AND marks.uuid=:uuid")
    void delete(@Param("date") Integer date, @Param("uuid") String uuid);
    @Modifying
    @Query(value="UPDATE marks SET marks.point=:point WHERE marks.date=:date AND marks.uuid=:uuid")
    void update(@Param("point") Integer point, @Param("date") Integer date, @Param("uuid") String uuid);

}
