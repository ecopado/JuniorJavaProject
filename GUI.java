/**
 * CSE 360: Introduction to Software Engineering Fall 2020 - 70606
 * @Contributers: Nicholas Fulton, Linda Lau
 *
 * Final Project -
 * Create an application with a menu bar consisting of two items: "File" and "About", where "File" contains a submenu of
 * four more items, "Load Roster", "Add Attendance", "Save", "Plot Data". The application will read in directed csv
 * files when loading a roster, and adding attendance, and save a file of specified file path and name. When plotting
 * data, a pop up will appear with the data plotted.
 *
 * Due 2, December 2020
 *
 * This file contains only the GUI class. This class creates the window and menu and submenus.
 */

package cse360FinalProject;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * Class GUI creates menubar and submenus. Has main method.
 */
public class GUI extends JFrame {
	/**
	 * Constructor for class GUI. Creates menubar and submenus with classes File and About.
	 */
	public GUI() {

		JMenuBar menuBar = new JMenuBar();

		// Adds menu and submenu items
		menuBar.add(new File(this));
		menuBar.add(new About(this));
		
		setJMenuBar(menuBar);
	}

	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(400, 400);
		gui.setVisible(true);
	}

}
