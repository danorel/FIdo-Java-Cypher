package dev.cypher;

import java.io.BufferedReader;

interface App {
    static void main(String[] args) {
        FileGenerator generator = new FileGenerator();
        generator.createDirectory("data");
        generator.createFile("input.txt", true);
        generator.createFile("output.txt", false);
        generator.writeFile("input.txt", "Hello, world!");
        Caesar caesar = new Caesar();
        caesar.setReader(generator.readFile("input.txt"));
        caesar.setFilename("input.txt");
        caesar.encode();
    }
}
