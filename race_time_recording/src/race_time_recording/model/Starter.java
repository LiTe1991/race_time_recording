/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author c4sti3l
 */
public class Starter {

    private int starterPosition;
    private String name;
    private List<Round> rounds;

    /**
     * Erstellt ein neues Starter Objekt
     *
     * @param starterPosition Die Position in der Starterreihenfolge als int
     * @param name Der Name des Starters als String
     */
    public Starter(int starterPosition, String name) {
        this.starterPosition = starterPosition;
        this.name = name;
        rounds = new ArrayList<>();
    }

    /**
     * Liefert die Startposition des Starters zurück
     *
     * @return int
     */
    public int getStarterPosition() {
        return starterPosition;
    }

    /**
     * Setzt die Startposition des Starters
     *
     * @param starterPosition Die Startposition als int
     */
    public void setStarterPosition(int starterPosition) {
        this.starterPosition = starterPosition;
    }

    /**
     * Liefert den Namen des Startes zurück
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen des Starters
     *
     * @param name Der Name als String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Liefert die Liste mit den gefahrenen Runden zurück
     *
     * @return List
     */
    public List<Round> getRounds() {
        return rounds;
    }

    /**
     * Setzt die Liste mit den gefahrenen Runden des Starters
     *
     * @param rounds Die Liste mit den Runden als List
     */
    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
