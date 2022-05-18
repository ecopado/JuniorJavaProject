/**
 * CSE 360: Introduction to Software Engineering Fall 2020 - 70606
 * @Contributers: Nicholas Fulton, Linda Lau, Jenny Wong, Emmanuel Copado
 *
 * Final Project -
 * Create an application with a menu bar consisting of two items: "File" and "About", where "File" contains a submenu of
 * four more items, "Load Roster", "Add Attendance", "Save", "Plot Data". The application will read in directed csv
 * files when loading a roster, and adding attendance, and save a file of specified file path and name. When plotting
 * data, a pop up will appear with the data plotted.
 *
 * Due 2, December 2020
 *
 * This file contains File class. Creates the buttons for "Load Roster," "Add Attendance," "Save," and "Plot Data." 
 * Declares and defines method(s): getLoadRosterButton(), getAttendanceAdderButton(), getSaveButton(), and getPlotDataButton();
 * File is a menu item that contains a submenu containing items "Load Roster", "Add Attendance", "Save", "Plot Data". 
 * Class will proct a file chooser when "Load Roster", "Add Attendance", or "Save" are selected and perform respective actions.
 */

package cse360FinalProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

/**
 * File class extends JMenu and contains four JMenuItems, "Load Roster", "Add Attendance", "Plot Data", and "Save". Stores an 
 * instance of Table class and GUI class as global variables. This class is where the file chooser process of the project is 
 * performed.
 */
public class File extends JMenu {
	private static String fileName;
	private static JLabel l;
	private GUI window;
	private Table table;

	/**
	 * Constructor that creates adds buttons to the JMenu
	 * 
	 * @param GUI - Updates the GUI global variable
	 */
	public File(GUI window){
		super("File");
		this.window = window;

		// Adding buttons to the JMenu
		add(getLoadRosterButton());
		add(getAttendanceAdderButton());
		add(getSaveButton());
		add(getPlotDataButton());
	}
	
	/**
	 * Creates menu item "Load Roster" and assigns an action to the item.
	 */
	private JMenuItem getLoadRosterButton() {
		JMenuItem loadRoster = new JMenuItem("Load Roster");
		
		loadRoster.addActionListener(new ActionListener() {

			/**
			 * Looks for action performed i.e. "Load Roster" button pressed. Opens the file chooser and 
			 * creates an instance of Table with selected csv file, assigns to global variable "table", 
			 *  then presents it in the GUI frame.
			 * 
			 * @param arg0 The action event of button
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {

				// Create an object of JFileChooser class
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				// Invoke the showsOpenDialog function to show the file dialog
				int r = j.showOpenDialog(null);

				// If the user selects a file
				if (r == JFileChooser.APPROVE_OPTION)
				{
					window.getContentPane().removeAll();

					// Set the label to the path of the selected file
					fileName = j.getSelectedFile().getAbsolutePath();
					ArrayList<student> al = new ArrayList<>();
					rosterLoader roster = new rosterLoader();

					// ADD TABLE HERE
					table = new Table(roster.loadData(fileName), window);
					window.getContentPane().invalidate();
					window.getContentPane().validate();
				}

				// If the user cancelled the operation
				else
					l.setText("the user cancelled the operation");
			}
		});
		return loadRoster;
	}

	/**
	 * Creates menu item "Add Attendance" and assigns an action to the item.
	 */
	private JMenuItem getAttendanceAdderButton() {
		JMenuItem addAttendance = new JMenuItem("Add Attendance");

		addAttendance.addActionListener(new ActionListener() {

			/**
			 * Looks for action performed i.e. "Add Attendance" button pressed. When triggered, file chooser
			 * opens and the table stored in global variable "table" is updated with the information of 
			 * selected file and refreshes the GUI window. 
			 * 
			 * @param arg0 The action event of button
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// If there is no table loaded yet throw an ERROR
				if(table == null){
					JOptionPane.showMessageDialog(
						window,
						"Please load a file.",
						"ERROR",
						JOptionPane.PLAIN_MESSAGE);
				}
				
				// Create an object of JFileChooser class
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				// Invoke the showsOpenDialog function to show the save dialog
				int r = j.showOpenDialog(null);

				// If the user selects a file
				if (r == JFileChooser.APPROVE_OPTION)
				{
					window.getContentPane().removeAll();
					AttendanceAdder attendance = new AttendanceAdder();
					fileName = j.getSelectedFile().getAbsolutePath();
					table.addAttendance(attendance.loadAttendance(fileName));

					window.getContentPane().invalidate();
					window.getContentPane().validate();

				}
				// If the user cancelled the operation
				else
					l.setText("the user cancelled the operation");
			}
		});
		
		return addAttendance;
	}
	
	/**
	 * Creates menu item "Plat Data" and assigns an action to the item.
	 */
	private JMenuItem getPlotDataButton() {
		JMenuItem plotData = new JMenuItem("Plot Data");

		plotData.addActionListener(new ActionListener() {

			/**
			 * Looks for action performed i.e. "Plot Data" button pressed. When selected, using the information
			 * stored in global variable "table", data points are plotted on a graph and presented in a pop up
			 * frame. 
			 * 
			 * @param arg0 The action event of button
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {

				// If there is no table loaded yet throw an ERROR
				if(table == null){
					JOptionPane.showMessageDialog(
						window,
						"Please load a file.",
						"ERROR",
						JOptionPane.PLAIN_MESSAGE);
				}
				else if(table.getColumnCount() == 6){
					JOptionPane.showMessageDialog(
							window,
							"No attendance data added. Please add attendance then try again.",
							"ERROR",
							JOptionPane.PLAIN_MESSAGE);
				}
				else{
					// Plots the data from loaded table in a new JFrame
					PlotData data = new PlotData("Data", table);
					data.setSize(new Dimension(400,400));
					data.setVisible(true);
				}
			}
		});
		
		return plotData;
	}
	
	/**
	 * Creates menu item "Save" and assigns an action to the item.
	 */
	private JMenuItem getSaveButton() {
		JMenuItem save = new JMenuItem("Save");
		
		save.addActionListener(new ActionListener() {

			/**
			 * Looks for action performed i.e. "Save" button pressed. When selected, file chooser opens to 
			 * select a file path to save the current table as a csv file.
			 * 
			 * @param arg0 The action event of button
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileWriter writer = null;

				// Create an object of JFileChooser class
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				// Invoke the showsOpenDialog function to show the save dialog
				int r = j.showSaveDialog(null);

				// If the user selects a file
				if (r == JFileChooser.APPROVE_OPTION)
				{
					// Set the label to the path of the selected file
					fileName = j.getSelectedFile().getAbsolutePath();
					save csv = new save(fileName, table);
				}

				// If the user cancelled the operation
				else
					l.setText("the user cancelled the operation");

			}
		});
		
		return save;
	}
}
