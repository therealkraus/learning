import java.util.stream.IntStream;

public class Permutations {

    public static int[] chain(int[] p1, int[] p2){
        int [] arr = new int[p1.length];
        for (int i = 0; i < p1.length; i++) {
            arr[i] = p2[p1[i]];
        }
        return arr;
    }

    public static int[] inverse(int[] perm){
        int [] arr = new int[perm.length];
        IntStream.range(0, perm.length).forEach(i -> arr[perm[i]] = i);
        return arr;
    }

    public static int[] square(int[] perm){
        return chain(perm, perm);
    }

    public static int[] power(int[] perm, int k){
        switch (k) {
            case 0: return IntStream.range(0, perm.length).toArray();
            case 1: return perm;
            case 2: return square(perm);
        }

        if (k < 0) {
            return power(inverse(perm), -k);
        }
        else if (k % 2 == 0) {
            return power(square(perm), k / 2);
        }
        else {
            return chain(perm, power(perm, k - 1));
        }
    }
}
