package view;

//User interaction
import javax.swing.JOptionPane;

//controller
import controller.System;

//Exceptions
import exceptions.CourseAlreadyExistsException;
import exceptions.CourseNotExistsException;
import exceptions.StudentAlreadyExistsException;
import exceptions.StudentNotExistsException;

public class ViewSystem {
    private System system;

    public ViewSystem() {
        system = new System();
    }

    public void init() {
        while(true) {
            String[] line = JOptionPane.showInputDialog(
                "     ----- Academy system ------  \n" +
                "- AddStudent: {nameStudent}\n" +
                "- AddCourse: {nameCourse}\n" +
                "- Tie: {nameStudent} {nameCourse}\n" +
                "- Untie: {nameStudent} {nameCourse}\n" +
                "- RemoveStudent: {nameStudent}\n" +
                "- RemoveCourse: {nameCourse}\n" +
                "- Show\n" +
                "- End"
            ).split(" ");


            if(line[0].equals("End"))
                break;
            
            else if(line[0].equals("AddStudent:")) {
                try {
                    for(int i = 1; i < line.length; i++) {
                        system.addStudent(line[i]);
                    }
                    this.showMessage(true, "All students added successfully!");
                }catch(StudentAlreadyExistsException err) {
                    this.showMessage(false, err.getMessage());
                } catch(IndexOutOfBoundsException err) {
                    this.showMessage(false, "Few arguments");
                }
            }

            else if(line[0].equals("AddCourse:")) {
                try {
                    for(int i = 1; i < line.length; i++) {
                        system.addCourse(line[i]);
                    }
                    this.showMessage(true, "All courses added successfully!");
                }catch(CourseAlreadyExistsException err) {
                    this.showMessage(false, err.getMessage());
                } catch(IndexOutOfBoundsException err) {
                    this.showMessage(false, err.getMessage());
                }
                
            }

            else if(line[0].equals("Tie:")) {
                try {
                    for(int i = 2; i < line.length; i++) 
                        system.tie(line[1], line[i]);
                    this.showMessage(true, line[1] + " was enrolled in all courses with success!");
                } catch(StudentNotExistsException err) {
                    this.showMessage(false, err.getMessage());
                } catch(CourseNotExistsException err) {
                    this.showMessage(false, err.getMessage());
                } catch(IndexOutOfBoundsException err) {
                    this.showMessage(false, err.getMessage());
                }
            }

            else if(line[0].equals("Untie:")) {
                try {
                    for(int i = 2; i < line.length; i++) 
                        system.untie(line[1], line[i]);
                    this.showMessage(true, line[1] + " was disenrolled of the all this courses with successfully!");
                } catch(StudentNotExistsException err) {
                    this.showMessage(false, err.getMessage());
                } catch(CourseNotExistsException err) {
                    this.showMessage(false, err.getMessage());
                } catch(IndexOutOfBoundsException err) {
                    this.showMessage(false, err.getMessage());
                }
            }

            else if(line[0].equals("RemoveStudent:")) {
                try {
                    system.removeStudent(line[1]);
                    this.showMessage(true, line[1] + " was removed with successfully!");
                } catch(StudentNotExistsException err) {
                    this.showMessage(false, err.getMessage());
                } catch(IndexOutOfBoundsException err) {
                    this.showMessage(false, err.getMessage());
                }
            }

            else if(line[0].equals("RemoveCourse:")) {
                try {
                    system.removeCourse(line[1]);
                    this.showMessage(true, line[1] + " was removed with successfully!");
                } catch(CourseNotExistsException err) {
                    this.showMessage(false, err.getMessage());
                } catch(IndexOutOfBoundsException err) {
                    this.showMessage(false, err.getMessage());
                }
            }

            else if(line[0].equals("Show"))
                this.showMessage(true, system.show());
            

            else
                this.showMessage(false, "Invalid command!");

        }

        
    }

    private void showMessage(boolean success, String message) {
        if(success)
            JOptionPane.showMessageDialog(null, message, "Success" ,1);
        else
            JOptionPane.showMessageDialog(null, message, "Error", 0);
    }
}
