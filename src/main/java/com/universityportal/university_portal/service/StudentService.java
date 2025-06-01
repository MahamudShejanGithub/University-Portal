package com.universityportal.university_portal.service;

import com.universityportal.university_portal.entity.Course;
import com.universityportal.university_portal.entity.Result;
import com.universityportal.university_portal.entity.Student;
import com.universityportal.university_portal.exception.ResourceNotFoundException;
import com.universityportal.university_portal.repository.CourseRepository;
import com.universityportal.university_portal.repository.ResultRepository;
import com.universityportal.university_portal.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ResultRepository resultRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, ResultRepository resultRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.resultRepository = resultRepository;
    }

    public Student getProfile(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student with ID " + studentId + " not found"));
    }

    public List<Course> getAvailableCourses() {
        return courseRepository.findAll();
    }

    public String enrollInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course courseToEnroll = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Prerequisite check
        for (Course prereq : courseToEnroll.getPrerequisites()) {
            if (!student.getEnrolledCourses().contains(prereq)) {
                throw new RuntimeException("Missing prerequisite: " + prereq.getName());
            }
        }

        student.getEnrolledCourses().add(courseToEnroll);
        studentRepository.save(student);
        return "Enrolled in course: " + courseToEnroll.getName();
    }

    public List<Result> getResults(Long studentId) {
        return resultRepository.findByStudentId(studentId);
    }
}
