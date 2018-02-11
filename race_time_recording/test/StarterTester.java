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
import race_time_recording.model.Round;
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
        assertEquals(starter.getRounds().size(), 0);
        
        System.out.println("Starterposition: " + starter.getStarterPosition());
        System.out.println("Startername: " + starter.getName());
        System.out.println("Driven rounds: " + starter.getRounds().size());
        
        Round round1 = new Round();
        round1.setTime(65000);
        round1.setPylons(0);
        round1.setGates(0);
        starter.getRounds().add(round1);
        
        Round round2 = new Round();
        round2.setTime(54350);
        round2.setPylons(2);
        round2.setGates(1);
        starter.getRounds().add(round2);
        
        assertEquals(starter.getRounds().get(0).getTime(), 65000);
        assertEquals(starter.getRounds().get(0).getPylons(), 0);
        assertEquals(starter.getRounds().get(0).getGates(), 0);
        assertEquals(starter.getRounds().get(1).getTime(), 54350);
        assertEquals(starter.getRounds().get(1).getPylons(), 2);
        assertEquals(starter.getRounds().get(1).getGates(), 1);
        
        System.out.println("Starterposition: " + starter.getStarterPosition());
        System.out.println("Startername: " + starter.getName());
        System.out.println("Driven rounds: " + starter.getRounds().size());
        int i = 1;
        SimpleDateFormat simpleDateFormater = new SimpleDateFormat("mm:ss.SSS");
        for(Round r : starter.getRounds()) {
            System.out.println("Round " + i + ":");
            System.out.println("Driven time: " + simpleDateFormater.format(r.getTime()));
            System.out.println("Pylons: " + r.getPylons());
            System.out.println("Gates: " + r.getGates());
        }
    }
}
