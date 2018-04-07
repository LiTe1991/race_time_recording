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
        ConfigLoader configLoader = new ConfigLoader();
        List<String> list = configLoader.getStarternameList();
        int i = 0;
        for (String l : list) {
            Starter s = new Starter(i, l);
            ArrayList<Long> times = new ArrayList();
            times.add(System.currentTimeMillis());
            times.add(System.currentTimeMillis());
            times.add(System.currentTimeMillis());
            s.setTimes(times);
            starter.add(s);
            i++;
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
        if (columnIndex > 0) {
            return starter.get(rowIndex).getFormattedTime(1);
        }
        return starter.get(rowIndex).getName();
    }

    @Override
    public String getColumnName(int col) {
        return header[col];
    }

    public List<Starter> getList() {
        return starter;
    }
}
