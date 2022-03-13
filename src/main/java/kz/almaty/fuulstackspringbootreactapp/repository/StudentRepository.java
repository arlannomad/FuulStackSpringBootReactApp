package kz.almaty.fuulstackspringbootreactapp.repository;

import kz.almaty.fuulstackspringbootreactapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByAddress(String address);
    Optional<Student> findByEmail(String email);
}
