/**
 * CSE 360: Introduction to Software Engineering Fall 2020 - 70606
 * @Contributers: Simran Bhalla, Nicholas Fulton 
 *
 * Final Project -
 * Create an application with a menu bar consisting of two items: "File" and "About", where "File" contains a submenu of
 * four more items, "Load Roster", "Add Attendance", "Save", "Plot Data". The application will read in directed csv
 * files when loading a roster, and adding attendance, and save a file of specified file path and name. When plotting
 * data, a pop up will appear with the data plotted.
 *
 * Due 2, December 2020
 *
 * This file contains PlotData class, its constructor, and related method(s): createAttendanceDataset(), draw().
 */

package cse360FinalProject;

import java.awt.Color;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Creates a pop up that displays data from a Table instance on a graph. 
 */
public class PlotData extends JFrame {

    /**
     * Constructor creates pop up and graph with data from inputted table. 
     * @param title - String value of the title of the plot.
     * @param table - Table instance with the data to be plotted.
     */ 
    public PlotData(String title, Table table) {
        super(title);
        
        // Getting dataset
        XYDataset dataset = createAttendanceDataset(table);

        // Making the chart
        JFreeChart chart = ChartFactory.createScatterPlot("Attendance Chart", "Meeting Time Present (%)", "Count", dataset);

        //Changes background color
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));

        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setTickUnit(new NumberTickUnit(1));

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

    }

    /**
     * Creates the data set that is to be plotted on the graph. 
     * @param table - Table instance with the data to be extracted.
     */
    private XYDataset createAttendanceDataset(Table table) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        // Get attendance data
        for(int column = 6; column < table.getColumnCount(); column++){// Get an array of attendance
            String date = table.getColumnName(column);

            int attendance[] = table.getAttendance(column);
           
            // Making XY dataset
            XYSeries series1 = new XYSeries(date);

            // setting x-axis and y-axis
            int[] count = new int[11];

            for(int i = 0; i < attendance.length; i++){
                count[(attendance[i]*10)/75]++;
            }

            for (int i = 0; i < count.length; i++) {
                if(count[i] != 0){
                    series1.add(i * 10, count[i]);
                }
            }

            dataset.addSeries(series1);
        }

        return dataset;
    }

    
    /**
     * drawing the plot or graph 
     * @param table - Table instance to be drawn as a graph.
     */
    public void draw(Table table){
        SwingUtilities.invokeLater(() -> {
            PlotData attendanceData = new PlotData("Attendance Chart", table);
            attendanceData.setSize(800, 400);    // setting graph size 
            attendanceData.setLocationRelativeTo(null);
            attendanceData.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            attendanceData.setVisible(true);
        });
    }
}
