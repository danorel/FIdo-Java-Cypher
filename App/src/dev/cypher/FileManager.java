package dev.cypher;

interface FileManager {
    String readFile(String path);
    boolean writeFile(String path, String body);
    void createFile(String filename);
    void createDirectory(String src);
}
