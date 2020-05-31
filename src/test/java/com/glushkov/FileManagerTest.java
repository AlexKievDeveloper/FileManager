package com.glushkov;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileManagerTest {
    String path;
    String from;
    String to;

    @Before
    public void setUp() throws Exception {
        path = "C:\\Users\\DzeN-BooK\\IdeaProjects\\FileManager\\src" ;
        from = "C:\\Users\\DzeN-BooK\\IdeaProjects\\FileManager\\testFile1.txt";
        to = "C:\\Users\\DzeN-BooK\\IdeaProjects\\FileManager\\testFolder1";
    }

    @Test
    public void countFiles() throws IOException {
        int expected = 12;
        int actual = FileManager.countFiles(path);
        assertEquals(expected, actual);
    }

    @Test
    public void countDirs() throws IOException {
        int expected = 9;
        int actual = FileManager.countDirs(path);
        assertEquals(expected, actual);
    }

    @Test
    public void copy() throws IOException {
        FileManager.copy(from,to);
        assertTrue(new File("C:\\Users\\DzeN-BooK\\IdeaProjects\\FileManager\\testFolder1\\testFile1.txt").exists());
        Files.delete(Paths.get("C:\\Users\\DzeN-BooK\\IdeaProjects\\FileManager\\testFile1.txt"));
    }

    @Test
    public void move() throws IOException {
        FileManager.move("C:\\Users\\DzeN-BooK\\IdeaProjects\\FileManager\\testFolder1\\testFile1.txt",
                         "C:\\Users\\DzeN-BooK\\IdeaProjects\\FileManager");
        assertTrue(new File("C:\\Users\\DzeN-BooK\\IdeaProjects\\FileManager\\testFile1.txt").exists());
    }
}