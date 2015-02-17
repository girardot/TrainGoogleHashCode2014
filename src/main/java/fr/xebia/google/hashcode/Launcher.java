package fr.xebia.google.hashcode;

import com.google.common.base.Throwables;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Launcher {

    public void readFile() {
        try (FileInputStream input = (FileInputStream) getClass().getResourceAsStream("basicExample.txt")) {
            BufferedInputStream bufferedInput = new BufferedInputStream(input);


            int data = bufferedInput.read();
            while (data != -1) {
                System.out.println((char) data);
                data = bufferedInput.read();
            }
        }
        catch (IOException e) {
            Throwables.propagate(e);
        }
    }


}
