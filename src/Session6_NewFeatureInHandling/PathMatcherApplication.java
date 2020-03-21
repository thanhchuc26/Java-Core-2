/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author June
 */
class Finder extends SimpleFileVisitor<Path> {

    private Path file;
    private PathMatcher matcher;
    private int num;

    public Finder(Path path, PathMatcher matcher) {
        file = path;
        this.matcher = matcher;
    }

    private void find(Path file) {
        Path name = file.getFileName();
        if (name != null && matcher.matches(name)) {
            num++;
            System.out.println(file);
        }
    }

    void done() {
        System.out.println("Matched: " + num);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        find(file);
        return CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        find(dir);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }
}

public class PathMatcherApplication {

    public static void main(String[] args) {
        Path pathObj;
        pathObj = Paths.get("D:/session06");
        PathMatcher matcherObj = FileSystems.getDefault().getPathMatcher("glob:" + "*.txt");
        Finder finder = new Finder(pathObj, matcherObj);
        try {
            Files.walkFileTree(pathObj, finder);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
