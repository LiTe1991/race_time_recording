/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.controller;

import java.io.IOException;
import java.util.ArrayList;
import race_time_recording.model.ConfigLoader;
import race_time_recording.view.MainMenuFrame;

/**
 *
 * @author LiTeM
 */
public class MainMenuController {
    private final MainMenuFrame frame;
    private final ConfigLoader configLoader;
    
    public MainMenuController(MainMenuFrame frame) {
        this.frame = frame;
        this.configLoader = new ConfigLoader();
    }
    
    public void initFrame() {
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        frame.setVisible(true);
    }

}
