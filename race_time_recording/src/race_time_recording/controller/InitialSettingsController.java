/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.controller;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import race_time_recording.model.ConfigLoader;
import race_time_recording.model.StarterTableModel;
import race_time_recording.view.InitialSettingsFrame;

/**
 *
 * @author LiTeM
 */
public class InitialSettingsController {

    private final InitialSettingsFrame frame;
    private final ConfigLoader configLoader;
    private String raceType;

    public InitialSettingsController(String raceType) {
        this.frame = new InitialSettingsFrame(this);
        this.configLoader = new ConfigLoader();
        this.raceType = raceType;
    }

    public void initFrame() {
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        try {
            frame.setTimeFont(configLoader.getDigitFont(280));
            frame.setRoundFont(configLoader.getDigitFont(140));
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: Font nicht gefunden");
        }
        System.out.println(configLoader.getPenaltyTimeGate());
        System.out.println(configLoader.getPenaltyTimePylone());
        frame.setSettingType(raceType);
        frame.setStarterTableModel(new StarterTableModel());
        frame.setSize(new Dimension(100, 200));
        frame.initFrame();
        frame.setVisible(true);
    }

}
