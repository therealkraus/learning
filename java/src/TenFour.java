import java.util.*;

public class TenFour {
    public static List<Integer> shortestPath(int n, int limit){
        boolean[] seen = new boolean[limit];
        int[] parent = new int[limit];
        LinkedList<Integer> frontier = new LinkedList<>();

        seen[4] = true;
        frontier.add(4);
        while (!frontier.isEmpty()) {
            Integer v = frontier.poll();

            if (v == n) {
                List<Integer> path = new ArrayList<>();
                for (; v != 0; v = parent[v]) { path.add(v); }
                Collections.reverse(path);
                return path;
            }

            int num1 = 10 * v;
            int num2 = 10 * v + 4;
            int num3 = v / 2;

            if (num1 < limit && !seen[num1]) {
                seen[num1] = true;
                parent[num1] = v;
                frontier.add(num1);
            }
            if (num2 < limit && !seen[num2]) {
                seen[num2] = true;
                parent[num2] = v;
                frontier.add(num2);
            }
            if (v % 2 == 0) {
                if (!seen[num3]) {
                    seen[num3] = true;
                    parent[num3] = v;
                    frontier.add(num3);
                }
            }
        }
        return List.of();
    }
}