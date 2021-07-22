package demo.example.springbootjpademo.dao.repository;

import demo.example.springbootjpademo.dao.entity.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s join s.courses c where c.name = :courseName")
    public List<Student> findStudentsByCourseName(@Param("courseName")String courseName);
}
