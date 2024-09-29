import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class P2J5 {
    private static final List<BigInteger> fibs = new ArrayList<>();
    static {
        fibs.add(BigInteger.ONE);
        fibs.add(BigInteger.ONE);
    }

    private static void generateFibonacci(BigInteger n) {
        for (int i = fibs.size(); fibs.get(i - 1).compareTo(n) < 0; i++) {
            BigInteger firstTerm = fibs.get(i - 2);
            BigInteger secondTerm = fibs.get(i - 1);
            BigInteger nextTerm = firstTerm.add(secondTerm);
            fibs.add(nextTerm);
        }
    }

    public static List<BigInteger> fibonacciSum(BigInteger n) {
        List<BigInteger> result = new ArrayList<>();
        generateFibonacci(n);
        for (int i = fibs.size() - 1; i >= 0; i--) {
            if (fibs.get(i).compareTo(n) > 0) {
                continue;
            }
            result.add(fibs.get(i));
            n = n.subtract(fibs.get(i));
        }
        return result;
    }

    public static BigInteger sevenZero(int n) {
        BigInteger seven = new BigInteger("7");

        if ((n % 2 == 0) || (n % 5 == 0)) {
            int maxZeros = Math.max(countExponents(n, 2), countExponents(n, 5));

            while (true) {
                BigInteger smallestSevenZeroInteger = seven.multiply(BigInteger.TEN.pow(maxZeros));
                if (!smallestSevenZeroInteger.mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)) {
                    seven = seven.multiply(BigInteger.TEN).add(BigInteger.valueOf(7));
                    continue;
                }
                return smallestSevenZeroInteger;
            }
        }

        while (true) {
            if (!seven.mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)) {
                seven = seven.multiply(BigInteger.TEN).add(BigInteger.valueOf(7));
                continue;
            }
            return seven;
        }
    }

    private static int countExponents(int n, int p) {
        int count = 0;
        for (; n % p == 0; n /= p)
            count++;
        return count;
    }
}
