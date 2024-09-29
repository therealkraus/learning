public class SubRope extends Rope {
    private final Rope original;
    private final int start, end;

    public SubRope(Rope original, int start, int end) {
        if (start < 0 || start > end || end > original.length()) {
            throw new IndexOutOfBoundsException();
        }
        this.original = original;
        this.start = start;
        this.end = end;
    }
    @Override
    public char charAt(int index) {
        if(index < 0 || index >= length()){
            throw new IndexOutOfBoundsException();
        }
        return original.charAt(index + start);
    }
    @Override
    protected int computeLength() {
        return end - start;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length(); i++) {
            sb.append(charAt(i));
        }
        return sb.toString();
    }
}