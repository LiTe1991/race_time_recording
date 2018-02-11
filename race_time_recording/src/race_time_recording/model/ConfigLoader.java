/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author c4sti3l
 */
public class ConfigLoader {

    private String starterUrl = "src/race_time_recording/config/starter.txt";
    private static String fontUrl = "src/race_time_recording/config/digital-7.ttf";
    private FontManager fontManager;

    public ConfigLoader(){
        this.fontManager = new FontManager();
    }
    
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

    public Font getDigitFont(int size) throws FileNotFoundException {
        Font font = fontManager.getFont(new FileInputStream(new File(fontUrl)),size);
        return font;
    }
}
