/**
 * A java program that reads a file containing students and 3 exam scores. The program
 * reads the file and allows the user to calculate each student's average, the class average
 * as well as remove a student, add a student, or change individual scores of a student.
 *
 * Created by @Alina Lebron, @Lauren Basmajian and @Jonathan Lutz
 */


import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Maintains student information (arbitrary number of students)
 */
public class ClassRoll {

    private ArrayList<Student> students; // creates a list of students
    private String title; // provides the class title
    private String fileName; // provides the data file name
    private DecimalFormat df; // used to format strings throughout the file

    /**
     * ClassRoll constructor that reads the input file, adds the students to the array list,
     * and formats the file correctly
     * @param f the input file
     */

    public ClassRoll(String f) {

        df = new DecimalFormat("#.00"); // creates a format variable for #s with 2 decimals
        File mF = null;
        fileName = f;

        try {
            mF = new File(f);
            Scanner fileScanner = new Scanner(mF);
            students = new ArrayList<Student>();

            /*
              reads the file to set the first line as the title. Once the first line is read,
              it sets the first and last name and the three scores
             */

            int sof = 0;
            while (fileScanner.hasNext()) {
                if (sof == 0) {
                    title = fileScanner.next();
                    sof++;
                }
                String fn = fileScanner.next(), ln = fileScanner.next();
                int fs = fileScanner.nextInt(), ss = fileScanner.nextInt(), ts = fileScanner.nextInt();
                Student student = new Student(fn, ln);
                Exams exams = new Exams(); // creates a new exams object to set the scores
                exams.setScore1(fs); // sets score 1
                exams.setScore2(ss); // sets score 2
                exams.setScore3(ts); // sets score 3
                student.setExams(exams);
                students.add(student); // adds the data to each student
            }
        } catch (Exception e) {
        }
    }

    /**
     * Removes a student from the file
     */

    public void remove() {
        boolean found = false; // used to later determine if the student was found
        String f = JOptionPane.showInputDialog(null, "Please input a student's first name"); // user input for first name
        String l = JOptionPane.showInputDialog(null, "Please input a student's last name"); // user input for last name
        Student bufferStud = null;
        for (Student student : students)
            if (student.getfName().equalsIgnoreCase(f) && student.getlName().equalsIgnoreCase(l)) {
                bufferStud = student; // sets a variable to a student that can later be removed
                found = true; // the student is found
            }

        /* remove the student. if the student isn't found, display an error message */

        students.remove(bufferStud);
        if (!found) JOptionPane.showMessageDialog(null, "Couldn't find student: '" + f + " " + l + "'");
    }

    /**
     * A method that displays all of the class data correctly (with the scores of each student, their averages
     * and the class average)
     * @return the class average
     */

    public String getDisplayMessage() {
        String message = title;
        double classAverageSum = 0.0; // initializes the counter (sum of the students' averages)

        /* Loop through the Student array list and print out each student, their scores, and averages. Add
        each student average to the classAverageSum counter.
         */

        for (Student student : students) {
            message = message + "\n" + student.getfName() + " " +
                    String.format("%-12s", student.getlName()) +
                    String.format("%-6s", student.getExams().getScore1()) + " " +
                    String.format("%-6s", student.getExams().getScore2()) + " " +
                    String.format("%-6s", student.getExams().getScore3()) + " " +
                    df.format(student.getAverage()); // format to 2 decimal points
            classAverageSum = classAverageSum + student.getAverage(); // add each average to the total class average sum
        }
        message = message + "\nThe class average is: " + df.format(classAverageSum / students.size()); // average of the class

        return message;
    }

    /**
     * Displays the class roll from the getDisplayMessage method
     */

    public void display() {
        JOptionPane.showMessageDialog(null, getDisplayMessage());
    }

    /**
     * Adds a student to the class roll. Uses a similar structure to the remove method, except it adds the student to
     * the array instead of removing them
     */

    public void add() {
        boolean found = false;
        String f = JOptionPane.showInputDialog(null, "Please input a student's first name");
        String l = JOptionPane.showInputDialog(null, "Please input a student's last name");
        int score1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input the student's first exam score!"));
        int score2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input the student's second exam score!"));
        int score3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input the student's third exam score!"));
        for (Student student : students)
            if (student.getfName().equalsIgnoreCase(f) && student.getlName().equalsIgnoreCase(l))
                found = true;
        if (found) JOptionPane.showMessageDialog(null, "Error, student: '" + f + " " + l + "' already exists!");
        else {
            Student myStudent = new Student(f, l);
            Exams exams = new Exams();
            exams.setScore1(score1);
            exams.setScore2(score2);
            exams.setScore3(score3);
            myStudent.setExams(exams);
            students.add(myStudent);
        }
    }

