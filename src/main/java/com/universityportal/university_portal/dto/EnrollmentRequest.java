package com.universityportal.university_portal.dto;

public class EnrollmentRequest {
    private Long studentId;
    private Long courseId;

    public EnrollmentRequest(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "EnrollmentRequest{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
