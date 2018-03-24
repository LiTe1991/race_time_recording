/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import race_time_recording.model.Starter;

/**
 *
 * @author LiTe
 */
public class StarterTester {
    
    public StarterTester() {
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
    public void starterCreation() {
        Starter starter = new Starter(1, "Starter 1");

        assertEquals(starter.getStarterPosition(), 1);
        assertEquals(starter.getName(), "Starter 1");
        assertEquals(starter.getTimes().size(), 0);
        
        System.out.println("Starterposition: " + starter.getStarterPosition());
        System.out.println("Startername: " + starter.getName());
        System.out.println("Driven rounds: " + starter.getTimes().size());
        
        starter.getTimes().add(65000L);
        
        starter.getTimes().add(54350L);
        starter.addPylons(2);
        starter.addGates(1);
        
        assertEquals(starter.getTimes().get(0).longValue(), 65000L);
        assertEquals(starter.getPylons(), 2);
        assertEquals(starter.getGates(), 1);
        assertEquals(starter.getTimes().get(1).longValue(), 54350L);
        
        starter.addPylons(1);
        starter.addGates(0);
        assertEquals(starter.getPylons(), 3);
        assertEquals(starter.getGates(), 1);
        
        starter.setPylons(0);
        starter.setGates(0);
        assertEquals(starter.getPylons(), 0);
        assertEquals(starter.getGates(), 0);
        
        System.out.println("Starterposition: " + starter.getStarterPosition());
        System.out.println("Startername: " + starter.getName());
        System.out.println("Driven rounds: " + starter.getTimes().size());
        int i = 1;
        SimpleDateFormat simpleDateFormater = new SimpleDateFormat("mm:ss.SSS");
        for(Long r : starter.getTimes()) {
            System.out.println("Round " + i + ":");
            System.out.println("Driven time: " + simpleDateFormater.format(r));
            System.out.println("Pylons: " + starter.getPylons());
            System.out.println("Gates: " + starter.getGates());
        }
    }
}
