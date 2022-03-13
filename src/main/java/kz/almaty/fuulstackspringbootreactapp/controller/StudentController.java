package kz.almaty.fuulstackspringbootreactapp.controller;

import kz.almaty.fuulstackspringbootreactapp.model.Student;
import kz.almaty.fuulstackspringbootreactapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/findStudentById/{id}")
    public Student findStudentById(@PathVariable("id") Long id) {
        return studentService.findStudentById(id);
    }

    @PutMapping("/updateStudentById/{id}")
    public Student updateStudentById(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public String deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return "Student with id: (" + id + ") has been deleted!";
    }
}
