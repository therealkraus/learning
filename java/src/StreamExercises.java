import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class StreamExercises {
    public static int countLines(Path path, int thres) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            long lineCount = lines.filter(line -> line.length() >= thres).count();
            return Math.toIntExact(lineCount);
        }
    }

    public static List<String> collectWords(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            Stream<String> words = lines.map(word -> word.toLowerCase())
                                        .flatMap(line -> Stream.of(line.split("[^a-z]+")))
                                        .filter(word -> word.length() > 0)
                                        .distinct()
                                        .sorted();
            return words.toList();
        }
    }
}
