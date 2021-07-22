package demo.example.springbootjpademo;

import demo.example.springbootjpademo.dao.entity.Student;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {

    public static void main(String[] args) {
        Student student1 = new Student(1, "CCC");
        Student student2 = new Student(2, "AA");
        Student student3 = new Student(3, "ABC");
        Student student4 = new Student(4, "BBC");

        List<Student> list = Stream.of(student1, student2, student4,student3).collect(Collectors.toList());
        Collections.sort(list);

                list.forEach( student ->
                        System.out.println(student)
                        );

    }



}
