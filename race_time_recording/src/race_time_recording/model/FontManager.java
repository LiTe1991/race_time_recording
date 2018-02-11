/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race_time_recording.model;

import java.awt.Font;
import java.io.FileInputStream;

/**
 *
 * @author Muschi
 */
public class FontManager {

    public Font getFont(FileInputStream file,int size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(Font.PLAIN, size);
        } catch (Exception ex) {
            System.out.println("Font konnte nicht geladen werden.");
        }
        return new Font("SansSerif", Font.PLAIN, size);
    }
}
