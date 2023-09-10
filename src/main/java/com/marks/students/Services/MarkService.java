package com.marks.students.Services;

import com.marks.students.DAO.MarkAddRequest;
import com.marks.students.DAO.MarkUpdateRequest;
import com.marks.students.Models.Mark;
import com.marks.students.Repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MarkService {

    private MarkRepository markRepository;

    @Autowired
    public MarkService(
            MarkRepository markRepository
    ) {
        this.markRepository = markRepository;
    }

    public List<Mark> getAll(){
        return markRepository.getMarks();
    }

    public Mark getMarkByDateAndUuid(Integer date, String uuid){
        return markRepository.findMarkByDateAndStudentUuid(date, uuid);
    }

    public Mark add(MarkAddRequest request){
        Mark mark = markRepository.findMarkByDateAndStudentUuid(request.getDate(), request.getUuid());
        if(mark != null){
            return null;
        }
        mark = new Mark(request.getPoint(), request.getDate(), request.getUuid());
        markRepository.add(request.getPoint(), request.getDate(), request.getUuid());
        return mark;
    }

    public void update(MarkUpdateRequest request){
        markRepository.update(request.getPoint(), request.getDate(), request.getUuid());
    }

    public void delete(Integer date, String uuid){
        markRepository.delete(date, uuid);
    }

}
