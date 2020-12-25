package Lesson_4;

import java.io.*;

public class WritebleFile {
    File file;
    DataOutputStream dataOutputStream;


    public WritebleFile() {
        file = new File("text.txt");
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeToFIle(String s) {
        try {
            dataOutputStream.writeUTF(s);
            dataOutputStream.writeUTF(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
