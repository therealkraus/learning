import java.util.HashSet;
import java.util.Set;

public class P2J3 {

    private static void reverseArray(int[] items, int start, int end) {
        for (int i = start; i <= (start + end) / 2; i++) {
            int temp = items[i];
            items[i] = items[end - (i - start)];
            items[end - (i - start)] = temp;
        }
    }

    public static void reverseAscendingSubarrays(int[] items) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i] > items[i + 1]) {
                if (start != end) {
                    reverseArray(items, start, end);
                }
                start = i + 1;
            }
            end = i + 1;

            if (i == items.length - 2) {
                reverseArray(items, start, end);
            }
        }
    }

    public static String pancakeScramble(String text) {

        for (int i = 0; i < text.length() - 1; i++) {
            String toReverse = text.substring(0, i + 2);
            String toKeep = text.substring(i + 2);
            toReverse = new StringBuilder(toReverse).reverse().toString();
            text = toReverse + toKeep;
        }

        return text;
    }

    public static String reverseVowels(String text) {
        StringBuilder reversed = new StringBuilder();

        String vowels = "aeiouAEIOU";
        Set<Character> vowelSet = new HashSet<>();

        for (char c : vowels.toCharArray()) {
            vowelSet.add(c);
        }

        for (int i =0, j = text.length() - 1; i < text.length(); i++) {
            if (vowelSet.contains(text.charAt(i))) {
                while (!vowelSet.contains(text.charAt(j))) {
                    j--;
                }
                if  (Character.isUpperCase(text.charAt(i))) {
                    reversed.append(Character.toUpperCase(text.charAt(j)));
                } else {
                    reversed.append(Character.toLowerCase(text.charAt(j)));
                }
                j--;
            } else {
                if (Character.isUpperCase(text.charAt(i))) {
                    reversed.append(Character.toUpperCase(text.charAt(i)));
                } else {
                    reversed.append(Character.toLowerCase(text.charAt(i)));
                }
            }
        }

        return reversed.toString();
    }

}
