/**
 * A java program that reads a file containing students and 3 exam scores. The program
 * reads the file and allows the user to calculate each student's average, the class average
 * as well as remove a student, add a student, or change individual scores of a student.
 *
 * Created by @Alina Lebron, @Lauren Basmajian and @Jonathan Lutz
 */

/**
 * A class that maintains the exam scores
 */

public class Exams {

    private int score1;
    private int score2;
    private int score3;

    /**
     * Constructor for the class Exams. Initializes all scores to 0.
     */
    public Exams() {
        score1 = 0;
        score2 = 0;
        score3 = 0;
    }

    /**
     * Get the first score
     * @return score 1
     */

    public int getScore1() {
        return score1;
    }

    /**
     * Set the first score
     * @param score1 first exam score
     */

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    /**
     * Get the second score
     * @return score 2
     */

    public int getScore2() {
        return score2;
    }

    /**
     * Sets the second score
     * @param score2 second exam score
     */

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    /**
     * Get the third score
     * @return score 3
     */

    public int getScore3() {
        return score3;
    }

    /**
     * Set the third score
     * @param score3 third exam score
     */

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    /**
     * Return a string containing the scores in each of the three exams
     * @return the 3 exam scores
     */

    @Override
    public String toString() {
        return "The exam scores are:" + getScore1() + ", " + getScore2() + ", and " + getScore3();
    }
}
