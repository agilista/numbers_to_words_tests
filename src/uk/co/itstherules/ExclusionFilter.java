package uk.co.itstherules;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExclusionFilter implements FileFilter {

    private final List<String> excludedFiles;
    private final List<String> excludedExtensions;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    public ExclusionFilter() {
        this.excludedExtensions = readFile("excluded_extensions.txt");
        this.excludedFiles = readFile("excluded_files.txt");
    }

    private List<String> readFile(String fileName) {
        try {
            List<String> values = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ExclusionFilter.class.getClassLoader().
                    getResourceAsStream(fileName)));
            String line;
            while ((line = reader.readLine())!=null) {
                values.add(line);
            }
            return values;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean accept(final File pathName) {
        String name = pathName.getName().toLowerCase();
        String extension = getExtension(name);
        return !excludedFiles.contains(name) && !excludedExtensions.contains(extension);

    }

    private String getExtension(String filename) {
        int index = indexOfExtension(filename);
        if (index == -1) {
            return "";
        } else {
            return filename.substring(index + 1);
        }
    }

    private int indexOfExtension(String filename) {
        int extensionPos = filename.lastIndexOf('.');
        int lastSeparator = indexOfLastSeparator(filename);
        return (lastSeparator > extensionPos ? -1 : extensionPos);
    }

    private int indexOfLastSeparator(String filename) {
        int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        return Math.max(lastUnixPos, lastWindowsPos);
    }
}
