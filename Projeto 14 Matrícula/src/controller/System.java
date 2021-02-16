package controller;

//util
import java.util.HashMap;

//exceptions
import exceptions.CourseAlreadyExistsException;
import exceptions.StudentAlreadyExistsException;
import exceptions.StudentNotExistsException;
import exceptions.CourseNotExistsException;

//models
import models.Student;
import models.Course;

public class System {
    private HashMap<String, Student> students;
    private HashMap<String, Course> courses;

    public System() {
        this.students = new HashMap<String, Student>();
        this.courses = new HashMap<String, Course>();
    }

    public void addStudent(String nameStudent) throws StudentAlreadyExistsException {
        if(this.students.containsKey(nameStudent))
            throw new StudentAlreadyExistsException( nameStudent + " already exists!");
        
        this.students.put(nameStudent, new Student(nameStudent));
    } 

    public void addCourse(String nameCourse) throws CourseAlreadyExistsException {
        if(this.courses.containsKey(nameCourse))
            throw new CourseAlreadyExistsException(nameCourse +"already exists!");
        
        this.courses.put(nameCourse, new Course(nameCourse));
    }

    public void tie(String nameStudent, String nameCourse) throws StudentNotExistsException, CourseNotExistsException {
        Student student = this.students.get(nameStudent);
        Course course = this.courses.get(nameCourse);

        if(student == null)
            throw new StudentNotExistsException(nameStudent + " not found!");
        
        if(course == null)
            throw new CourseNotExistsException(nameCourse + " not found!");
        
        student.tie(course);
        course.tie(student);
    }

    public void untie(String nameStudent, String nameCourse) throws StudentNotExistsException, CourseNotExistsException {
        Student student = this.students.get(nameStudent);
        Course course = this.courses.get(nameCourse);

        if(student == null)
            throw new StudentNotExistsException(nameStudent + " not found!");
        
        if(course == null)
            throw new CourseNotExistsException(nameCourse + " not found!");
        
        student.untie(nameCourse);
        course.untie(nameStudent);
    }

    public void removeStudent(String nameStudent) throws StudentNotExistsException {
        Student student = this.students.remove(nameStudent);

        if(student == null)
            throw new StudentNotExistsException(nameStudent + " not found!");
        
        for(Course course : this.courses.values()) {
            course.getStudentMap().remove(student.getName());
        }
    }

    public void removeCourse(String nameCourse) throws CourseNotExistsException {
        Course course = this.courses.remove(nameCourse);

        if(course == null)
            throw new CourseNotExistsException(nameCourse + " not found!");
        
        for(Student student : this.students.values()) {
            student.getCoursesMap().remove(course.getName());
        }
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        sb.append("Students: \n");

        for(Student student : this.students.values()) {
            sb.append("  " + student + ": ");
            sb.append("[ ");
            for(Course course : student.getCourses())
                sb.append(course + " ");
            sb.append("]\n");
        }
        sb.append("Courses: \n");
        for(Course course : this.courses.values()) {
            sb.append("  " + course + ": ");
            sb.append("[ ");
            for(Student student : course.getStudents())
                sb.append(student + " ");
            sb.append("]\n");
        }

        return sb.toString();
    }
}
