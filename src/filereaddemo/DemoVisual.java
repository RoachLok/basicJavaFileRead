/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaddemo;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

public class DemoVisual extends JPanel {
    
    public DemoVisual(Object[][] data) {
        super(new GridLayout(1,0));

        String[] columnNames = {"Date",
                                "Time",
                                "Warning Type",
                                "Student",
                                "Log"};


        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(600, 100));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }
    
    public void addRow (String[] parsed){
        
    }
}