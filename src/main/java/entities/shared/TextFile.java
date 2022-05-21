package entities.shared;

import enums.Separator;

import java.io.*;
import java.util.ArrayList;

public class TextFile {

    public void append(File file, String[] array) throws java.io.IOException {
        String strFinal = String.join(Separator.Underscore.toString(), array);

        BufferedWriter wr = new BufferedWriter(new FileWriter(file, true));
        wr.write(strFinal);
        wr.newLine();
        wr.close();
    }

    public void write(File file, ArrayList<String[]> arrayList) throws java.io.IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(file, false));
        wr.write("");
        wr.close();
        for (String[] i : arrayList) {
            this.append(file, i);
        }
    }

    public ArrayList<String[]> readAll(File file) throws java.io.IOException {
        ArrayList<String[]> finalList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] separatedLine = line.split(Separator.Underscore.toString());
            finalList.add(separatedLine);
        }
        br.close();
        return finalList;
    }
}
