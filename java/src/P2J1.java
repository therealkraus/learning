public class P2J1 {

    public static long fallingPower(int n, int k) {
        if (k == 0){
            return 1;
        }

        long result = n;

        for (int i = 1; i < k; i++){
            n--;
            result = result * n;
        }

        return result;
    }

    public static int[] everyOther(int[] arr){
        int mod = (arr.length & 1) == 0 ? 0 : 1;
        int [] result = new int[arr.length / 2 + mod];

        for (int i = 0; i < result.length; i++){
            result[i] = arr[i * 2];
        }

        return result;
    }

    public static int[][] createZigZag(int rows, int cols, int start) {
        int[][] result = new int[rows][cols];

        for (int i = 0; i < result.length; i++) {
            int c = result[i].length - 1;
            int b = start;
            for (int j = 0; j < result[i].length; j++) {
                if ((i & 1) == 0) {
                    result[i][j] = b;
                    b++;
                }
                else {
                    result[i][j] = b + c;
                    b--;
                }
                start++;
            }
        }

        return result;
    }

    public static int countInversions(int[] arr){
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    result++;
                }
            }

        }

        return result;
    }
}
