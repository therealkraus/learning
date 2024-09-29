import java.util.Arrays;

public class Polynomial implements Comparable<Polynomial> {
    private final int[] coefficients;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] == 0) {
                continue;
            }
            if (coefficients[i] > 0 && i != coefficients.length - 1) {
                sb.append(" + ");
            }
            if (coefficients[i] < 0) {
                sb.append(" - ");
            }
            if (i == 0 || Math.abs(coefficients[i]) != 1) {
                sb.append(Math.abs(coefficients[i]));
            }
            if (i > 0) {
                sb.append("x");
            }
            if (i > 1) {
                sb.append("^").append(i);
            }
        }
        return sb.toString();
    }

    public Polynomial(int[] coefficients) {
        int lastNonZero = -1;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                lastNonZero = i;
                break;
            }
        }

        if (lastNonZero == -1) {
            this.coefficients = new int[]{0};
            return;
        }
        this.coefficients = Arrays.copyOf(coefficients, lastNonZero + 1);
    }

    public int getDegree() {
        return coefficients.length - 1;
    }

    public int getCoefficient(int k) {
        if (k < 0 || k >= coefficients.length) {
            return 0;
        }
        return coefficients[k];
    }

    public long evaluate(int x) {
        long result = 0;
        int i = coefficients.length - 1;
        while (i >= 0) {
            result = result * x + coefficients[i];
            i--;
        }
        return result;
    }
    public Polynomial add(Polynomial other) {
        int maxLength = Math.max(this.coefficients.length, other.coefficients.length);
        int[] result = new int[maxLength];

        int i = this.coefficients.length - 1;
        while (i >= 0) {
            result[i] += this.coefficients[i];
            i--;
        }
        int j = other.coefficients.length - 1;
        while (j >= 0) {
            result[j] += other.coefficients[j];
            j--;
        }

        return new Polynomial(result);
    }

    public Polynomial multiply(Polynomial other) {
        int maxLength = this.coefficients.length + other.coefficients.length;
        int[] result = new int[maxLength];

        for (int i = coefficients.length - 1; i >= 0; i--) {
            for (int j = other.coefficients.length - 1; j >= 0; j--) {
                result[i + j] += this.coefficients[i] * other.coefficients[j];
            }
        }

        return new Polynomial(result);
    }

    @Override public boolean equals(Object other) {
        if (!(other instanceof Polynomial otherPolynomial)) {
            return false;
        }
        return this.compareTo(otherPolynomial) == 0;
    }

    @Override public int hashCode() {
        int[] noLeadingZeros = Arrays.stream(coefficients).dropWhile(c -> c == 0).toArray();
        return Arrays.hashCode(noLeadingZeros);
    }

    @Override
    public int compareTo(Polynomial other) {
        int degreeCompared = Integer.compare(this.getDegree(), other.getDegree());
        if (degreeCompared != 0) {
            return degreeCompared;
        }

        for (int i = this.coefficients.length - 1; i >= 0; i--) {
            int coefficientCompared = Integer.compare(this.coefficients[i], other.coefficients[i]);
            if (coefficientCompared != 0) {
                return coefficientCompared;
            }
        }
        return 0;
    }
}
