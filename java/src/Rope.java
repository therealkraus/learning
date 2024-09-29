abstract public class Rope implements Comparable<Rope> {
    abstract public char charAt(int index);
    private int len = -1;

    private int hash = -1;

    @Override
    public int hashCode() {
        if(hash == -1) {
            for (int i = 0; i < length(); i++) {
                hash = 33 * hash + charAt(i);
                hash = hash & 0x07FFFFFF;
            }
        }
        return hash;
    }

    @Override
    public int compareTo(Rope other) {
        for (int i = 0; i < length() && i < other.length(); i++) {
            if (charAt(i) < other.charAt(i)) {
                return -1;
            }
            if (charAt(i) > other.charAt(i)) {
                return 1;
            }
        }
        return length() - other.length();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Rope otherRope)) {
            return false;
        }
        if (hash != -1 && otherRope.hash != -1 && hash != otherRope.hash) {
            return false;
        }
        return compareTo(otherRope) == 0;
    }

    public final int length() {
        if(len == -1) {
            // Call the template method to initialize len.
            len = computeLength();
        }
        // Either way, we can now return the cached value.
        return len;
    }

    // Subclasses must override the actual length computation.
    abstract protected int computeLength();
}