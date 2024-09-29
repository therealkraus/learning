import java.util.HashSet;

public class P2J2 {

    public static String removeDuplicates(String text) {
        if (text.isEmpty()) {
            return text;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) != text.charAt(i + 1)) {
                result.append(text.charAt(i));
            }
        }

        result.append(text.charAt(text.length() - 1));

        return result.toString();

    }

    public static String uniqueCharacters(String text) {
         HashSet<Character> hs = new HashSet<>();
        StringBuilder result = new StringBuilder();

         for (int i = 0; i < text.length(); i++) {
             if (hs.add(text.charAt(i))) {
                 result.append(text.charAt(i));
             }
         }

         return result.toString();
    }

    public static int countSafeSquaresRooks(int n, boolean[][] rooks) {
        boolean[] safeRows = new boolean[n];
        boolean[] safeCols = new boolean[n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if (rooks[i][j]){
                    safeRows[i] = true;
                    safeCols[j] = true;
                }

            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!safeRows[i] && !safeCols[j]) { // If the square is not in an unsafe row or column
                    result++; // It's a safe square
                }
            }
        }

        return result;
    }

    public static int recaman(int n) {
        if (n == 1) {
            return 1;
        }

        int[] sequence = new int[n + 1];
        boolean[] used = new boolean[10 * n];

        sequence[0] = 0;
        used[0] = true;
        sequence[1] = 1;
        used[1] = true;

        for (int i = 2; i <= n; i++) {
            int next_num = sequence[i - 1] - i;
            if (next_num > 0 && !used[next_num]) {
                sequence[i] = next_num;
                used[next_num] = true;
            } else {
                next_num = sequence[i - 1] + i;
                sequence[i] = next_num;
                used[next_num] = true;
            }
        }

        return sequence[n];
    }
}
