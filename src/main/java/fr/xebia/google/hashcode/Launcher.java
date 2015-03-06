package fr.xebia.google.hashcode;

import com.google.common.io.Resources;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class Launcher {

    public void readFile() {
//        InputStream resourceAsStream = getClass().getResourceAsStream("basicExample.txt");

        URL resource = Resources.getResource("basicExample.txt");

        try (FileInputStream input = new FileInputStream(resource.getFile())) {
            BufferedInputStream bufferedInput = new BufferedInputStream(input);

            int data = bufferedInput.read();
            while (data != -1) {
                System.out.println((char) data);
                data = bufferedInput.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
