package com.step.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author sscerbatiuc
 */
public class NioRead {

    public static void main(String[] args) throws IOException  {
      readAllLines();
    }
    
    
    static void readAllLines() throws IOException {
        List<String> fileLines = Files.readAllLines(Paths.get("C:\\Users\\sscerbatiuc.INTHER\\Desktop\\Step.txt"));
        for(String line: fileLines){
            System.out.println(line);
            String[] arr = line.split(",");
            // new Employee(arr[0], ....)
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);
            System.out.println(arr[3]);
            break;
        }
        
    }
    
    static void readAllBytes() throws IOException{
        // byte[] b = Files.readAllBytes(Paths.get("test"));
        // Files.readAllBytes(Paths.get(stringPath))
    }
    
}
