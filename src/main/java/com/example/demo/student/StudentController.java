package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //  @RestController datanın kendisini JSON veya XML formatı ile direkt olarak sunabiliyor
@RequestMapping(path = "api/v1/student") // controller sınıfının handle ettiği HTTP Requestlerin path eşleştirmesini yapar
public class StudentController {

    private final StudentService studentService;

    @Autowired // Constructor, Değişken yada setter metodlar için dependency injection işlemi gerçekleştirir
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping   //@GetMapping : HTTP üzerinden gelen GET isteklerini kontrol etmek için kullanılır.
    public List<Student> getStudents() {

        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentid}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }


}


