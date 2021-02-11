package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String name;
    private HashMap<String, Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new HashMap<String, Student>();
    }

    public void tie(Student student) {
        this.students.put(student.getName(), student);
    }

    public void untie(String nameStudent) {
        this.students.remove(nameStudent);
    }
    
    public ArrayList<Student> getStudents() { 
        ArrayList<Student> students = new ArrayList<Student>();
        for(Student student : this.students.values()) {
            students.add(student);
        }
        return students;
    }

    public HashMap<String, Student> getStudentMap() {
        return this.students;
    }

    public String getName() { return this.name; }

    @Override
    public String toString() { 
        return this.name;
    }

}
