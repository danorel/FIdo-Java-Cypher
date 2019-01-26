package dev.cypher;

import java.io.BufferedReader;

interface FileManager {
    BufferedReader readFile(String path);
    boolean writeFile(String path, String body);
    void createFile(String filename, boolean state);
    void createDirectory(String src);
}
