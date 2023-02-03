package com.example.restservice.api;

import com.example.restservice.Exception.StudentNotFoundException;
import com.example.restservice.Exception.StudentNumExistException;
import com.example.restservice.model.Student;
import com.example.restservice.repository.StudentRepositoy;
import com.example.restservice.service.IntStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@RestController
@RequestMapping
public class StudentController {
//    Student student0 = new Student(1,"John","Smith","130,St-Jean",true);
//    Student student2 = new Student(2,"Will","Smith","130,St-Jean",false);
//    Student student3 = new Student(3,"Emily","Smith","130,St-Jean",true);

    @Autowired
            private IntStudentService studentService;
    List<Student> studentArrayList =new ArrayList<>();

//@Autowired
//private StudentRepositoy studentRepositoy;
// get Student Info;
    @GetMapping("/students")
public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
// get Student Info;
@GetMapping("/students/{studentNo}")

public ResponseEntity<List<Student>> getStudentByNo(@PathVariable long studentNo){
//    Optional<Student> student = studentArrayList.stream().filter(stu-> stu.getStudentNo()==studentNo).findFirst();
    return new ResponseEntity<>(studentService.getStudentByStuNo(studentNo),HttpStatus.OK);
}

//Get student by first name for remote SQL server;
    @GetMapping("/students/find/{firstName}")
    public  ResponseEntity<List<Student>> getStudentByFname(@PathVariable String firstName){
//        Optional<Student> student = studentArrayList.stream().filter(stu->stu.getfName().equals(firstName)).findFirst();
        return new ResponseEntity<>(studentService.getStudentByFirstName(firstName),HttpStatus.OK);
    }
//    Post new student to server;
@PostMapping("/students")
public ResponseEntity<Long> addStudent(@RequestBody Student student) throws StudentNumExistException {
       try {
           studentArrayList.add(student);
           studentService.createStudent(student);
           return new ResponseEntity<>(student.getStudentNo(), HttpStatus.CREATED);
       }catch (StudentNumExistException error){
           return new ResponseEntity(error.getMessage(),HttpStatus.CONFLICT);
       }
}
//    Update student first name
@PutMapping("/students/{studentNo}")

public void updateStudent(@PathVariable long studentNo, @RequestBody Student student) throws StudentNotFoundException {
       try {
           studentService.updateStudentName(studentNo, student);
       }
       catch (StudentNotFoundException exception){
           throw new StudentNotFoundException(exception.getMessage(),HttpStatus.NOT_FOUND);
       }
}

//    Delete Student
@DeleteMapping("/students/{studentNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long studentNo,Student student) throws StudentNotFoundException {
//        Optional<Student> studentToDelete=studentArrayList.stream().filter(stu->stu.getStudentNo()==studentNo).findFirst();
//        studentToDelete.ifPresent(student1 -> studentArrayList.remove(student1));
        try {
            studentService.deleteStudent(studentNo, student);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (StudentNotFoundException exception){
            throw new StudentNotFoundException(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
}
}
