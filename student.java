/**
 * CSE 360: Introduction to Software Engineering Fall 2020 - 70606
 * @Contributers: Jenny Wong, Emmanuel Copado
 *
 * Final Project -
 * Create an application with a menu bar consisting of two items: "File" and "About", where "File" contains a submenu of
 * four more items, "Load Roster", "Add Attendance", "Save", "Plot Data". The application will read in directed csv
 * files when loading a roster, and adding attendance, and save a file of specified file path and name. When plotting
 * data, a pop up will appear with the data plotted.
 *
 * Due 2, December 2020
 *
 * This file contains only the student class. Creates and initializes the data for a new student
 * Declares and defines method(s): Student(), setID(), setFirstName(), setLastName(), setPlan(), setLevel(), setAsurite(),
 * getID(), getFirstName(), getLastName, getPlan(), getLevel(), getAsurite();
 */

package cse360FinalProject;

/**
 * Student class stores student information: id, first and last name, program, academic level, and asurite id. 
 */
public class student{

  	private int id;
    private String firstName;
    private String lastName;
    private String programPlan;
    private String academicLevel;
    private String asurite;

    /**
     * Constructor initializes student data to null;
     */
    public void Student() {
        id = 0;
        firstName = null;
        lastName = null;
        programPlan = null;
        academicLevel = null;
        asurite = null;
    }

    /**
     * Updates student ID
     * 
     * @param int ID
     */
    public void setID(int x) {
        this.id = x;
    }

    /**
     * Updates student's First Name
     * 
     * @param String First Name
     */
    public void setFirstName(String x) {
        this.firstName = x;
    }

    /**
     * Updates student's Last Name
     * 
     * @param String Last Name
     */
    public void setLastName(String x) {
        this.lastName = x;
    }

    /**
     * Updates student Academic Plan
     * 
     * @param String Academic Plan
     */
    public void setPlan(String x) {
        this.programPlan = x;
    }

    /**
     * Updates student Academic Level
     * 
     * @param String Academic Level
     */
    public void setLevel(String x) {
        this.academicLevel = x;
    }

    /**
     * Updates student ASURITE
     * 
     * @param String ASURITE
     */
    public void setAsurite(String x) {
        this.asurite = x;
    }

    /**
     * Returns ID as an integer
     */
    public int getID() {
        return id;
    }

    /**
     * Returns First Name as a string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns Last Name as a string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns Academic Plan as a string
     */
    public String getPlan() {
        return programPlan;
    }

    /**
     * Returns Academic Level as a string
     */
    public String getLevel() {
        return academicLevel;
    }

    /**
     * Returns ASURITE as a string
     */
    public String getAsurite() {
        return asurite;
    }

}
