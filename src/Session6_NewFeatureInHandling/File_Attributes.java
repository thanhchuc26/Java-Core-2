/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

/**
 *
 * @author June
 */
public class File_Attributes {

    public static void main(String[] args) throws IOException {
        Path myPath = Paths.get("d://session06/session06.txt");
        DosFileAttributes fileAttributes = Files.readAttributes(myPath, DosFileAttributes.class);
        System.out.println(fileAttributes.isReadOnly());
        
    }
}
