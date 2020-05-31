package com.glushkov;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;


public class FileManager extends SimpleFileVisitor<Path> {
    private static int firstCount;
    private static int secondCount;

    /*- приймає шлях до папки,
        повертає кількість файлів в папці і всіх підпапках по шляху*/
    public static int countFiles (String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                firstCount++;
                if (files[i].isDirectory()) {
                    countFiles(files[i].getPath());
                }
            }
        }
        else throw new IOException("Incorrect path. Please chose correct path to directory and try again");
        return firstCount;
    }

/*- приймає шлях до папки,
    повертає кількість папок в папці і всіх підпапках по цьому шляху*/
    public static int countDirs (String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()){
                    secondCount++;
                    countDirs(files[i].getPath());
                }
            }
        }
         else throw new IOException("Incorrect path. Please chose correct path to directory and try again");
         return secondCount;
    }


/*- метод по копіюванню папок і файлів.
        Параметр from - шлях до файлу або папки, параметр to - шлях до папки куди буде проводитися копіювання.*/
    public static void copy (String from, String to) throws IOException {

        if (new File(from).exists() && new File(to).isDirectory()){
            Files.copy(Paths.get(from), Paths.get(to + from.substring(from.lastIndexOf("\\"))), StandardCopyOption.REPLACE_EXISTING);
        }
        else throw new IOException("Incorrect path in from or to. Please chose correct path to directory and try again");
    }


    /*- метод по переміщенню папок і файлів.
Параметр from - шлях до файлу або папки, параметр to - шлях до папки куди буде проводитися копіювання.*/
    public static void move (String from, String to) throws IOException {
        if (new File(from).exists() && new File(to).isDirectory()){
            Files.move(Paths.get(from), Paths.get(to + from.substring(from.lastIndexOf("\\"))), StandardCopyOption.REPLACE_EXISTING);
        }
        else throw new IOException("Incorrect path in from or to. Please chose correct path to directory and try again");
    }
}

