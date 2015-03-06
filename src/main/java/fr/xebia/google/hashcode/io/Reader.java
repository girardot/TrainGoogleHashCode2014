package fr.xebia.google.hashcode.io;

import fr.xebia.google.hashcode.structure.Grid;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class Reader {

    public Grid readFile(URL url) {
        Grid grid = null;

        try (FileInputStream input = new FileInputStream(url.getFile())) {
            BufferedInputStream bufferedInput = new BufferedInputStream(input);

            int data = bufferedInput.read();
            boolean firstLine = true;
            Integer lineNumber = null;
            Integer columnNumber = null;
            int i = 0;

            while (data != -1) {
                String readCharacter = "" + (char) data;

                // First Line
                if (firstLine) {
                    if (System.lineSeparator().compareToIgnoreCase(readCharacter) == 0) {
                        firstLine = false;
                    }
                    else {
                        if (!readCharacter.equalsIgnoreCase(" ")) {
                            if (lineNumber == null) {
                                lineNumber = Integer.valueOf(readCharacter);
                            }
                            else {
                                columnNumber = Integer.valueOf(readCharacter);
                                grid = new Grid(lineNumber, columnNumber);
                            }
                        }
                    }
                }
                else {
                    if (!readCharacter.equalsIgnoreCase(" ") && !readCharacter.equalsIgnoreCase(System.lineSeparator())) {
                        grid.addCell(i, readCharacter);

                        i++;
                    }
                }

                data = bufferedInput.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return grid;
    }

}
