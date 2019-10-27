package com.driveanalytics.demo.ResourceLoader;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class DataReader {

    private Boolean initialized = false;

    public DataReader(){}

    public DataReader(String fileName) throws IOException {
        presentFile = fileName;
        fileReader = new BufferedReader(new FileReader(presentFile));
        initialized = true;
    }

    private String presentFile;

    private BufferedReader fileReader;

    public void changeDataSource(String newFile) throws IOException {
        // close present file readers
        if(initialized)fileReader.close();
        // assign the new file to the reader
        presentFile = newFile;
        System.out.println("here");
        fileReader = new BufferedReader(new FileReader(presentFile));
        initialized = true;
    }

    /**
     * returns null on EOF
     *
     * @return
     * @throws IOException
     */
    public String readData() throws IOException {
        String data = fileReader.readLine();
        System.out.println(data);
        return data;
    }

}
