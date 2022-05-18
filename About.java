/**
 * CSE 360: Introduction to Software Engineering Fall 2020 - 70606
 * @Contributers: Nicholas Fulton, Linda Lau, Emmanuel Copado
 *
 * Final Project -
 * Create an application with a menu bar consisting of two items: "File" and "About", where "File" contains a submenu of
 * four more items, "Load Roster", "Add Attendance", "Save", "Plot Data". The application will read in directed csv
 * files when loading a roster, and adding attendance, and save a file of specified file path and name. When plotting
 * data, a pop up will appear with the data plotted.
 *
 * Due 2, December 2020
 *
 * This file contains only the About class. Creates a menu item to a component. When menu item is interacted with, pop
 * up window wil display developer information for this application.
 */

package cse360FinalProject;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * About class creates a menu item and the pop up displaying message containing developer information.
 */
public class About extends JMenu {
	private Component parent;
	private JMenu menu;
	public About(Component parent) {
		super("About");

		this.parent = parent;
		this.menu = this;

		/**
		 * Create action performed when this class is interacted with.
		 */
		addMenuListener(new MenuListener() {
			/**
			 * Action performed when the class is selected
			 * @param arg0 - Action used to interact with class
			 */
			@Override
			public void menuSelected(MenuEvent arg0) {
				// Display pop up
				JOptionPane.showMessageDialog(
						parent,
						"Team Members:\n" +
								"Linda Lau - ltlau@asu.edu\n" +
								"Jenny Wong - jwwong5@asu.edu\n" +
								"Simran Bhalla - ssbhalla@asu.edu\n" +
								"Emmanuel Copado - ecopado@asu.edu\n" +
								"Nicholas Fulton - nkfulton@asu.edu",
						"About",
						JOptionPane.PLAIN_MESSAGE);

				new Timer(50, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						menu.setSelected(false);
					}
				}).start();
			}

			/**
			 * Unused implementation of abstract method.
			 * @param arg0
			 */
			@Override
			public void menuCanceled(MenuEvent arg0) {
				return;
			}

			/**
			 * Unused implementation of abstract method.
			 * @param arg0
			 */
			@Override
			public void menuDeselected(MenuEvent arg0) {
				return;
			}
		});
	}
}