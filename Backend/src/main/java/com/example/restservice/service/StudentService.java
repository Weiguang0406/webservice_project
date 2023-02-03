package com.example.restservice.service;

import com.example.restservice.Exception.StudentNotFoundException;
import com.example.restservice.Exception.StudentNumExistException;
import com.example.restservice.constants.ERROR;
import com.example.restservice.model.Student;
import com.example.restservice.repository.StudentRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IntStudentService{

    @Autowired
    private StudentRepositoy studentRepositoy;

    @Override
    public List<Student> getAllStudents() {
        return studentRepositoy.getAllStudents();
    }

    @Override
    public List<Student> getStudentByStuNo(long studentNo) {
        return studentRepositoy.getStudentByStuNo(studentNo);
    }

    @Override
    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepositoy.getStudentByfName(firstName);
    }

    @Override
    public long createStudent(Student student) throws StudentNumExistException {
        List<Student> foundStudent =studentRepositoy.getStudentByStuNo(student.getStudentNo());
        if(foundStudent.size()==0) {
            studentRepositoy.addStudent(student);
            return student.getStudentNo();
        }else {
            throw new StudentNumExistException(ERROR.ERROR_STUDENT_EXIST);
        }
    }

    @Override
    public void updateStudentName(long studentNo, Student student) throws StudentNotFoundException {
        List<Student> foundStudent =studentRepositoy.getStudentByStuNo(student.getStudentNo());
        if(foundStudent.size()==0) {
            studentRepositoy.updateStudentName(studentNo, student);
        }else {
            throw new StudentNotFoundException(ERROR.ERROR_STUDENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteStudent(long studentNo,Student student) throws StudentNotFoundException {
        List<Student> foundStudent =studentRepositoy.getStudentByStuNo(studentNo);
        if(foundStudent.size()!=0){studentRepositoy.deleteStudent(studentNo,student);}
        else {
            throw new StudentNotFoundException(ERROR.ERROR_STUDENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }
}
