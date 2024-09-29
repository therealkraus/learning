public class ConcatRope extends Rope {
    private final Rope left, right;

    public ConcatRope(Rope left, Rope right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public char charAt(int index) {
        if(index < 0 || index >= length()) {
            throw new IndexOutOfBoundsException();
        }
        if(index < left.length()) {
            return left.charAt(index);
        }
        return right.charAt(index - left.length());
    }
    @Override
    protected int computeLength() {
        return left.length() + right.length();
    }

    @Override
    public String toString() {
        return left.toString() + right.toString();
    }
}