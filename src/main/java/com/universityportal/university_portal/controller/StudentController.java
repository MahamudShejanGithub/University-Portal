package com.universityportal.university_portal.controller;


import com.universityportal.university_portal.dto.EnrollmentRequest;
import com.universityportal.university_portal.entity.Course;
import com.universityportal.university_portal.entity.Result;
import com.universityportal.university_portal.entity.Student;
import com.universityportal.university_portal.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Student> getProfile(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getProfile(id));
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok(studentService.getAvailableCourses());
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enroll(@RequestBody EnrollmentRequest request) {
        String message = studentService.enrollInCourse(request.getStudentId(), request.getCourseId());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/results/{id}")
    public ResponseEntity<List<Result>> getResults(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getResults(id));
    }
}
