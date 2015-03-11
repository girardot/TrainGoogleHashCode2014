package fr.xebia.google.hashcode.utils;

import fr.xebia.google.hashcode.structure.Grid;
import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class FileUtils {

    public static Grid readFileInGrid(String filePath, String fileName) {
        Grid grid;
        Path path = FileSystems.getDefault().getPath(filePath, fileName);

        Pair<Integer, Integer> firstLine = readFirstLine(path);
        grid = new Grid(firstLine.getKey(), firstLine.getValue());

        List<String> lines = readOtherLines(path);
        computeGrid(grid, lines);

        return grid;
    }

    private static Pair<Integer, Integer> readFirstLine(Path path) {
        try (Stream<String> fileLines = Files.lines(path)) {
            return fileLines.findFirst().
                    map(s -> new Pair<>(parseInt(s.split(" ")[0]), parseInt(s.split(" ")[1]))).orElse(new Pair<>(0, 0));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> readOtherLines(Path path) {
        try (Stream<String> fileLines = Files.lines(path)) {
            return fileLines.skip(1).collect(Collectors.<String>toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void computeGrid(Grid grid, List<String> lines) {
        for (String points : lines) {
            points.chars().forEach(c -> grid.pushCell(valueOf((char)c)));
        }
    }

}
