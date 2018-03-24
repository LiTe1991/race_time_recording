/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author c4sti3l
 */
public class Starter {

    private int starterPosition;
    private String name;
    private ArrayList<Long> times;
    private int pylons;
    private int gates;

    /**
     * Erstellt ein neues Starter Objekt
     *
     * @param starterPosition Die Position in der Starterreihenfolge als int
     * @param name Der Name des Starters als String
     */
    public Starter(int starterPosition, String name) {
        this.starterPosition = starterPosition;
        this.name = name;
        times = new ArrayList<>();
        pylons = 0;
        gates = 0;
    }

    /**
     * Formatiert die Rundenzeit zum Format mm:ss.SSS und liefert diese danach
     * zurück, falls es keien Zeit für die Runde gibt wird ein Empty String
     * zurück geliefert
     *
     * @param round Die Runde von welcher die Zeit formatiert werden soll
     *
     * @return String
     */
    public String getFormattedTime(int round) {
        if (times.size() >= round) {
            SimpleDateFormat tempFormater = new SimpleDateFormat("mm:ss.SSS");
            return tempFormater.format(times.get((round - 1)));
        } else {
            return "";
        }
    }

    /**
     * Wertet anhand der Anzahl von Pylonen und Toren aus, wie viel Strafzeit
     * draufzurechnen ist. Danach wird diese Strafzeit auf die gefahre Zeit
     * draufgerechnet, formatiert und zurück geliefert. Folgendes Format wird
     * zum formatieren verwendet mm:ss.SSS
     *
     * Für die Strafsekunden pro Pylone und Tor werden zur Zeit noch Mockobjekte
     * verwendet
     *
     * @return String
     */
    public String getEvaluatedTime() {       
        long tempPenaltyTimePylone = ConfigLoader.getInstance().getPenaltyTimePylone();
        long tempPenaltyTimeGate = ConfigLoader.getInstance().getPenaltyTimeGate();
        
        //long evaluatedTime -> times.forEach((Long time) -> {evaluatedTime += time});

        SimpleDateFormat tempFormater = new SimpleDateFormat("mm:ss.SSS");
        //return tempFormater.format(evaluatedTime);
        return "";
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
     * Liefert eine Liste mit allen Rundenzeiten zurück
     *
     * @return ArrayList
     */
    public ArrayList<Long> getTimes() {
        return times;
    }

    /**
     * Setzt die Liste mit allen Rundenzeiten
     *
     * @param times Die Liste mit den Rundenzeiten als ArrayList
     */
    public void setTimes(ArrayList<Long> times) {
        this.times = times;
    }

    /**
     * Liefert die Anzahl an umgefahrenen Pylonen
     *
     * @return int
     */
    public int getPylons() {
        return pylons;
    }

    /**
     * Setzt die Anzahl an umgefahrenen Pylonen.
     *
     * @param pylons Die Anzahl der Pylonen als int
     */
    public void setPylons(int pylons) {
        this.pylons = pylons;
    }

    /**
     * Fügt die übergebene Anzahl an Pylonen zu den bestehenden hinzu
     * 
     * @param pylons Die Anzahl der zu hinzufügenden Pylonen als int
     */
    public void addPylons(int pylons) {
        this.pylons += pylons;
    }
    
    /**
     * Liefert die Anzahl an verpassten Toren
     *
     * @return int
     */
    public int getGates() {
        return gates;
    }

    /**
     * Setzt die Anzahl an verpassten Toren
     *
     * @param gates Die Anzahl der Tore als int
     */
    public void setGates(int gates) {
        this.gates = gates;
    }
    
    /**
     * Fügt die übergebene Anzahl an Toren zu den bestehenden hinzu
     * 
     * @param gates Die Anzahl der zu hinzufügenden Tore als int
     */
    public void addGates(int gates) {
        this.gates += gates;
    }
}
