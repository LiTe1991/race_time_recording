/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author c4sti3l
 */
public class ConfigLoader {

    private String starterUrl = "src/race_time_recording/config/starter.txt";

    
    /**
     * 
     * @return ArrayList of Starters from Config
     * @throws IOException 
     */
    public ArrayList<String> loadStarter() throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader(starterUrl));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        
        while (line != null) {
            listOfLines.add(line);
            line = bufReader.readLine();
        }
        
        bufReader.close();
        
        return listOfLines;
    }

}
