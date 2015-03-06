package fr.xebia.google.hashcode.io;

import fr.xebia.google.hashcode.instruction.Instruction;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Writer {

    public void writeInstructions(List<Instruction> instructions) {
        try {
            PrintWriter printWriter = new PrintWriter("testFile.txt", "UTF-8");

            printWriter.println(instructions.size());

            for (Instruction instruction : instructions) {
                printWriter.println(instruction);
            }

            printWriter.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
