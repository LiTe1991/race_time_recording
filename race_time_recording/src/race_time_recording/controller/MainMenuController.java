/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.controller;

import javax.swing.JFrame;
import race_time_recording.view.MainMenuFrame;

/**
 *
 * @author LiTeM
 */
public class MainMenuController {
    private final MainMenuFrame frame;
    
    public MainMenuController(MainMenuFrame frame) {
        this.frame = frame;
    }
    
    public void initFrame() {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        frame.setVisible(true);
    }
}
