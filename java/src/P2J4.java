import java.util.*;

public class P2J4 {
    public static List<Integer> runningMedianOfThree(List<Integer> items) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (i >= 2) {
                int a = items.get(i - 2);
                int b = items.get(i - 1);
                int c = items.get(i);
                int max = Math.max(a, Math.max(b, c));
                int min = Math.min(a, Math.min(b, c));
                int median = a + b + c - min - max;
                result.add(median);
            } else {
                result.add(items.get(i));
            }
        }
        return result;
    }

    public static int firstMissingPositive(List<Integer> items) {
        boolean[] results = new boolean[items.size() + 1];

        for (int item : items) {
            if (item <= 0 || item >= results.length) {
                continue;
            }
            results[item] = true;
        }

        for (int i = 1; i < results.length; i++) {
            if (results[i]) {
                continue;
            }
            return i;
        }

        return results.length;
    }

    public static void sortByElementFrequency(List<Integer> items) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int item : items) {
            int val = counterMap.getOrDefault(item, 0) + 1;
            counterMap.put(item, val);
        }

        class ItemComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer a, Integer b) {
                int count1 = counterMap.get(a);
                int count2 = counterMap.get(b);
                int countDifference = count2 - count1;
                if (countDifference == 0) {
                    return a.compareTo(b);
                }
                return countDifference;
            }
        }

        items.sort(new ItemComparator());
    }

    public static List<Integer> factorFactorial(int n) {
        Map<Integer, Integer> exponentMap = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            int num = i;
            for (int j = 2; j <= num; j++) {
                while (num % j == 0) {
                    int exponent = exponentMap.getOrDefault(j, 0) + 1;
                    exponentMap.put(j, exponent);
                    num = num / j;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : exponentMap.entrySet()) {
            int key = pair.getKey();
            int value = pair.getValue();
            for (int i = 0; i < value; i++) {
                result.add(key);
            }
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }
}