    /**
     * Method to change the first score of a student
     */
    public void changeScore1() {
        boolean found = false;
        Student theStudent = null;
        String f = JOptionPane.showInputDialog(null, "Please input a student's first name");
        String l = JOptionPane.showInputDialog(null, "Please input a student's last name");
        int score1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input the student's first exam score!"));

        /* searches to match user input to the data file */

        for (Student student : students)
            if (student.getfName().equalsIgnoreCase(f) && student.getlName().equalsIgnoreCase(l)) {
                found = true;
                theStudent = student;
            }

        /* if the user input does not match any student, display an error message. otherwise, add the student */

        if (!found) JOptionPane.showMessageDialog(null, "Error, student: '" + f + " " + l + "' doesn't exists!");
        else theStudent.getExams().setScore1(score1);
    }

    /**
     * Changes the second score of a student. See the method changeScore1() for more details
     */

    public void changeScore2() {
        boolean found = false;
        Student theStudent = null;
        String f = JOptionPane.showInputDialog(null, "Please input a student's first name");
        String l = JOptionPane.showInputDialog(null, "Please input a student's last name");
        int score2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input the student's second exam score!"));
        for (Student student : students)
            if (student.getfName().equalsIgnoreCase(f) && student.getlName().equalsIgnoreCase(l)) {
                found = true;
                theStudent = student;
            }
        if (!found) JOptionPane.showMessageDialog(null, "Error, student: '" + f + " " + l + "' doesn't exists!");
        else theStudent.getExams().setScore2(score2);
    }

    /**
     * Changes the third score of a student. @see @link changeScore1()
     */

    public void changeScore3() {
        boolean found = false;
        Student theStudent = null;
        String f = JOptionPane.showInputDialog(null, "Please input a student's first name");
        String l = JOptionPane.showInputDialog(null, "Please input a student's last name");
        int score3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input the student's third exam score!"));
        for (Student student : students)
            if (student.getfName().equalsIgnoreCase(f) && student.getlName().equalsIgnoreCase(l)) {
                found = true;
                theStudent = student;
            }
        if (!found) JOptionPane.showMessageDialog(null, "Error, student: '" + f + " " + l + "' doesn't exists!");
        else theStudent.getExams().setScore3(score3);
    }

    /**
     * Prompts for a student's first and last name and displays their exam scores with an average
     */

    public void find() {
        boolean found = false;
        Student theStudent = null;
        String f = JOptionPane.showInputDialog(null, "Please input a student's first name");
        String l = JOptionPane.showInputDialog(null, "Please input a student's last name");
        for (Student student : students)
            if (student.getfName().equalsIgnoreCase(f) && student.getlName().equalsIgnoreCase(l)) {
                found = true;
                theStudent = student;
            }
        if (!found) JOptionPane.showMessageDialog(null, "Error, student: '" + f + " " + l + "' doesn't exists!");
        else
            JOptionPane.showMessageDialog(null, theStudent.getfName() + " " + theStudent.getlName() + "\nExam 1: " + theStudent.getExams().getScore1() + "\nExam 2: " + theStudent.getExams().getScore2() + "\nExam 3: " + theStudent.getExams().getScore3() + "\nAverage: " + theStudent.getAverage());
    }

    /**
     * Sorts the students by their averages. @see the class AverageComparator
     */

    public void sortAverage() {
        Collections.sort(students, new AverageComparator()); // see the
        display();
    }

    /**
     * Sorts the students by their last names. @see the class StudentNameComparator
     */

    public void sortNames() {
        Collections.sort(students, new StudentNameComparator());
        display();
    }

    /**
     * Saves the file to the same data input file.
     */

    public void save() {
        try {
            PrintWriter output = new PrintWriter(fileName);
            output.printf(getDisplayMessage());
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uses the comparator tool to sort the last names
     */

    class StudentNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student student, Student student2) {
            return student.getlName().compareToIgnoreCase(student2.getlName());
        }
    }

    /**
     * Uses the comparator tool to sort the student averages
     */

    class AverageComparator implements Comparator<Student> {
        @Override
        public int compare(Student student, Student student2) {
            if (student.getAverage() < student2.getAverage())
                return 1;
            else return -1;
        }
    }
}
