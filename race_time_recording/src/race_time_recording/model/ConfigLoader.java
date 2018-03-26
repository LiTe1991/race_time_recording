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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c4sti3l
 */
public class ConfigLoader {

    private static ConfigLoader INSTANCE;
    private final static String STARTER_URL = "src/race_time_recording/config/starter.txt";
    private final static String FONT_URL = "src/race_time_recording/config/digital-7.ttf";

    private FontManager fontManager;
    private ArrayList<String> listOfStarters;
    private long penaltyTimePylone;
    private long penaltyTimeGate;

    public ConfigLoader() {
        listOfStarters = new ArrayList<>();
        penaltyTimePylone = 1000L;
        penaltyTimeGate = 2000L;
        this.fontManager = new FontManager();

        BufferedReader bufReader = null;
        try {
            bufReader = new BufferedReader(new FileReader(STARTER_URL));
            String line = bufReader.readLine();

            while (line != null) {
                listOfStarters.add(line);
                line = bufReader.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(ConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bufReader != null) {
                try {
                    bufReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(ConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Liefert das einmalige Objekt der Klasse zurück. (Singelton Pattern)
     *
     * @return ConfigLoader
     */
    public static ConfigLoader getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConfigLoader();
        }

        return INSTANCE;
    }

    /**
     * Liefert die Strafzeit für eine einzelne Pylone zurück
     *
     * @return long
     */
    public long getPenaltyTimePylone() {
        return penaltyTimePylone;
    }

    /**
     * Liefert die Strafzeit für ein einzelnes Tor zurück
     *
     * @return long
     */
    public long getPenaltyTimeGate() {
        return penaltyTimeGate;
    }

    /**
     * Liefert die "DigitFont" in vorgegebener Größe
     *
     * @param size
     * @return Font
     * @throws FileNotFoundException
     */
    public Font getDigitFont(int size) throws FileNotFoundException {
        Font font = fontManager.getFont(new FileInputStream(new File(FONT_URL)), size);
        return font;
    }

    /**
     *
     * @return ArrayList of Starters from Config
     * @throws IOException
     */
    public ArrayList<String> loadStarter() throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader(STARTER_URL));
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
