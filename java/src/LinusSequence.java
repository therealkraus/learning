public class LinusSequence {
    public static int maximalRepeatedSuffix(boolean[] bits, int n) {
        int length = n / 2;
        while (length > 0) {
            boolean found = true;
            for (int i = 0; i < length; i++) {
                if (bits[n - length + i] != bits[n - 2 * length + i]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return length;
            }
            length--;
        }
        return 0;
    }

    public static boolean[] linusSequence(int n) {
        boolean[] sequence = new boolean[n];
        sequence[0] = true;

        for (int i = 1; i < n; i++) {
            sequence[i] = false;
            int len1 = maximalRepeatedSuffix(sequence, i + 1);
            sequence[i] = true;
            int len2 = maximalRepeatedSuffix(sequence, i + 1);
            sequence[i] = len1 > len2;
        }
        return sequence;
    }

}
