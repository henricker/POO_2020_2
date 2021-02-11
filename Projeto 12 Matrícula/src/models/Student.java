package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private HashMap<String, Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new HashMap<String, Course>();
    }

    public void tie(Course course) {
        this.courses.put(course.getName(), course);
    }

    public void untie(String nameCourse) {
        this.courses.remove(nameCourse);
    }

    public ArrayList<Course> getCourses() { 
        ArrayList<Course> courses = new ArrayList<Course>();
        for(Course course : this.courses.values()) {
            courses.add(course);
        }
        return courses;
    }

    public HashMap<String, Course> getCoursesMap() {
        return this.courses;
    }

    public String getName() { return this.name; }

    @Override
    public String toString() { 
        return this.name;
    }
}
