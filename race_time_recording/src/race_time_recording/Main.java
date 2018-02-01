/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording;

import race_time_recording.controller.MainMenuController;
import race_time_recording.view.MainMenuFrame;

/**
 *
 * @author LiTeM
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainMenuController mainMenuController = new MainMenuController(new MainMenuFrame());
        mainMenuController.initFrame();
    }
}
