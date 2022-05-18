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
 * This file contains only the rosterLoader class. Creates a list of students and their information. 
 * Declares and defines method(s): loadData().
 */

package cse360FinalProject;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * rosterLoader class creates a list of students from a given csv file. 
 */
public class rosterLoader {
    // delimiter used to parse csv files
    public static final String delimiter = ",";

    /**
     * loadData method reads the data in CSV file and stores it in ArrayList
     * @param csvFile : name of the file
     * @return : (Enumerable) ArrayList contains all the students and their data
     */
    public static ArrayList loadData(String csvFile) {
        //initialize variables
        String line = "";
        // array of students
        ArrayList<student> al = new ArrayList<student>();
        // temp Array for each line
        String[] tempArr;

        try {
            // reading the file using file, filereader, and bufferedreader
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            // read each line of the file
            while ((line = br.readLine()) != null) {
                // each line of the file is stored into the tempArr
                tempArr = line.split(delimiter);
                // creating a new student and storing their information
                student st = new student();
                st.setID(Integer.parseInt(tempArr[0]));
                st.setFirstName(tempArr[1]);
                st.setLastName(tempArr[2]);
                st.setPlan(tempArr[3]);
                st.setLevel(tempArr[4]);
                st.setAsurite(tempArr[5]);
                // adding the student to the arraylist
                if (!al.stream().anyMatch(x -> x.getID() == st.getID() || x.getAsurite().equals(st.getAsurite())))
                    al.add(st);
            }
            // close the file
            br.close();

        } catch (IOException ioe) {
            // exception message
            ioe.printStackTrace();
        }

        // return arraylist of data
        return al;
    }
}
