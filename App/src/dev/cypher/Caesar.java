package dev.cypher;

import java.io.*;

final public class Caesar implements Cypher {

    private int key;
    private BufferedWriter writer;
    private BufferedReader reader;
    private String dirname = "", filename;

    public Caesar(){
        // Default Caesar cypher key
        this.key = 1;
    }

    public Caesar(int key){
        this.key = key;
    }

    @Override
    public String encode(String plainText) {
        try {
            String line;
            if(!dirname.equals("")){
                reader = new BufferedReader(new FileReader(dirname + "/" + filename));
                writer = new BufferedWriter(new FileWriter(dirname + "/" + FileGenerator.getOutputFilename()));
            } else {
                reader = new BufferedReader(new FileReader(FileGenerator.getInputFilename()));
                writer = new BufferedWriter(new FileWriter(FileGenerator.getOutputFilename()));
            }
            while((line = reader.readLine()) != null){
                line = encodeLine(line, key);
                writer.write(line + "\n");
            }
            writer.close();
            reader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return "";
    }

    @Override
    public String decode(String cipherText) {
        try {
            if(!FileGenerator.getDirectorySrc().equals("")){
                reader = new BufferedReader(new FileReader(FileGenerator.getDirectorySrc() + "/" + FileGenerator.getOutputFilename()));
            } else {
                reader = new BufferedReader(new FileReader(FileGenerator.getOutputFilename()));
            }
            String text = "", line;
            while((line = reader.readLine()) != null){
                text += line.toString();
            }
            if(!FileGenerator.getDirectorySrc().equals("")){
                writer = new BufferedWriter(new FileWriter(FileGenerator.getDirectorySrc() + "/" + FileGenerator.getOutputFilename()));
            } else {
                writer = new BufferedWriter(new FileWriter(FileGenerator.getOutputFilename()));
            }
            text = encodeLine(text, -this.key);
            writer.write(text);
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String encodeLine(String line, int step){
        char[] line_characters = line.toCharArray();
        int index = 0;
        for(char ch : line_characters){
            if((int)ch >= ASCII.getMINValue() && (int)ch <= ASCII.getMAXValue()){
                line_characters[index++] = encodeSymbol(ch);
            } else {
                line_characters[index++] = ch;
            }
        }
        line = "";
        for(char ch : line_characters){
            line += ch;
        }
        return line;
    }

    private char encodeSymbol(char character){
        if(this.key > 0){
            return ((int)character >= ASCII.getMAXValue() - this.key) ? (char)((int)character - ((ASCII.getMAXValue() - ASCII.getMINValue()) - this.key)) : (char)((int)character + this.key);
        } else {
            return ((int)character <= ASCII.getMINValue() - this.key) ? (char)((int)character + ((ASCII.getMAXValue() - ASCII.getMINValue()) + this.key)) : (char)((int)character + this.key);
        }
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
