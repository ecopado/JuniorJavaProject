/**
 * CSE 360: Introduction to Software Engineering Fall 2020 - 70606
 * @Contributers: Simran Bhalla, Linda Lau
 *
 * Final Project -
 * Create an application with a menu bar consisting of two items: "File" and "About", where "File" contains a submenu of
 * four more items, "Load Roster", "Add Attendance", "Save", "Plot Data". The application will read in directed csv
 * files when loading a roster, and adding attendance, and save a file of specified file path and name. When plotting
 * data, a pop up will appear with the data plotted.
 *
 * Due 2, December 2020
 *
 * This file contains only Attendance class. Stores the asurite id and time the respective id was present. Declares and
 * defines method(s): getAsurite(), getTime(), and toString();
 */

package cse360FinalProject;

/**
 * Attendance class
 */
public class Attendance{

    // field to store asurite
    private String asurite;
    // field to store time
    private int time;

    /**
     * Parameterised Constructor
     *
     * @param asurite : asurite
     * @param time : time
     */
    public Attendance(String asurite, int time) {
        this.asurite = asurite;
        this.time = time;
    }

    /**
     * Method to access private variable asurite.
     * @return - string value stored in asurite.
     */
    public String getAsurite() {
        return asurite;
    }

    /**
     * Method to access private variable time.
     * @return - int value stored in time.
     */
    public int getTime() {
        return time;
    }

    /**
     * Returns a string separating the asurite and time with a space character in between.
     * ex format:
     *      <asurite> <time>
     * @return - string value containing the asurite and time.
     */
    @Override
    public String toString() {
        return asurite + " " + time;
    }
  
}
