package com.excepiton;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class TryWithResourceExample1 {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("readTestFile.txt");
             PrintWriter writer = new PrintWriter(new File("writeTestFile.txt"))) {
            writer.println("Hello World");
            int i;
            while((i=fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
