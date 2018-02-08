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
    private long roundTimes[];
    private int numberRounds;
    
    public Starter(String name, int numberRounds) {
        this.name = name;
        this.numberRounds = numberRounds;
    }
    
    public void setName(String name){
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
