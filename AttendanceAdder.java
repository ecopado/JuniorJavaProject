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
 * This file contains only the AttendanceAdder and related method(s): loadAttendance(). Class reads a csv file and
 * creates an array with the attendance information in the file. Attendance csv file should should have two columns.
 */

package cse360FinalProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AttendanceAdder class has no global variables and only one method: loadAttendance(). Class reads file with inputted
 * file name.
 */
public class AttendanceAdder {

    /**
     * loadAttendance method reads csv file and stores the information in List enumerable
     * @param fileName : name of csv file to be read
     * @return : (Enumerable) List containing data from read file
     */
    public static List<Attendance> loadAttendance(String fileName) {
        List<Attendance> attendanceList = new ArrayList<Attendance>();
        Attendance studentAttendance;

        try {
            File attendanceFile = new File(fileName);
            FileReader fileReader = new FileReader(attendanceFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String delimiter = ",";             // string separator
            String[] attendanceArr;             // stores comma separated record

            while ((line = bufferedReader.readLine()) != null) {
                // Stores information
                attendanceArr = line.split(delimiter);
                String asurite = attendanceArr[0];
                int time = Integer.parseInt(attendanceArr[1].trim());

                int index = -1;

                // Check if asurite is already recorded, if so update time
                for(int i = 0; i < attendanceList.size(); i++){
                    if(attendanceList.get(i).getAsurite().equalsIgnoreCase(asurite)){
                        index = i;
                    }
                }
                if (index != -1) {
                    int existingTime = attendanceList.get(index).getTime();
                    int updatedTime = existingTime + time;
                    studentAttendance = new Attendance(asurite, updatedTime);
                    attendanceList.set(index, studentAttendance);
                }else{      // otherwise, create new attendance instance
                    studentAttendance = new Attendance(asurite, time);
                    attendanceList.add(studentAttendance);
                }
            }

            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return attendanceList;
    }
}
