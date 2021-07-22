package demo.example.springbootjpademo.service;

import demo.example.springbootjpademo.dao.entity.Course;
import demo.example.springbootjpademo.dao.entity.Student;
import demo.example.springbootjpademo.dao.repository.StudentRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudentAndCourseRegistrations(Student student, Set<Course> courseSet){
        courseSet.forEach( course -> {
            student.addCourse(course);
        });

        saveStudent(student);
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> findStudentsByCourseName(String courseName){
        return studentRepository.findStudentsByCourseName(courseName);
    }
}
