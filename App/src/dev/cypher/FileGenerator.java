package dev.cypher;

import java.io.*;

final public class FileGenerator implements FileManager {

    // Directory src and object
    private File directory;
    private String directorySrc;

    // Input/output files names and objects
    private File file;
    private String filename;
    private BufferedWriter writer;
    private BufferedReader reader;

    @Override
    public String readFile(String path) {
        String outputText = "";
        try{
            reader = (!directorySrc.equals("") ? new BufferedReader(new FileReader(directorySrc + "/" + path)) : new BufferedReader(new FileReader(path)));
            String text;
            while((text = reader.readLine()) != null){
                outputText += text + "\n";
            }
            reader.close();
        } catch(IOException exception){
            exception.printStackTrace();
        }
        return outputText;
    }

    @Override
    public boolean writeFile(String path, String body) {
        try {
            writer = (!directorySrc.equals("") ? new BufferedWriter(new FileWriter(directorySrc + "/" + path)) : new BufferedWriter(new FileWriter(path)));
            writer.write(body);
            writer.close();
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public void createFile(String filename) {
        this.filename = filename;
        file = (!directorySrc.equals("")) ? new File(directorySrc + "/" + this.filename) : new File(this.filename);
        try {
            file.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void createDirectory(String src) {
        directorySrc = src;
        directory = new File(directorySrc);
        directory.mkdir();
    }

    public String getFilename() {
        return filename;
    }

    public String getDirectorySrc(){
        return directorySrc;
    }

    public BufferedReader getReader(){
        return reader;
    }

    public BufferedWriter getWriter(){
        return writer;
    }
}
