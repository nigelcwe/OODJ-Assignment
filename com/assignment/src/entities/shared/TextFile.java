package com.assignment.src.entities.shared;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFile {

    public int append(File file, String[] array) throws java.io.IOException {
        String strFinal = String.join(Separator.Comma.toString(), array);

        BufferedWriter wr = new BufferedWriter(new FileWriter(file, true));
        wr.write(strFinal);
        wr.newLine();
        wr.close();

        return 1;
    }

    public int write(String path, String[] array) throws java.io.IOException {
        File file = new File(path);
        String strFinal = String.join(Separator.Comma.toString(), array);

        BufferedWriter wr = new BufferedWriter(new FileWriter(file, false));
        wr.write(strFinal);
        wr.close();
        return 1;
    }

    public ArrayList<String[]> readAll(File file) throws java.io.IOException {
        ArrayList<String[]> finalList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] separatedLine = line.split(Separator.Comma.toString());
            finalList.add(separatedLine);
        }
        br.close();
        return finalList;
    }
}
