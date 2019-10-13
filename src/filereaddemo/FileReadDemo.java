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

/**
 *
 * @author jtabo_000
 */
public class FileReadDemo {

    /**
     * @param args the command line arguments
     */
    static ArrayList<String[]> allLogs = new ArrayList<String[]>();

    public static void parseLine(String line, int i, int k){
        String holder = "";      
        String[] parsed = {"", "", "", "", ""};
        if (k < 4){
            for (; line.charAt(i) != ' ' ; i++)
                holder += line.charAt(i); 
            
            parsed[k] = holder;
            parseLine(line, i+1, k+1);
        }
        else{
            for (i+=2; i<line.length() ; i++)
                holder += line.charAt(i);  
            
            parsed[k] = holder;
            allLogs.add(parsed);
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
            for (int i = 0; i < allLogs.size(); i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.println(allLogs.get(i)[j]);
                }
            }
        }  
    }
    
}
