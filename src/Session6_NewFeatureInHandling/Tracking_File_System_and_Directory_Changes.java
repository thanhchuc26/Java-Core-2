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
import java.nio.file.StandardCopyOption;

/**
 *
 * @author June
 */
public class Tracking_File_System_and_Directory_Changes {

    public static void main(String[] args) throws IOException {
        Path source = Paths.get("D:/session06/session06.txt");
        Path destination = Paths.get("D:/session06/session06_1.txt");

        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}


/*
Copying a file or directory:
copy(Path, Path, CopyOption...)
Files.copy(source, target, REPLACE_EXISTING);

Moving a file or directory:
move(Path, Path, CopyOption...)
Files.move(source, target, REPLACE_EXISTING);
If the target file exists, the REPLACE_EXISTING option should
be used. Otherwise, the move fails.

Checking a file or directory:
exists(Path, LinkOption...opt): These check if the file exists. By default, it uses symbolic links.
notExists(Path, LinkOption...): These check if the file does not exist.
Files.exists(path) is not equivalent to Files.notExists(path).
When testing a file’s existence, one of the following is the possible outcome:
 The file is verified to not exist.
 The file is verified to exist.
 The existence of the file cannot be verified.
 The file’s status is unknown.

Deleting a file or directory:
delete(Path)

Listing a Directory’s Content:
DirectoryStream<Path> dirStreamObj = Files.newDirectoryStream(path Obj, “*.java”)

Creating and Reading Directories:
createDirectory(Path dir)
Files.createDirectories(Paths.get(“C:/Java/test/example”));

Reading and Writing from Files;
To read from files, use the readAllBytes or ReadAllLines methods that will read the entire content of the file

Reading a File by Using Buffered Stream I/O:
 The newBufferedReader(Path, Charset) method opens a file for reading.
 This returns a BufferedReader object that helps to read text from a file efficiently.

Accessing a File Randomly:
 Files can be nonsequentially or randomly accessed using the SeekableByteChannel interface.
 To randomly access a file, perform the following:
 Open the file.
 Find the particular location.
 Read from the file or write to the file.

The interface includes the following methods:
 read(ByteBuffer)
 write(ByteBuffer)
 truncate(long)
 position
 position(long)


 */
