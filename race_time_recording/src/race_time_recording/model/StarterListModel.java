/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author c4sti3l
 */
public class StarterListModel extends AbstractListModel {

    private List<String> starter = new LinkedList<>();

    public StarterListModel() throws IOException {
        ConfigLoader configLoader = new ConfigLoader();
        ArrayList<String> list = configLoader.loadStarter();
        for (String l : list) {
            starter.add(l);
        }
    }

    @Override
    public int getSize() {
        return starter.size();
    }

    @Override
    public Object getElementAt(int index) {
        return starter.get(index);
    }

}