import java.util.*;

public class MultipleWinnerElection {
    private static int[] calculateSeatsWon(int[] votes, int seats, int formulaType) {
        int[] seatsWon = new int[votes.length];
        Fraction[] currentFractions = new Fraction[votes.length];

        for (int i = 0; i < votes.length; i++) {
            currentFractions[i] = getFormula(votes[i], seatsWon[i], formulaType);
        }

        Comparator<Integer> createComparator = (index1, index2) -> {
            Fraction frac1 = currentFractions[index1];
            Fraction frac2 = currentFractions[index2];
            int fracComparison = frac2.compareTo(frac1);
            if (fracComparison == 0) {
                return index2 - index1;
            }
            return fracComparison;
        };

        PriorityQueue<Integer> queue = new PriorityQueue<>(votes.length, createComparator);
        for (int i = 0; i < votes.length; i++) {
            queue.offer(i);
        }

        while (seats > 0) {
            int index = queue.poll();
            seatsWon[index]++;
            currentFractions[index] = getFormula(votes[index], seatsWon[index], formulaType);
            queue.add(index);
            seats--;
        }

        return seatsWon;
    }

    private static Fraction getFormula(int votes, int seatsWon, int formulaType) {
        if (formulaType == 0){
            return new Fraction(votes).divide(new Fraction(seatsWon + 1));
        }
        if (formulaType == 1){
            return new Fraction(votes).divide(new Fraction(2 * seatsWon + 1));
        }
        return new Fraction(votes).divide(new Fraction(1).add(new Fraction(seatsWon, 2)));
    }

    public static int[] DHondt(int[] votes, int seats){
        return calculateSeatsWon(votes, seats, 0);
    }
    public static int[] webster(int[] votes, int seats) {
        return calculateSeatsWon(votes, seats, 1);
    }
    public static int[] imperiali(int[] votes, int seats) {
        return calculateSeatsWon(votes, seats, 2);
    }
}
