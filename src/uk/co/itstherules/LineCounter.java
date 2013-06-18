package uk.co.itstherules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class LineCounter {

    private static final int MAXIMUM_LINE_SIZE = 120;
    private final String[] paths;

    public static void main(String[] args) {
        if(args.length < 1) {
            throw new IllegalArgumentException("Expected: uk.co.itstherules.LineCounter <root_dir>");
        }
        System.out.println("Lines of code:" + new LineCounter(args).count());
    }

    public LineCounter(String... paths) {
        this.paths = paths;
    }


    public int count() {
        int count = 0;
        for (String path : paths) {
            File file = new File(path);
            count += countLinesIn(file);
        }
        return count;
    }

    private int countLinesIn(File file) {
        if(file.isDirectory()) {
            return countLinesInDirectory(file);
        } else {
            return countLinesInFile(file);
        }
    }

    private int countLinesInDirectory(File directory) {
        System.out.println("Counting lines of code in directory:"+directory.getAbsolutePath());
        File[] files = directory.listFiles(new ExclusionFilter());
        int count = 0;
        for (File file : files) {
            count += countLinesIn(file);
        }
        return count;
    }

    private int countLinesInFile(File file) {
        int count = 0;
        try {
            String absolutePath = file.getAbsolutePath();
            if(!file.exists()) {
                throw new IllegalArgumentException("File \""+ absolutePath +"\"supplied as a parameter does not exist");
            }
            System.out.println("Counting lines of code in file:"+ absolutePath);

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                count++;
                int length = line.length();
                if(length > MAXIMUM_LINE_SIZE){
                    count += length - MAXIMUM_LINE_SIZE;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
