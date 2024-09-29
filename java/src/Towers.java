import java.util.ArrayList;
import java.util.List;

public class Towers {
    public static int minimizeTowers(int[] blocks) {
        List<Integer> minimumTowers = new ArrayList<>();
        for (int block : blocks) {
            int left = 0;
            int right = minimumTowers.size() - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (minimumTowers.get(middle) > block) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            if (left == minimumTowers.size()) {
                minimumTowers.add(block);
            } else {
                minimumTowers.set(left, block);
            }
        }
        return minimumTowers.size();
    }
}
