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
import static java.nio.file.Files.size;
import java.util.zip.InflaterOutputStream;
import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

/**
 *
 * @author June
 */
public class InflaterOutputStream_Class {
    public static void main(String[] args) {
        try {
// Writing decompressed data
File fin = new File("d:/session06/DeflatedMain1.txt");
FileInputStream finWrite = new FileInputStream(fin);
File fout = new File("d:/session06/InflatedMain1.txt");
FileOutputStream foutWrite = new FileOutputStream(fout);
InflaterOutputStream infWrite = new
InflaterOutputStream(foutWrite);
System.out.println("Original file size " + fin.length());
// Reading and writing the decompressed data
int bread = 0;
while ((bread = finWrite.read()) != -1) {
    infWrite.write(bread);
}
// Inflating the file to original size
infWrite.close();
System.out.println("File size after Inflation " + fout.length());
} catch (IOException ioe) {
ioe.printStackTrace();

}
    }
}
