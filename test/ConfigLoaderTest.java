/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import race_time_recording.model.ConfigLoader;

/**
 *
 * @author LiTe
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConfigLoaderTest {
    @Test
    public void AtestConfigLoaderRounds() {
        int temp = ConfigLoader.getInstance().getRounds();
        
        System.out.println("Anzahl der Runden: " + temp);
        
        assertEquals(temp, 3);
    }
    
    @Test
    public void BtestConfigLoaderPylone() {
        long temp = ConfigLoader.getInstance().getPenaltyTimePylone();
        
        System.out.println("Strafzeit pro Pylone: " + temp);
        
        assertEquals(temp, 3000L);
    }
    
    @Test
    public void CtestConfigLoaderGate() {
        long temp = ConfigLoader.getInstance().getPenaltyTimeGate();
        
        System.out.println("Strafzeit pro Tor: " + temp);
        
        assertEquals(temp, 5000L);
    }
    
    @Test
    public void DtestConfigLoaderStarter() {
        List<String> temp = ConfigLoader.getInstance().getStarternameList();
        
        assertTrue(!temp.isEmpty());
        assertTrue(temp.size() == 5);
        
        temp.forEach(starter -> {System.out.println("Der Starter: " + starter);});
    }
    
    @Test
    public void EtestConfigLoaderIsRace() {
        boolean temp = ConfigLoader.getInstance().isIsRace();
        
        assertTrue(temp);
        
        System.out.println("Rennen ja?: " + temp);
        
        ConfigLoader.getInstance().setIsRace(false);
        
        temp = ConfigLoader.getInstance().isIsRace();
        
        assertFalse(temp);
        
        System.out.println("Rennen ja?: " + temp);
    }
    
    @Test
    public void FtestConfigLoaderSave() {
        ConfigLoader.getInstance().setRounds(5);
        ConfigLoader.getInstance().saveConfig();
        
        int temp = ConfigLoader.getInstance().getRounds();
        
        System.out.println("Anzahl neuer Runden: " + temp);
        
        assertEquals(temp, 5);
        
        ConfigLoader.getInstance().setRounds(3);
        ConfigLoader.getInstance().saveConfig();
    }
    
    @Test
    public void GtestConfigLoaderRennTyps() {
        List<String> temp = ConfigLoader.getInstance().getRennTyps();
        
        assertTrue(!temp.isEmpty());
        assertTrue(temp.size() == 3);
        
        temp.forEach(typ -> {System.out.println("Renntyp: " + typ);});
    }
    
    @Test
    public void HtestConfigLoaderIsRace2() {
        boolean temp = ConfigLoader.getInstance().isIsRace();
        
        assertTrue(temp);
        
        System.out.println("Rennen wieder ja?: " + temp);
    }
}
