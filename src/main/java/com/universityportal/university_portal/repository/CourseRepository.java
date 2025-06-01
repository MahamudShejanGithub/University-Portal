package com.universityportal.university_portal.repository;

import com.universityportal.university_portal.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
