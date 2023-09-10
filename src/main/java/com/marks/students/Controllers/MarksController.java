package com.marks.students.Controllers;

import com.marks.students.DAO.MarkAddRequest;
import com.marks.students.DAO.MarkUpdateRequest;
import com.marks.students.Models.Mark;
import com.marks.students.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/marks")
public class MarksController {

    private MarkService markService;

    @Autowired
    public MarksController(
            MarkService markService
    ) {
        this.markService = markService;
    }

    @GetMapping("/")
    public List<Mark> getMarks(){
        return markService.getAll();
    }

    @GetMapping("/mark")
    public Mark getMark(@RequestParam("date")Integer date, @RequestParam("uuid") String uuid){
        return markService.getMarkByDateAndUuid(date, uuid);
    }

    @PostMapping("/add")
    public Mark add(@RequestBody MarkAddRequest request){
        return markService.add(request);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody MarkUpdateRequest request){
        markService.update(request);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(@RequestParam("date") Integer date, @RequestParam("uuid") String uuid){
        markService.delete(date, uuid);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
