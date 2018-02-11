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
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author c4sti3l
 */
public class StarterTableModel extends AbstractTableModel {

    private List<Starter> starter = new LinkedList<>();
    private String[] header = {"Name", "Zeit"};

    public StarterTableModel() {
        try {
            ConfigLoader configLoader = new ConfigLoader();
            ArrayList<String> list = configLoader.loadStarter();
            for (String l : list) {
                starter.add(new Starter(l, 0));
            }
        } catch (IOException ex) {
            System.out.println("ERROR: Starter laden fehlgeschlagen!");
        }
    }

    @Override
    public int getRowCount() {
        return starter.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex>0)
            return starter.get(rowIndex).getTime();
        return starter.get(rowIndex).getName();
    }

    @Override
    public String getColumnName(int col) {
        return header[col];
    }
}
