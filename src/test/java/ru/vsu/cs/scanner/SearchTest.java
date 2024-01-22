package ru.vsu.cs.scanner;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class SearchTest {
    @Test
    public void testFiles(){
        FileReturn fileReturn = new FileReturn("File","C://new");
        Assert.assertNotNull(fileReturn);
    }
}