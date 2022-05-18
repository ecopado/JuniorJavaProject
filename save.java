/**
 * CSE 360: Introduction to Software Engineering Fall 2020 - 70606
 * @Contributers: Linda Lau, Jenny Wong, Emmanuel Copado
 *
 * Final Project -
 * Create an application with a menu bar consisting of two items: "File" and "About", where "File" contains a submenu of
 * four more items, "Load Roster", "Add Attendance", "Save", "Plot Data". The application will read in directed csv
 * files when loading a roster, and adding attendance, and save a file of specified file path and name. When plotting
 * data, a pop up will appear with the data plotted.
 *
 * Due 2, December 2020
 *
 * This file contains Save class. Takes in data from JTable and saves it to a CSV file or a newly created one
 * Declares and defines method(s): save();
 */

package cse360FinalProject;

import javax.swing.*;
import java.io.*;

/**
 * Save class extends JFrame. Creates and writes data stored in the Table instance to a csv file at specified 
 * directory and file name.
 */
public class save extends JFrame{

    /**
     * Default Constructor. Creates and writes the information into the a file with specified file name.
     * 
     * @param fileName Takes in the filename chosen from the GUI
     * @param table Data table from Table class to read and save from
     */
    save(String fileName, Table table) {
        FileWriter writer = null;

        try {
            // Creating or writing to fileName
            writer = new FileWriter(fileName);

            // Stores the Column headers
            for ( int i = 0; i < table.getColumnCount(); i++){
                writer.write(table.getColumnName(i) + ",");
            }
            writer.write("\n");

            // Goes through each row and column, writing its data to file
            for(int i = 0; i < table.getRowCount(); i++){
                for(int j = 0; j < table.getColumnCount(); j++){
                    writer.write(table.getValueAt(i, j).toString() + ",");
                }
                writer.write("\n");
            }
            // Closes writing information to file
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
