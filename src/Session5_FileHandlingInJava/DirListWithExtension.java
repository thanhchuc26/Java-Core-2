/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author June
 */
class FileFilter implements FilenameFilter {

    String ext;

    public FileFilter(String ext) {
        this.ext = "." + ext;
    }

    @Override
    public boolean accept(File dir, String fName) {
        return fName.endsWith(ext);
    }
}

public class DirListWithExtension {

    public static void main(String[] args) {
        String dirName = "d:/session05";
        File fileObj = new File("d:/session05");
        FilenameFilter filterObj = new FileFilter("txt");
        String[] fileName = fileObj.list(filterObj);
        System.out.println("Number of files found : " + fileName.length);
        System.out.println("");
        System.out.println("Names of the files are : ");
        System.out.println("------------------------- ");
        for (int ctr = 0; ctr < fileName.length; ctr++) {
            System.out.println(fileName[ctr]);
        }
    }
}
