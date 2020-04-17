/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.step.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import static com.step.nio.NioWrite.filesWriteText;

/**
 *
 * @author sscerbatiuc
 */
public class NioWrite {
    
    static List<String> contents = Arrays.asList("Employee1", "Employee2");

    public static void main(String[] args) {
        fileWriteBytes();
        filesWriteText();
        bufferedWrite();

    }

    private static void fileWriteBytes() {
        try {
            byte[] hello = {100, 23, 127, 15};
            Files.write(Paths.get("C:\\Users\\sscerbatiuc.INTHER\\Desktop\\Step.txt"), hello);
        } catch (IOException ex) {
            Logger.getLogger(NioWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void filesWriteText() {
        try {
//            List<String> contents = Arrays.asList("Employee1", "Employee2");
            Files.write(Paths.get("C:\\Users\\sscerbatiuc.INTHER\\Desktop\\Step.txt"), 
                    contents,
                    StandardCharsets.UTF_8);
                   
        } catch (IOException ex) {
            Logger.getLogger(NioWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void filesWriteTextAndCreateIfNotExists() {
        try {
//            List<String> contents = Arrays.asList("Employee1", "Employee2");

            Files.write(Paths.get("C:\\Users\\sscerbatiuc.INTHER\\Desktop\\Step.txt"), contents,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE); // <-- HERE
        } catch (IOException ex) {
            Logger.getLogger(NioWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void bufferedWrite() {
        Path path = Paths.get("C:\\Users\\sscerbatiuc.INTHER\\Desktop\\Step.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
            writer.write("To be, or not to be. That is the question.");
        } catch (IOException ex) {
            System.out.println("Eroare: " + ex.getMessage());
        }
    }

}
