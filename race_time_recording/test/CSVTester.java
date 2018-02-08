/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import race_time_recording.model.CSVManager;
import race_time_recording.model.Starter;

/**
 *
 * @author LiTe
 */
public class CSVTester {
    
    public CSVTester() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void exportTest() {
        List<Starter> list = new ArrayList<>();
        list.add(new Starter("Vadim", 3));
        list.add(new Starter("Chris", 3));
        list.add(new Starter("Fabi", 0));
        
        CSVManager exporter = new CSVManager();
        boolean result = exporter.writeCSV(list);
        
        assertTrue(result);
    }
}
