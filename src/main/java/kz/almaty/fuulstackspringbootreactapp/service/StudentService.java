package kz.almaty.fuulstackspringbootreactapp.service;

import kz.almaty.fuulstackspringbootreactapp.exception.resource_already_exists_exception.ResourceAlreadyExistsException;
import kz.almaty.fuulstackspringbootreactapp.exception.resource_not_found_exception.ResourceNotFoundException;
import kz.almaty.fuulstackspringbootreactapp.model.Student;
import kz.almaty.fuulstackspringbootreactapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        if (studentRepository.findByAddress(student.getAddress()).isPresent()) {
            throw new ResourceAlreadyExistsException("This address: " + "(" + student.getAddress() + ")" + " has been already declared");
        } else if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            throw  new ResourceAlreadyExistsException("This email: " + "(" + student.getEmail() + ")" + " has been already declared");
        } else {
            return studentRepository.save(student);
        }
    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("This id: " + "(" + id + ")" + " was not found"));
    }

    public Student updateStudentById(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("This id: " + "(" + id + ")" + " was not found"));
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setEmail(student.getEmail());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(Long id) {
        studentRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("This id: " + "(" + id + ")" + " was not found"));
        studentRepository.deleteById(id);
    }
}
