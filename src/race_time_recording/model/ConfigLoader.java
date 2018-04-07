/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c4sti3l
 */
public class ConfigLoader {

    private static ConfigLoader INSTANCE;

    private final static String FONT_URL = "src/race_time_recording/config/digital-7.ttf";
    private final static String CONFIG_URL = "src/race_time_recording/config/config.properties";
    private final static String KEY_ROUNDS = "roundCount";
    private final static String KEY_PYLONE = "pylonenTime";
    private final static String KEY_GATE = "gateTime";
    private final static String KEY_STARTER = "starter";
    private final static String KEY_RENNTYPS = "rennTyps";

    private Properties permProperties;
    private Properties tempProperties;
    private boolean isRace;
    private ArrayList<Starter> starter;
    
    public ConfigLoader() {
        isRace = true;
        starter = new ArrayList<>();
        
        permProperties = new Properties();
        tempProperties = new Properties();
        BufferedInputStream inputStream = null, inputStream2 = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(CONFIG_URL)));
            permProperties.load(inputStream);
            inputStream2 = new BufferedInputStream(new FileInputStream(new File(CONFIG_URL)));
            tempProperties.load(inputStream2);
        } catch (IOException ex) {
            Logger.getLogger(ConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(ConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
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
     * Sollte wirklich nur zum Schluss aufgerufen werden, wenn alle gewünschten
     * Änderungen durchgeführt wurden
     */
    public void saveConfig() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(CONFIG_URL));

            permProperties.store(fos, "Store the new Config");
        } catch (IOException ex) {
            Logger.getLogger(ConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(ConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Liefert die Anzahl der Standardrunden zurück
     *
     * @return int
     */
    public int getRounds() {
        return Integer.valueOf(tempProperties.getProperty(KEY_ROUNDS));
    }

    /**
     * Setzt die Standardanzahl an Runden, um die Änderungen dauerhaft zu machen
     * muss die Methode saveConfig() aufgerufen werden
     *
     * @param rounds Die Anzahl an Runden als int
     * @param perm
     */
    public void setRounds(int rounds, boolean... perm) {
        tempProperties.setProperty(KEY_ROUNDS, String.valueOf(rounds));
        
        if(perm != null && perm[0])
            permProperties.setProperty(KEY_ROUNDS, String.valueOf(rounds));
    }

    /**
     * Liefert die Strafzeit für eine einzelne Pylone zurück
     *
     * @return int
     */
    public int getPenaltyTimePylone() {
        return Integer.valueOf(tempProperties.getProperty(KEY_PYLONE));
    }

    /**
     * Setzt die standardmäßige Strafzeit für eine Pylone
     *
     * @param time Die gewünchte Strafzeit als Sekunden
     * @param perm
     */
    public void setPenaltyTimePylone(int time, boolean... perm) {
        tempProperties.setProperty(KEY_PYLONE, String.valueOf(time));
        
        if(perm != null && perm[0])
            permProperties.setProperty(KEY_PYLONE, String.valueOf(time));
    }

    /**
     * Liefert die Strafzeit für ein einzelnes Tor zurück
     *
     * @return long
     */
    public int getPenaltyTimeGate() {
        return Integer.valueOf(tempProperties.getProperty(KEY_GATE));
    }

    /**
     * Setzt die standardmäßige Strafzeit für ein Tor
     *
     * @param time Die gewünschte Strafzeit als Sekunden
     * @param perm 
     */
    public void setPenaltyTimeGate(int time, boolean... perm) {
        tempProperties.setProperty(KEY_GATE, String.valueOf(time));
        
        if(perm != null && perm[0])
            permProperties.setProperty(KEY_GATE, String.valueOf(time));
    }

    /**
     * Liefert eine Liste mit den Startern zurück
     *
     * @return List
     */
    public List<String> getStarternameList() {
        String tempStarter = tempProperties.getProperty(KEY_STARTER);

        return Arrays.asList(tempStarter.split(","));
    }

    public List<Starter> getStarterList(List<String> startername, boolean... random) {
        ArrayList numberList = new ArrayList();
        for(int i = 0; i < startername.size(); i++) {
            numberList.add(i + 1);
        }
        
        Random rd = new Random();
        startername.forEach(st -> {
            int pos = (int) numberList.remove(rd.nextInt(numberList.size() - 1));
            
            starter.add(pos - 1, new Starter(pos, st));
        });
        
        return starter;
    }
    
    /**
     * Setzt die komplette Starterliste
     *
     * @param starter Die Namen der Starter für die Starterliste
     */
    public void setStarternameList(List<String> starter) {
        String tempStarterList = "";

        Collections.sort(starter);
        
        for (String s : starter) {
            tempStarterList += ',' + s;
        }

        tempProperties.setProperty(KEY_STARTER, tempStarterList);
    }

    /**
     * Liefert eine Liste mit den verschiedenen Renntypen zurück
     *
     * @return List
     */
    public List<String> getRennTyps() {
        String tempRennTyps = tempProperties.getProperty(KEY_RENNTYPS);

        return Arrays.asList(tempRennTyps.split(","));
    }

    /**
     * Liefert zurück ob es ein Rennen ist oder Geschicklichkeit
     *
     * @return boolean
     */
    public boolean isIsRace() {
        return isRace;
    }

    /**
     * Setzt ein Rennen oder Geschicklichkeit, Rennen = true und Geschlichkeit =
     * false
     *
     * @param isRace Rennen oder Geschicklichkeit als boolean
     */
    public void setIsRace(boolean isRace) {
        this.isRace = isRace;
    }

    /**
     * Liefert die "DigitFont" in vorgegebener Größe
     *
     * @param size
     * @return Font
     * @throws FileNotFoundException
     */
    public Font getDigitFont(int size) throws FileNotFoundException {
        try {
            FileInputStream file = new FileInputStream(new File(FONT_URL));
            return Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(Font.PLAIN, size);
        } catch (Exception ex) {
            System.out.println("Font konnte nicht geladen werden.");
        }
        return new Font("SansSerif", Font.PLAIN, size);
    }

}
