package com.example.demo.controller;

import com.example.demo.entity.College;
import com.example.demo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @PostMapping
    public College createCollege(@RequestBody College college) {
        return collegeService.saveCollege(college);
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        return collegeService.findById(id)
                .map(college -> ResponseEntity.ok().body(college))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Long id, @RequestBody College collegeDetails) {
        return collegeService.findById(id)
                .map(college -> {
                    college.setCollegeName(collegeDetails.getCollegeName());
                    college.setLocation(collegeDetails.getLocation());
                    College updatedCollege = collegeService.saveCollege(college);
                    return ResponseEntity.ok().body(updatedCollege);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCollege(@PathVariable Long id) {
        return collegeService.findById(id)
                .map(college -> {
                    collegeService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
