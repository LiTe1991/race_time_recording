/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

import java.text.SimpleDateFormat;

/**
 *
 * @author LiTe
 * @ticket M04
 */
public class Round {

    private long time;
    private int pylons;
    private int gates;

    /**
     * Erstellt ein neues Runden Objekt mit den Startwerten.
     */
    public Round() {
        time = 0000000000000L;
        pylons = 0;
        gates = 0;
    }

    /**
     * Formatiert die Rundenzeit zum Format mm:ss.SSS und liefert diese danach
     * zurück
     *
     * @return String
     */
    public String getFormattedTime() {
        SimpleDateFormat tempFormater = new SimpleDateFormat("mm:ss.SSS");
        return tempFormater.format(time);
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
        long evaluatedTime = time + (pylons * 1000) + (gates * 2000);

        SimpleDateFormat tempFormater = new SimpleDateFormat("mm:ss.SSS");
        return tempFormater.format(evaluatedTime);
    }

    /**
     * Liefert die Rundenzeit zurück
     *
     * @return long
     */
    public long getTime() {
        return time;
    }

    /**
     * Setzt die Rundenzeit
     *
     * @param time Die gefahrene Rundenzeit als long
     */
    public void setTime(long time) {
        this.time = time;
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
}
