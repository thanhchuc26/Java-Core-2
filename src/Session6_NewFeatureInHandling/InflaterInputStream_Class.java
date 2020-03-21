/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

/**
 *
 * @author June
 */
public class InflaterInputStream_Class {

    public static void main(String[] args) {
        try {
            File finf = new File("d:/session06/InflatedMain.txt");
            FileOutputStream foutWrite = new FileOutputStream(finf);
            File fout = new File("d:/session06/DeflatedMain.txt");
            FileInputStream finRead = new FileInputStream(fout);
            InflaterInputStream defRead = new InflaterInputStream(finRead);
            System.out.println("File size before Inflation " + fout.length());
// Inflating the file to original size
            int bread = 0;
            while ((bread = defRead.read()) != -1) {
                foutWrite.write(bread);
            }
            foutWrite.close();
            System.out.println("File size after Inflation " + finf.length());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
