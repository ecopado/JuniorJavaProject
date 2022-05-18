Arizona State University

CSE 360, SLN 70606 - Introduction to Software Engineering - Fall 2020

Prof. Javier Gonzalez-Sanchez 

# Final-Project
Due Monday, 30 November 2020

Creates a GUI with a menu bar containing two items: "File" and "About." "About" will contain developer information (team information). "File" will open a menu containing four functionalities: "Load Roster", "Add Attendance", "Save", and "Plot Data." 

#### Limitations
May only use Java Util, Java AWT, Java Swing, and only one external library is allowed: JFreeChart.

## File

**Load a Roster :** Selecting this feature will prompt the user for a File path to a CSV (Comma Separated Values) file. Data from the file will be read and loaded into a data structure, then displayed in a table. There will be horizontal and vertical scrollbars to allow the user to pan through the data table.
- **File input** will have six fields per row: ID number, first name, last name, program and plan, academic level, and ASURITE. 

**Add Attendance :** Selecting this feature will prompt the user for a File path to another CSV file. Data from the file provided will be loaded into the data structured created with the roster and create a new column to the far right of the table to display each attendee's connection time, using the ASURITE column as reference. If an attendee in the attendance file is not on the roster, then the user will be notified of the attendee's information and connection time. The feature will remember the selected date. More than one file can be loaded, each one adding a new column to the table.  
- **File input** will have two fields per row: ASURITE and connection time in minutes. 

**Save :** Selecting this feature will save all the data in the displayed table into a CSV file. 

**Plot Data :** Selecting this feature will create a scatter plot using the attendance data per student. The y-axis is the number of students and the x-axis is a percent representation of the student's presence during the meeting, where 100% represents the full 75 minutes or more. 


>## About
>Team Members:
>- Linda Lau - ltlau@asu.edu
>- Jenny Wong - jwwong5@asu.edu
>- Simran Bhalla - ssbhalla@asu.edu
>- Emmanuel Copado - ecopado@asu.edu
>- Nicholas Fulton - nkfulton@asu.edu
