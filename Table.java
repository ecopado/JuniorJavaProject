/**
 * CSE 360: Introduction to Software Engineering Fall 2020 - 70606
 * @Contributers: Emmanuel Copado, Linda Lau, Jenny Wong
 *
 * Final Project - 
 * Create an application with a menu bar consisting of two items: "File" and "About", where "File" contains a submenu of
 * four more items, "Load Roster", "Add Attendance", "Save", "Plot Data". The application will read in directed csv
 * files when loading a roster, and adding attendance, and save a file of specified file path and name. When plotting
 * data, a pop up will appear with the data plotted.
 *
 * Due 2, December 2020
 *
 * This file contains only Table class, its constructor, and method(s): addAttendance(), getAttendance(). 
 */

package cse360FinalProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Table class creates a JTable with attendance array returned from AttendanceAdder class and adds attendance.
 * When adding attendance, procts a date picker to allow the user to select a date. 
 */
public class Table extends JTable{
    GUI f;
    DefaultTableModel model = new DefaultTableModel();
    
    /**
     * Constructor for table. Creates a table with the inputted array list and displays on the given GUI window. 
     * @param roster - ArrayList<student> containing student information to be inputted into the table. 
     * @param window - GUI instance where the table is to be displayed. 
     */
    Table(ArrayList<student> roster, GUI window){

        f = window;
        
        // header for the table 
        String header[] = {"ID", "First Name", "Last Name", "Program and Plan", "Academic Level", "ASURITE"};  

        for (int i = 0; i < 6; i ++){
            model.addColumn(header[i]);
        }

        Object rowData[] = new Object[6];
        for (int i = 0; i < roster.size(); i++){
            rowData[0] = roster.get(i).getID();
            rowData[1] = roster.get(i).getFirstName();
            rowData[2] = roster.get(i).getLastName();
            rowData[3] = roster.get(i).getPlan();
            rowData[4] = roster.get(i).getLevel();
            rowData[5] = roster.get(i).getAsurite();
            model.addRow(rowData);
        }

        setModel(model);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setBounds(30,40,200,300);  // bounds of the table 
        JScrollPane sp = new JScrollPane(this);
        sp.setPreferredSize(new Dimension(400,600));  // dimentions of the table 
        f.add(sp);
        f.setSize(640,600); 
        f.setVisible(true);
    }

    /**
     * Method that adds the attendance for the corresponding students in the roster and refreshes the table in the GUI
     * window. 
     * @param attendance - List<attendance> with student ID and time attended. 
     */
    public void addAttendance(List<Attendance> attendance){
        String date = new DatePicker(f).setPickedDate();
        int users = 0;
        int notRegisteredCount = 0;
        String notRegistered = "";

        Object[] colData = new Object[model.getRowCount()];
        for(int i = 0; i < model.getRowCount(); i++) colData[i] = 0;

        for(int attendee = 0; attendee < attendance.size(); attendee++){ // iterate through every attendee in attendance
            int i = 0;
            // compare each attendee to all the asurites in the roster
            while(i < model.getRowCount() && !model.getValueAt(i, 5).equals(attendance.get(attendee).getAsurite()))
                i++;

            // if the attendee is not found in the roster add to the list of non registered asurites
            if(i >= model.getRowCount()){
                notRegisteredCount++;
                notRegistered += attendance.get(attendee).getAsurite() + " connected for "
                        + attendance.get(attendee).getTime() + " minute(s)\n";
            }
            // otherwise update roster
            else{
                users++;
                colData[i] = attendance.get(attendee).getTime();
            }
        }

        model.addColumn(date, colData);  
        setModel(model);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setBounds(30,40,200,300);  
        JScrollPane sp = new JScrollPane(this);
        sp.setPreferredSize(new Dimension(400,600));  
        f.add(sp);
        f.setSize(640,600);
        f.setVisible(true);

        // dialog box 
        JOptionPane.showMessageDialog(f,
                "Data loaded for " + users + " in the roster.\n" +
                        notRegisteredCount + " additional attendee(s) was found:\n" +
                        notRegistered,
                "Attendance", JOptionPane.PLAIN_MESSAGE);
    }
   
    /**
     * Method that returns a column of the table, excluding header, as an array. 
     * @param column - index of the column in the table to be returned as an array.
     * @return attendees - the column as an array.
     */ 
    public int[] getAttendance(int column){
        int[] attendees = new int[model.getRowCount()];
        for(int i = 0; i < model.getRowCount(); i++){
            attendees[i] = (int)model.getValueAt(i, column);
        }
        return attendees;
    }
}
