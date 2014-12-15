/**
 * A java program that reads a file containing students and 3 exam scores. The program
 * reads the file and allows the user to calculate each student's average, the class average
 * as well as remove a student, add a student, or change individual scores of a student.
 *
 * Created by @Alina Lebron, @Lauren Basmajian and @Jonathan Lutz
 */

import javax.swing.*;

/**
 * The main class. It prompts the user to input a command to read and manipulate the class roll
 */
public class Assignment4 {

    private static boolean running = true;
    private static boolean saved = true;
    private static ClassRoll theClassRoll = null;

    public static void main(String[] args) {

        String iF = JOptionPane.showInputDialog(null, "Please input the name of your input file");
        ClassRoll cr = new ClassRoll(iF);
        theClassRoll = cr;
        while (running) { //while the program is running,
            prompt(); // run the commands prompt (see below)
        }
    }

    /**
     * Displays the list of available commands as follows: a or add to add a student in the class roll
     sa or average to sort the students based on their average
     sn or names to sort the students based on their last names
     r or remove to remove a student from the class roll
     s or save to save the list of students back to the input datafile
     c1 or change1 to change score 1 of a student c2 or c
     hange2 to change score 2 of a student c3 or
     change3 to change score 3 of a student f or find to find a student in the class roll
     d or display to display the class roll
     q or quit to exit the program (The program must ask for confirmation if there are unsaved data)
     */

    public static void prompt() {
        String input = JOptionPane.showInputDialog(null, "Please execute one of the following commands: " + "\n'a' or 'add' to add a student in the class roll"
                + "\n'sa' or 'average' to sort the students based on their average"
                + "\n'sn' or 'names' to sort the students based on their last names"
                + "\n'r' or 'remove' to remove a student from the class roll"
                + "\n's' or 'save' to save the list of students back to the input data file"
                + "\n'c1' or 'change1' to change score 1 of a student"
                + "\n'c2' or 'change2' to change score 2 of student"
                + "\n'c3' or 'change3' to change score 3 of a student"
                + "\n'f' or 'find' to find a student in the class roll"
                + "\n'd' or 'display' to display the class roll"
                + "\n'q' or 'quit' to exit the program");

        if (input.equalsIgnoreCase("a") || input.equalsIgnoreCase("add")) {
            saved = false;
            theClassRoll.add();
        }
        if (input.equalsIgnoreCase("sa") || input.equalsIgnoreCase("average")) {
            theClassRoll.sortAverage();
        }
        if (input.equalsIgnoreCase("sn") || input.equalsIgnoreCase("names")) {
            theClassRoll.sortNames();
        }
        if (input.equalsIgnoreCase("r") || input.equalsIgnoreCase("remove")) {
            saved = false;
            theClassRoll.remove();
        }
        if (input.equalsIgnoreCase("s") || input.equalsIgnoreCase("save")) {
            saved = true;
            theClassRoll.save();
        }
        if (input.equalsIgnoreCase("c1") || input.equalsIgnoreCase("change1")) {
            saved = false;
            theClassRoll.changeScore1();
        }
        if (input.equalsIgnoreCase("c2") || input.equalsIgnoreCase("change2")) {
            saved = false;
            theClassRoll.changeScore2();
        }
        if (input.equalsIgnoreCase("c3") || input.equalsIgnoreCase("change3")) {
            saved = false;
            theClassRoll.changeScore3();
        }
        if (input.equalsIgnoreCase("f") || input.equalsIgnoreCase("find")) {
            theClassRoll.find();
        }
        if (input.equalsIgnoreCase("d") || input.equalsIgnoreCase("display")) {
            theClassRoll.display();
        }
        if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
            if (!saved) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit " +
                        "without saving your changes first?");
                if (dialogResult == JOptionPane.YES_OPTION) running = false;
                if (dialogResult == JOptionPane.NO_OPTION) return;
            } else {
                running = false;
                JOptionPane.showMessageDialog(null, "Goodbye! Have a nice day! ( ͡° ͜ʖ ͡)");
                return;
            }
        }
        //JOptionPane.showMessageDialog(null,"Please input a proper command!");
    }
}
