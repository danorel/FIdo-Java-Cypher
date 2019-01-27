package dev.cypher;

import java.io.*;

final public class Caesar implements Cypher {

    private int key;

    public Caesar(){
        // Default Caesar cypher key
        this.key = 1;
    }

    public Caesar(int key){
        this.key = key;
    }

    @Override
    public String encode(String plainText) {
        return encodeText(plainText, key);
    }

    @Override
    public String decode(String cipherText) {
        return encodeText(cipherText, -key);
    }

    private String encodeText(String text, int step){
        char[] line_characters = text.toCharArray();
        int index = 0;
        for(char ch : line_characters){
            if((int)ch >= ASCII.getMINValue() && (int)ch <= ASCII.getMAXValue()){
                line_characters[index++] = encodeCharacter(ch, step);
            } else {
                line_characters[index++] = ch;
            }
        }
        text = "";
        for(char ch : line_characters){
            text += ch;
        }
        return text;
    }

    private char encodeCharacter(char character, int step){
        if(step > 0){
            return ((int)character >= ASCII.getMAXValue() - step) ? (char)((int)character - ((ASCII.getMAXValue() - ASCII.getMINValue()) - step)) : (char)((int)character + step);
        } else {
            return ((int)character <= ASCII.getMINValue() - step) ? (char)((int)character + ((ASCII.getMAXValue() - ASCII.getMINValue()) + step)) : (char)((int)character + step);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(key);
    }
}
