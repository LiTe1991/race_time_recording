/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c4sti3l
 */
public class ConfigLoader {

    private static ConfigLoader INSTANCE;

    private final static String STARTER_URL = "src/race_time_recording/config/config.properties";
    private final static String KEY_ROUNDS = "roundCount";
    private final static String KEY_PYLONE = "pylonenTime";
    private final static String KEY_GATE = "gateTime";
    private final static String KEY_STARTER = "starter";
    private final static String KEY_RENNTYPS = "rennTyps";

    private Properties properties;
    private boolean isRace;

    public ConfigLoader() {
        isRace = true;

        properties = new Properties();
        BufferedInputStream inputStream = null;

        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(STARTER_URL)));
            properties.load(inputStream);
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
            fos = new FileOutputStream(new File(STARTER_URL));

            properties.store(fos, "Store the new Config");
            properties.clear();

            INSTANCE = null;
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
        return Integer.valueOf(properties.getProperty(KEY_ROUNDS));
    }

    /**
     * Setzt die Standardanzahl an Runden, um die Änderungen dauerhaft zu machen
     * muss die Methode saveConfig() aufgerufen werden
     *
     * @param rounds Die Anzahl an Runden als int
     */
    public void setRounds(int rounds) {
        properties.setProperty(KEY_ROUNDS, String.valueOf(rounds));
    }

    /**
     * Liefert die Strafzeit für eine einzelne Pylone zurück
     *
     * @return long
     */
    public long getPenaltyTimePylone() {
        return Long.valueOf(properties.getProperty(KEY_PYLONE));
    }

    /**
     * Setzt die standardmäßige Strafzeit für eine Pylone
     *
     * @param time Die gewünchte Strafzeit als Long
     */
    public void setPenaltyTimePylone(long time) {
        properties.setProperty(KEY_PYLONE, String.valueOf(time));
    }

    /**
     * Liefert die Strafzeit für ein einzelnes Tor zurück
     *
     * @return long
     */
    public long getPenaltyTimeGate() {
        return Long.valueOf(properties.getProperty(KEY_GATE));
    }

    /**
     * Setzt die standardmäßige Strafzeit für ein Tor
     *
     * @param time Die gewünschte Strafzeit als Long
     */
    public void setPenaltyTimeGate(long time) {
        properties.setProperty(KEY_GATE, String.valueOf(time));
    }

    /**
     * Liefert eine Liste mit den Startern zurück
     *
     * @return List
     */
    public List<String> getStarterList() {
        String tempStarter = properties.getProperty(KEY_STARTER);

        return Arrays.asList(tempStarter.split(","));
    }

    /**
     * Setzt die komplette Starterliste
     *
     * @param starter Die Namen der Starter für die Starterliste
     */
    public void setStarterList(List<String> starter) {
        String tempStarterList = "";

        for (String s : starter) {
            tempStarterList = tempStarterList + ',' + s;
        }

        properties.setProperty(KEY_STARTER, tempStarterList);
    }

    /**
     * Fügt einen Starter zu der bestehenden Liste hinzu
     *
     * @param starter Der Startername als String
     */
    public void addStarterToList(String starter) {
        String tempStarterList = properties.getProperty(KEY_STARTER);

        tempStarterList = tempStarterList + ',' + starter;

        properties.setProperty(KEY_STARTER, tempStarterList);
    }

    /**
     * Liefert eine Liste mit den verschiedenen Renntypen zurück
     *
     * @return List
     */
    public List<String> getRennTyps() {
        String tempRennTyps = properties.getProperty(KEY_RENNTYPS);

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
}