package dev.cypher;

interface App {
    static void main(String[] args) {
        FileGenerator generator = new FileGenerator();
        generator.createDirectory("data");
        generator.createFile("input.txt");
        generator.createFile("output.txt");
        generator.writeFile("input.txt", "Hello, world!");
        Caesar caesar = new Caesar();
        generator.writeFile("output.txt", caesar.encode(generator.readFile("input.txt")));
        generator.createFile("decoded.txt");
        generator.writeFile("decoded.txt", caesar.decode(generator.readFile("output.txt")));
    }
}
