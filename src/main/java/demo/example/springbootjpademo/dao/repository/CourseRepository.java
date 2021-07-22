package demo.example.springbootjpademo.dao.repository;

import demo.example.springbootjpademo.dao.entity.Course;
import demo.example.springbootjpademo.dao.entity.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByName(String name);
    List<Course> findAllByStudent(Student student);

    @Query("select s from Student s join s.courses c where c.name = :courseName")
    public List<Student> findAllByName(@Param("courseName")String courseName);
}
