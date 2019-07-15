package ca.jrvs.apps.grep;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaGrepImp implements JavaGrep {

    private String rootPath;
    private String regex;
    private String outFile;


    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("USAGE: regex rootpath outfile");
        }
        JavaGrepImp javaGrepImp = new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);

        try {
            javaGrepImp.process();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void process() throws IOException {

        List<File> files = listFiles(this.getRootPath());
        ArrayList<String> matchedLines = new ArrayList<>();
        List<String> linesFromFiles;
        for (File file : files) {
            linesFromFiles = readLines(file);

            for (String line : linesFromFiles) {
                if (containsPattern(line)) {
                    matchedLines.add(line);
                }
            }
        }
        writeToFile(matchedLines);
    }

    @Override
    public List<File> listFiles(String rootDir) {
        File folder = new File(rootDir);
        File[] listOfFiles = folder.listFiles();
        List<File> results = new ArrayList<>();

        if (listOfFiles == null) {
            results.add(folder);
            return results;
        }
        for (File fileE : listOfFiles) {
            if (fileE.isFile()) {
                results.add(fileE);
            } else if (fileE.isDirectory()) {
                results.addAll(listFiles((fileE.getAbsolutePath())));
            }
        }
        return results;

    }

    @Override
    public List<String> readLines(File inputFile) throws IOException {

        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            br.close();
            return lines;
        }
    }

    @Override
    public boolean containsPattern(String line) {

        return line.matches(this.getRegex());
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(this.getOutFile()));
        for (String line : lines) {
            writer.write(line);
        }
        writer.close();

    }

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String getOutFile() {
        return outFile;
    }

    @Override
    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }


}
