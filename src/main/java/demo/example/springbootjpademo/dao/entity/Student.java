package demo.example.springbootjpademo.dao.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Comparable<Student>{

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    /**
     * Since student table owns this bi-directional relation, we have added JoinTable here
     * The table "student_course" will store both ids ( id from student table into student_id column
     * and id from course table into course_id column )
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "student_course",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> courses = new HashSet<>();

    public Student(){

    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Course> getCourses(){
        return courses;
    }

    /**
     * Since Student entity owns this bi-directional relationship, we have added this method here
     * @param course
     */
    public void addCourse(Course course){
        this.courses.add(course);
        course.getStudents().add(this);
    }

    /**
     * Since Student entity owns this bi-directional relationship, we have added this method here
     * @param course
     */
    public void removeCourse(Course course){
        this.courses.remove(course);
        course.getStudents().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id.equals(student.id) && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    @Override
    public int compareTo(Student student) {
        return this.name.compareTo(student.name);
    }
}
