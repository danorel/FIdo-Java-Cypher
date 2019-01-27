package dev.cypher;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.Arrays;
import java.util.List;

public class CaesarTest {

    private static List<List<String>> testEncodeCases;
    private static List<List<String>> testDecodeCases;
    private Caesar caesar;

    @Before
    public void before(){
        caesar = new Caesar();
    }

    @BeforeClass
    public static void beforeClass(){
        testEncodeCases = Arrays.asList(
                Arrays.asList("Ifmmp-!xpsme\"", "Hello, world!"),
                Arrays.asList("bcd", "abc")
        );
        testDecodeCases = Arrays.asList(
                Arrays.asList("Hello, world!", "Ifmmp-!xpsme\""),
                Arrays.asList("abc", "bcd")
        );
    }

    @org.junit.Test
    public void encode() {
        for(int index = 0; index < testEncodeCases.size(); index++){
            Assert.assertEquals(testEncodeCases.get(index).get(0), caesar.encode(testEncodeCases.get(index).get(1)));
        }
    }

    @org.junit.Test
    public void decode() {
        for(int index = 0; index < testEncodeCases.size(); index++){
            Assert.assertEquals(testDecodeCases.get(index).get(0), caesar.decode(testDecodeCases.get(index).get(1)));
        }
    }
}
