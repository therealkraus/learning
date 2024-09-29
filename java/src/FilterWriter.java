import java.io.IOException;
import java.io.Writer;
import java.util.function.BiPredicate;

public class FilterWriter extends Writer{
    private final Writer writer;
    private final BiPredicate<Character, Character> pred;
    private char previous;

    public FilterWriter(Writer writer, BiPredicate<Character, Character>
            pred, char previous) {
        this.writer = writer;
        this.pred = pred;
        this.previous = previous;
    }

    @Override
    public void flush() throws IOException {
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

    @Override
    public void write(char[] data, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            char current = data[i];
            if (!pred.test(previous, current)) {
                continue;
            }
            writer.write(current);
            previous = current;
        }
    }
}
