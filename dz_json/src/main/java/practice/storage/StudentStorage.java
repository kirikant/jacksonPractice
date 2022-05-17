package practice.storage;

import practice.dto.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentStorage {

    private static StudentStorage studentStorage= new StudentStorage();

    private StudentStorage() {
    }

    private  List<Student> students = new ArrayList<>();

    public  List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public  void addStudent(Student student){
        students.add(student);
    }


    public static StudentStorage getStudentStorage() {
        return studentStorage;
    }

}
