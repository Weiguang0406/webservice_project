package com.example.restservice.repository;

import com.example.restservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoy {

@Autowired
    JdbcTemplate jdbcTemplate;

public List<Student> getAllStudents(){
    return jdbcTemplate.query("SELECT student_no, first_name,last_name,address,active FROM student",new StudentRowMapper());
}

public void addStudent(Student student){
    long  studentno = student.getStudentNo();
    var fname=student.getfName();
    var lname =student.getlName();
    var address=student.getAddress();
    Boolean active =student.isActive();

    jdbcTemplate.update("INSERT INTO student(student_no,first_name,last_name,address,active) values (?,?,?,?,?)",studentno,fname,lname,address,active);



}

public List<Student> getStudentByStuNo(long studentNo){
    String sql = "SELECT student_no, first_name,last_name,address,active FROM student WHERE student_no ="+studentNo;
    return jdbcTemplate.query(sql,new StudentRowMapper());
}

    public List<Student> getStudentByfName(String firstName){
    String sql = "SELECT student_no, first_name,last_name,address,active FROM student WHERE first_name = "+'"'+firstName+'"';
        return jdbcTemplate.query(sql,new StudentRowMapper());
    }

    public void updateStudentName(long studentNo, Student student){
    String sql = "UPDATE student SET first_name = ?, last_name = ? WHERE student_no =?";
        jdbcTemplate.update(sql,student.getfName(),student.getlName(),student.getStudentNo());
    }

    public void deleteStudent(long studentNo,Student student){
        String sql = "DELETE FROM student WHERE student_no =?";
        jdbcTemplate.update(sql,student.getStudentNo());
    }
}
