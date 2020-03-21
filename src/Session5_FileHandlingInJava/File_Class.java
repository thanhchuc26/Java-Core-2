/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author June
 */
public class File_Class {

    static File myFile = null;
    static String path;

    static void taoThuMuc() {
        path = "d:/session05/batch";
        myFile = new File(path);
        myFile.mkdir();
    }

    static void kiemTraTonTaiThuMuc() {
        path = "d:/session05/batch";
        myFile = new File(path);
        if (myFile.exists()) {
            System.out.println("Thu muc " + path + " da ton tai");
        } else {
            System.out.println("Thu muc " + path + " chua ton tai");
        }
    }

    static void taoFile() throws IOException {
        path = "d:/session05/batch/test.txt";
        myFile = new File(path);
        myFile.createNewFile();
    }

    static void kiemTraSuTonTaiFile() {
        path = "d:/session05/batch/test.txt";
        myFile = new File(path);
        if (myFile.exists()) {
            System.out.println("File " + path + " da ton tai");
        } else {
            System.out.println("File " + path + " chua ton tai");
        }
    }

    static void kiemTraFileVaThuMuc() {
        path = "d:/session05/batch/test.txt";
        myFile = new File(path);
        if (myFile.isFile()) {
            System.out.println(path + " la file");
        }
        path = "d:/session05/batch/";
        myFile = new File(path);
        if (myFile.isDirectory()) {
            System.out.println(path + " la thu muc");
        }
    }

    static void layDuongDanTuongDoiVaTuyetDoi() {
        path = "test.txt";
        myFile = new File(path);
        System.out.println("Duong dan tuong doi: " + myFile.getPath());
        System.out.println("Duong dan tuyet doi: " + myFile.getAbsolutePath());
    }

    static void layTenFile() {
        path = "d:/session05/batch/test.txt";
        myFile = new File(path);
        System.out.println("Duong dan den file: " + myFile.getParent());
        System.out.println("Ten file: " + myFile.getName());
    }

    static void doiTenFile() {
        path = "d:/session05/batch/test.txt";
        myFile = new File(path);
        File newFile = null;
        path = "d:/session05/batch/test1.txt";
        newFile = new File(path);
        myFile.renameTo(newFile);
    }

    static void xoaFile() {
        path = "d:/session05/batch/test1.txt";
        myFile = new File(path);
        myFile.delete();
    }

    static void fileListNoneExtension() {
        // hiển thị tất cả các file trong 1 thư mục 
        path = "d:/session05/";
        myFile = new File(path);
        String[] listFile = myFile.list();
        for (String i : listFile) {
            myFile = new File(path, i);
            if (myFile.isFile()) {
                System.out.println(myFile.getName());
            }
        }
    }

    static void fileListWithExtention(String ext) {
        // hiển thị tất cả các file trong 1 thư mục với phần mở rộng cho trước
        path = "d:/session05/";
        myFile = new File(path);
        String[] listFile = myFile.list();
        for (String i : listFile) {
            if (i.endsWith(ext)) {
                myFile = new File(path, i);
                if (myFile.isFile()) {
                    System.out.println(myFile.getName());
                }
            }
        }
    }

    static void dirList() {
        // hiển thị tất cả các thư mục con trong 1 thư mục 
        path = "d:/session05/";
        myFile = new File(path);
        String[] listFile = myFile.list();
        for (String i : listFile) {
            myFile = new File(path, i);
            if (myFile.isDirectory()) {
                System.out.println(myFile.getName());
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        taoThuMuc();
//        kiemTraTonTaiThuMuc();
//        taoFile();
//        kiemTraSuTonTaiFile();
//        kiemTraFileVaThuMuc();
//        layDuongDanTuongDoiVaTuyetDoi();
//        layTenFile();
//        doiTenFile();
//        xoaFile();
//        fileListNoneExtension();
//        fileListWithExtention(".txt");
        dirList();

    }
}

//File(String dirpath): tạo một đối tượng File mới bởi việc biến đổi chuỗi dirpath
//đã cho thành một pathname trừu tượng
//File(String parent, String child): tạo một đối tượng File mới từ một chuỗi pathname cha và một chuỗi pathname con.
//File(File fileobj, String filename): tạo một đối tượng File mới từ một pathname trừu tượng cha và một chuỗi pathname con
//File(URL urlobj): tạo một đối tượng File mới bởi việc biến đổi URL đã cho thành một pathname trừu tượng
