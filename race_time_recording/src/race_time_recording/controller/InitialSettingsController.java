/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.controller;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultListSelectionModel;
import race_time_recording.model.CheckboxListCellRenderer;
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
        frame.setSize(new Dimension(100, 200));
        frame.initFrame();
        frame.setVisible(true);
    }

    public int getPyloneTime() {
        return (int) configLoader.getPenaltyTimePylone() / 1000;
    }

    public int getGateTime() {
        return (int) configLoader.getPenaltyTimeGate() / 1000;
    }

    public String getRaceType() {
        return this.raceType;
    }

    public String getRaceName() {
        return "TestName";
    }

    public String getRaceDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(date);
    }

    public int getRoundCount() {
        return 10;
    }

    public void startRace() {
        if (this.raceType == "geschicklichkeit") {
            SkillController controller = new SkillController();
            controller.initFrame();
        } else {
            RaceController controller = new RaceController();
            controller.initFrame();
        }

        frame.dispose();
    }
    
    public CheckboxListCellRenderer getStarterRenderer(){
        return new CheckboxListCellRenderer();
    }
    
    public DefaultListSelectionModel getSelectionModel(){
        CheckboxListCellRenderer renderer = new CheckboxListCellRenderer();
        return renderer.getSelectionModel();
    }
}
