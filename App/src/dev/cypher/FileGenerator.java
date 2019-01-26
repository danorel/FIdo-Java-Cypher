package dev.cypher;

import java.io.*;

final public class FileGenerator implements FileManager {

    // Directory src and object
    private static File directory;
    private static String directorySrc;

    // Input/output files names and objects
    private static File inputFile, outputFile;
    private static String inputFilename, outputFilename;
    private static BufferedWriter writer;
    private static BufferedReader reader;

    @Override
    public BufferedReader readFile(String path) {
        try{
            reader = (!directorySrc.equals("") ? new BufferedReader(new FileReader(directorySrc + "/" + inputFilename)) : new BufferedReader(new FileReader(inputFilename)));
            reader.close();
        } catch(IOException exception){
            exception.printStackTrace();
        }
        return reader;
    }

    @Override
    public boolean writeFile(String path, String body) {
        try {
            writer = (!directorySrc.equals("") ? new BufferedWriter(new FileWriter(directorySrc + "/" + inputFilename)) : new BufferedWriter(new FileWriter(inputFilename)));
            writer.write(body);
            writer.close();
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public void createFile(String filename, boolean state) {
        if(state){
            inputFilename = filename;
            inputFile = (!directorySrc.equals("")) ? new File(directorySrc + "/" + inputFilename) : new File(inputFilename);
            try {
                inputFile.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            outputFilename = filename;
            outputFile = (!directorySrc.equals("")) ? new File(directorySrc + "/" + inputFilename) : new File(inputFilename);
            try {
                outputFile.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void createDirectory(String src) {
        directorySrc = src;
        directory = new File(directorySrc);
        directory.mkdir();
    }

    public static String getInputFilename(){
        return inputFilename;
    }

    public static String getOutputFilename(){
        return inputFilename;
    }

    public static String getDirectorySrc(){
        return directorySrc;
    }

    public static BufferedReader getReader(){
        return reader;
    }

    public static BufferedWriter getWriter(){
        return writer;
    }
}
