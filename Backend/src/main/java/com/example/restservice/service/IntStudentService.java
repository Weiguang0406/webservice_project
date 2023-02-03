package com.example.restservice.service;

import com.example.restservice.Exception.StudentNotFoundException;
import com.example.restservice.Exception.StudentNumExistException;
import com.example.restservice.model.Student;

import java.util.List;

public interface IntStudentService {
    List<Student> getAllStudents();
    List<Student> getStudentByStuNo(long studentNo);
    List<Student> getStudentByFirstName(String firstName);
    long createStudent(Student student) throws StudentNumExistException;
    void updateStudentName(long studentNo, Student student) throws StudentNotFoundException;
    void deleteStudent(long studentNo,Student student) throws StudentNotFoundException;
}
