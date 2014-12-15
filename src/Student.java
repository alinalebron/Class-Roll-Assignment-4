/**
 * A java program that reads a file containing students and 3 exam scores. The program
 * reads the file and allows the user to calculate each student's average, the class average
 * as well as remove a student, add a student, or change individual scores of a student.
 *
 * Created by @Alina Lebron, @Lauren Basmajian and @Jonathan Lutz
 */

/**
 * A class that maintains student information
 */
public class Student {

    private String fName; // student first name
    private String lName; // student last name
    private Exams exams; // exams object

    /**
     * Student constructor that initializes the first and last names
     * @param fn first name
     * @param ln last name
     */

    public Student(String fn, String ln) {
        this.fName = fn;
        this.lName = ln;
        exams = new Exams();
    }

    /**
     * Retrieves the first name of the student
     * @return first name
     */

    public String getfName() {
        return fName;
    }

    /**
     * Sets the first name of the student
     * @param fName first name
     */

    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Retrieves the last name of the student
     * @return last name
     */

    public String getlName() {
        return lName;
    }


    /**
     * Sets the last name of the student
     * @param lName the last name
     */

    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Retrieves the exams object information
     * @return exams
     */

    public Exams getExams() {
        return exams;
    }

    /**
     * Sets the exam scores from a new exam object
     * @param exams the exam scores
     */

    public void setExams(Exams exams) {
        this.exams = exams;
    }

    /**
     * Sets the first exam score
     * @param sc score 1
     */

    public void setScore1(int sc) {
        this.exams.setScore1(sc);
    }

    /**
     * Sets the second exam score
     * @param sc score 2
     */
    public void setScore2(int sc) {
        this.exams.setScore2(sc);
    }

    /**
     * Sets the third exam score
     * @param sc score 3
     */
    public void setScore3(int sc) {
        this.exams.setScore3(sc);
    }

    /**
     * Displays the student info and scores
     * @return the first name, last name, and three exam scores
     */

    @Override
    public String toString() {
        return fName + " " + lName + "\n" + getScores();
    }

    /**
     * Retrieves the exam scores from the exams class in a string
     * @return the exam score
     */

    public String getScores() {
        return exams.toString();
    }

    /**
     * Returns the student's average in the 3 exams
     * @return the student average
     */

    public double getAverage() {
        double avg = (exams.getScore1() + exams.getScore2() + exams.getScore3()) / 3.0;
        return avg;
    }

    /**
     * Compares students for alphabetical order
     * @param s the student
     * @return -1,0, or 1 depending on the order of the student
     */

    public int compareTo(Student s) {
        return fName.compareToIgnoreCase(s.getfName());
    }
}
