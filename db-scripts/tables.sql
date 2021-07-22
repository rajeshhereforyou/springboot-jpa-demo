CREATE TABLE student(
    id integer NOT NULL,
    name text,
    CONSTRAINT student_pk PRIMARY  KEY (id)
);

CREATE TABLE course(
    id integer NOT NULL,
    name text,
    CONSTRAINT course_pk PRIMARY  KEY (id)
);

CREATE TABLE student_course(
    student_id integer NOT NULL,
    course_id integer NOT NULL,

    CONSTRAINT student_course_pk PRIMARY KEY (student_id, course_id),
    CONSTRAINT student_course_fk_student FOREIGN KEY (student_id) REFERENCES student,
    CONSTRAINT student_course_fk_course FOREIGN KEY (course_id) REFERENCES course
)



--JOIN QUERY to FETCH the records

SELECT s.* FROM student s, course c, student_course sc
WHERE s.id = sc.student_id
      AND sc.course_id = c.id
      c.name = '<input_course_name>'