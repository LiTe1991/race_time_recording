/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.controller;

import java.io.FileNotFoundException;
import race_time_recording.model.ConfigLoader;
import race_time_recording.model.StarterTableModel;
import race_time_recording.view.MainMenuFrame;

/**
 *
 * @author LiTeM
 */
public class MainMenuController {

    private final MainMenuFrame frame;
    private final ConfigLoader configLoader;

    public MainMenuController() {
        this.frame = new MainMenuFrame();
        this.configLoader = new ConfigLoader();
    }

    public void initFrame() {
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        try {
            frame.setTimeFont(configLoader.getDigitFont(250));
            frame.setRoundFont(configLoader.getDigitFont(48));
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: Font nicht gefunden");
        }
        frame.setStarterTableModel(new StarterTableModel());
        frame.initFrame();
        frame.setVisible(true);
    }

}
