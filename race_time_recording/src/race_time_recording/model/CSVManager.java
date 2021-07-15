/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVPrinter;

/**
 *
 * @author LiTe
 */
public class CSVManager {

    private final String FILE_NAME = "src/race_time_recording/csv/_temp.csv";
    private final String LINE_SERPARATOR = "\n";

    private ArrayList<Object> csv_header;
    private FileWriter fileWriter;
   // private CSVPrinter csvPrinter;

    public CSVManager(int rounds) {
        csv_header = new ArrayList<>();
        csv_header.add("starterpos");
        csv_header.add("name");
        csv_header.add("pylonen");
        csv_header.add("tore");
        csv_header.add("runden");

        for (int i = 0; i < rounds; i++) {
            csv_header.add("runde" + (i + 1));
        }
    }

    /**
     * Erstellt eine CSV Datei anhand der übergebenen Liste
     *
     * @param list Die Liste mit den Startern
     * @return boolean
     */
    public boolean exportCSV(List<Starter> list) {
        try {
        //    CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator(LINE_SERPARATOR);
            fileWriter = new FileWriter(new File(FILE_NAME));
        //    csvPrinter = new CSVPrinter(fileWriter, csvFormat);

         //   csvPrinter.printRecord(csv_header.toArray());
            for (Starter starter : list) {
                List<String> _tempList = new ArrayList();
                _tempList.add(starter.getName());
                //_tempList.add(String.valueOf(starter.getNumberRounds()));
                
           //     csvPrinter.printRecord(_tempList);
            }
        } catch (IOException ex) {
            Logger.getLogger(CSVManager.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
             //   if (csvPrinter != null) {
             //       csvPrinter.close();
             //   }
            } catch (IOException ex) {
                Logger.getLogger(CSVManager.class.getName()).log(Level.SEVERE, null, ex);

                return false;
            }
        }

        return true;
    }
}
