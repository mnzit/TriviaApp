/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.triviaapp.web.filehelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Mnzit
 */
public class FileManipulater {
    
    private File file;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    
    public FileManipulater() {
    }
    
    public FileManipulater(String fileName) {
        file = new File(fileName);
    }
    
    public BufferedReader reader() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(file));
        return bufferedReader;
    }
    
    public String hasNextLine() throws FileNotFoundException, IOException {
        String line = reader().readLine();
        return line != null ? line : null;
    }
    
    public long fileLength() {
        return file.length();
    }
    
    public FileWriter writer(boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
        return fileWriter;
    }
    
    public void write(String text, boolean append) throws IOException {
        writer(append).write(text);
    }
    
}
