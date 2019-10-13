/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaddemo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
 
/** 
 * TableDemo is just like SimpleTableDemo, except that it
 * uses a custom TableModel.
 */
public class DemoVisual extends JPanel {
    private boolean DEBUG = false;
    
    static ArrayList<String[]> allLogs = new ArrayList<String[]>();
    
    public DemoVisual(ArrayList<String[]> allLogs) {
        super(new GridLayout(1,0));
        this.allLogs = allLogs;
        
        JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(600, 150));
        table.setFillsViewportHeight(true);
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
    }
 
    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Date",
                                        "Time",
                                        "Warning Type",
                                        "Log",
                                        "Student"};
 
        public int getColumnCount() {
            return columnNames.length;
        }
 
        public int getRowCount() {
            return allLogs.size();
        }
 
        public String getColumnName(int col) {
            return columnNames[col];
        }
 
        public Object getValueAt(int row, int col) {
            return allLogs.get(row)[col];
        }
 
 
        /* Para editar tabla
        public boolean isCellEditable(int row, int col) {
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }*/
 
        /*
         * Necesario para poder cambiar el dato de la tabla.
        */
        public void setValueAt(String value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }
 
            allLogs.get(row)[col] = value;
            fireTableCellUpdated(row, col);
 
            if (DEBUG) {
                System.out.println("New value of data:");
                printDebug();
            }
        }
 
        private void printDebug() {
            int numRows = getRowCount();
            int numCols = getColumnCount();
 
            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + allLogs.get(i)[j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
}