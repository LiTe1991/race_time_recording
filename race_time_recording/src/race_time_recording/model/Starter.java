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
    private int numberRounds;
    
    public Starter(String name, int numberRounds) {
        this.name = name;
        this.numberRounds = numberRounds;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }

    public int getNumberRounds() {
        return numberRounds;
    }

    public void setNumberRounds(int numberRounds) {
        this.numberRounds = numberRounds;
    }
}
