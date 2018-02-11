/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

/**
 *
 * @author c4sti3l
 */
public class Starter {

    private String name;
    private String time;
    private long roundTimes[];
    private int numberRounds;
    
    public Starter(String name, int numberRounds) {
        this.name = name;
        this.numberRounds = numberRounds;
        this.time = "00:00:00";
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long[] getRoundTimes() {
        return roundTimes;
    }

    public void setRoundTimes(long[] roundTimes) {
        this.roundTimes = roundTimes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRoundTime(int index, long time) {
        roundTimes[index] = time;
    }

    public long[] getRoundTimeArray() {
        return roundTimes;
    }

    public long getRoundTime(int index) {
        return roundTimes[index];
    }

    public int getNumberRounds() {
        return numberRounds;
    }

    public void setNumberRounds(int numberRounds) {
        this.numberRounds = numberRounds;
    }
}
