package org.example;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome! \n");
        Search t = new Search("meta","C:\\addqd");
        List<FileReturn> files = t.search();
        for (FileReturn f : files){
            f.print();
        }
    }
}