package util;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileRead {
    public static void readFile(String filename) {
     try {
        FileReader fileRead = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileRead);
        System.out.println(bufferedReader.readLine());
         bufferedReader.close();

    } catch (Exception ex)

    {
        ex.printStackTrace();

    }
    }
}
