package dev.cypher;

interface Cypher {
    String encode(String plainText);
    String decode(String cipherText);
}
