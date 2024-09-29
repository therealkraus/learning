public class StringRope extends Rope {
    private final String string;

    public StringRope(String string) {
        this.string = string;
    }
    @Override
    public char charAt(int index) {
        if(index < 0 || index >= length()) {
            throw new IndexOutOfBoundsException();
        }
        return string.charAt(index);
    }
    @Override
    protected int computeLength() {
        return string.length();
    }

    @Override
    public String toString() {
        return string;
    }
}
