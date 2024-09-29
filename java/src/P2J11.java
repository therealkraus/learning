import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P2J11 {
    public static List<Integer> buildSuffixArray(String text) {
        class SuffixComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer num1, Integer num2) {
                int textLength = text.length();
                for (int i = 0; i < textLength; i++) {
                    int j = (num1 + i);
                    int k = (num2 + i);
                    if (j >= textLength) {
                        j -= textLength;
                    }
                    if (k >= textLength) {
                        k -= textLength;
                    }
                    char char1 = text.charAt(j);
                    char char2 = text.charAt(k);
                    if (char1 == char2) {
                        continue;
                    }
                    return char1 - char2;
                }
                return num2 - num1;
            }
        }

        List<Integer> suffix = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            suffix.add(i);
        }

        suffix.sort(new SuffixComparator());

        return suffix;
    }

    public static List<Integer> find(
            String pattern, String text, List<Integer> suffix
    ) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = suffix.size() - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            String middleSuffix = text.substring(suffix.get(middle));
            if (middleSuffix.compareTo(pattern) == 0) {
                break;
            } else if (middleSuffix.compareTo(pattern) < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        for (int i = left; i < suffix.size(); i++) {
            String suffixString = text.substring(suffix.get(i));
            if (!suffixString.startsWith(pattern)) {
                break;
            }
            result.add(suffix.get(i));
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }
}
