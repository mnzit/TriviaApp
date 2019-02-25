/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.triviaapp.web.dao.impl;

import com.mnzit.triviaapp.web.dao.UserDAO;
import com.mnzit.triviaapp.web.entity.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class UserDAOFileImpl implements UserDAO {

    @Override
    public int login(String userName, String password) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("d:/user.txt"));
        List<User> users = new ArrayList<>();
        String line = "";
        int i = 0;
        while ((line = reader.readLine()) != null) {
            if (i > 0) {
                String[] tokens = line.split(",");
                if (tokens.length == 4) {
                    if (tokens[1].equalsIgnoreCase(userName) && tokens[2].equalsIgnoreCase(password)) {
                        return Integer.valueOf(tokens[0]);
                    }
                }
            }
            i++;
        }
        return -1;
    }

    @Override
    public boolean register(String userName, String password) throws Exception {
        int count = 1;
        File file = new File("d:/user.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        if (file.length() == 0) {
            writer.write(count + "\n");
        } else {
            count = Integer.parseInt(new BufferedReader(new FileReader(file)).readLine()) + 1;
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.seek(0);
            raf.write(String.valueOf(count).getBytes());
        }
        writer.append(new User(count, userName, password, 0).toString() + "\n");
        writer.close();
        return true;
    }

    @Override
    public boolean updateScore(int score, int id) throws Exception {
        List<User> users = new ArrayList<>();
        String line = "";
        int i = 0;
        long oldPosition = 0;
        RandomAccessFile raf = new RandomAccessFile("d:/user.txt", "rw");
        while ((line = raf.readLine()) != null) {
            long position = raf.getFilePointer();
            String tokens[] = line.split(",");
            if (i > 0) {
                if (Integer.parseInt(tokens[0]) == id) {
                    if (score > Integer.parseInt(tokens[3])) {
                        tokens[3] = String.valueOf(score);
                        raf.seek(oldPosition);
                        raf.write(String.join(",", tokens).getBytes());
                    }
                }
            }
            oldPosition = position;
            i++;
        }
        return true;
    }

}
