/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaddemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author jtabo_000
 */
public class FileReadDemo {

    /**
     * @param args the command line arguments
     */
    static String[] parsed = {"", "", "", "", ""};
    static String tableData[][] = new String[10][5];
    static int j = 0;
    
    public static void parseLine(String line, int i, int k){
        String holder = "";

        if (k < 4){
            for (; line.charAt(i) != ' ' ; i++)
                holder += line.charAt(i); 
            
            tableData[j][k] = holder;
            parseLine(line, i+1, k+1);
        }
        else{
            for (i+=2; i<line.length() ; i++)
                holder += line.charAt(i);  
            
            tableData[j][k] = holder;
            j++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File logs = new File("./logs");
        
        try (BufferedReader br = new BufferedReader(new FileReader(logs))) {
        String line;
            while ((line = br.readLine()) != null) {
                int i = 0, k = 0;
                parseLine(line, i, k);
            }
        }
        
        JFrame frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DemoVisual table = new DemoVisual(tableData);
        
        table.setOpaque(true); 
        frame.setContentPane(table);
 
        frame.pack();
        frame.setVisible(true);
    }
    
}
