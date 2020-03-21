/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author June
 */
public class Unzip {

    public static final String ZIP_FILE = new File("").getAbsolutePath() + "/ZipAndUnzip/zip/demo.zip";
    public static final String OUTPUT_FOLDER = new File("").getAbsolutePath() + "/ZipAndUnzip/unzip";
    public static final byte[] BUFFER = new byte[1024];

    public static void ReadZipFileExample() {
	ZipInputStream zis = null;
	try {
	    // Tạo đối tượng ZipInputStream để đọc file zip.
	    zis = new ZipInputStream(new FileInputStream(ZIP_FILE));

	    ZipEntry entry = null;
	    while ((entry = zis.getNextEntry()) != null) {
		if (entry.isDirectory()) {
		    System.out.print("Directory: ");
		} else {
		    System.out.print("File: ");
		}
		System.out.println(entry.getName());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		zis.close();
	    } catch (Exception e) {
	    }
	}
    }

    public static void UnZipFile() {
	// Tạo thư mục Output nếu không tồn tại
	File folder = new File(OUTPUT_FOLDER);
	if (!folder.exists()) {
	    folder.mkdirs();
	}

	ZipInputStream zis = null;
	try {
	    zis = new ZipInputStream(new FileInputStream(ZIP_FILE));

	    ZipEntry entry;
	    File file;
	    OutputStream os;
	    String entryName;
	    String outFileName;
	    while ((entry = zis.getNextEntry()) != null) {
		entryName = entry.getName();
		outFileName = OUTPUT_FOLDER + File.separator + entryName;
		System.out.println("Unzip: " + outFileName);

		file = new File(outFileName);
		if (entry.isDirectory()) {
		    // Tạo các thư mục.
		    file.mkdirs();
		} else {
		    // Tạo các thư mục nếu không tồn tại
		    if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		    }
		    // Tạo một Stream để ghi dữ liệu vào file.
		    os = new FileOutputStream(outFileName);
		    int len;
		    while ((len = zis.read(BUFFER)) > 0) {
			os.write(BUFFER, 0, len);
		    }
		    os.close();
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		zis.close();
	    } catch (Exception e) {
	    }
	}
    }

    public static void main(String[] args) {
	ReadZipFileExample();
	UnZipFile();
    }
}
