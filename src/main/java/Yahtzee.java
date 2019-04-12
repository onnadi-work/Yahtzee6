import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Yahtzee {
    private static final int YAHTZEE = 50;
    public static final int DEFAULT_SCORE = 0;
    ArrayList<Integer> dice;
    public Yahtzee(Integer...ints) {
        dice = new ArrayList<>();
        Collections.addAll(dice, ints);
    }

    public int scoreOnes() {
        return scoreSingles(1);
    }

    private int scoreSingles(int i) {
        return Collections.frequency(dice, i) * i;
    }

    public int scoreTwos() {
        return scoreSingles(2);
    }

    public int scoreThrees() {
        return scoreSingles(3);
    }

    public int scoreFours() {
        return scoreSingles(4);
    }

    public int scoreFives() {
        return scoreSingles(5);
    }

    public int scoreSixes() {
        return scoreSingles(6);
    }

    public int scoreHighestPair() {
        return dice.stream().
                filter(d-> isPair(d)).
                mapToInt(i->i).
                max().
                orElse(DEFAULT_SCORE) * 2;
    }

    private boolean isPair(Integer d) {
        return Collections.frequency(dice, d) >= 2;
    }

    public int scoreTwoPair() {
        HashSet<Integer> pairs = new HashSet<>();

        for(int d: dice){
            if(isPair(d)){
                pairs.add(d);
            }
        }

        if(pairs.size() == 2){
            return pairs.stream().mapToInt(i->i).sum() * 2;
        }else{
            return DEFAULT_SCORE;
        }
    }

    public int scoreThreeOfAKind() {
            return scoreNOfAKind(3);
    }

    public int scoreFourOfAKind() {
        return scoreNOfAKind(4);
    }

    private int scoreNOfAKind(int i2) {
        return dice.stream().filter(d -> Collections.frequency(dice, d) == i2).mapToInt(i -> i).sum();
    }

    public int scoreSmallStraight() {
        return scoreStraight(1, 2, 3, 4, 5);
    }

    private ArrayList<Integer> list(Integer...ints  ) {
        ArrayList<Integer> returnValue = new ArrayList<>();
        Collections.addAll(returnValue, ints);
        return returnValue;
    }

    public int scoreLargeStraight() {
        return scoreStraight(2, 3, 4, 5, 6);
    }

    private int scoreStraight(int i2, int i3, int i4, int i5, int i6) {
        return dice.containsAll(list(i2, i3, i4, i5, i6)) ? getSum() : DEFAULT_SCORE;
    }

    private int getSum() {
        return dice.stream().mapToInt(i -> i).sum();
    }

    public int scoreFullHouse() {
        return hasPair() && hasThreeOfAKind() ? getSum() : DEFAULT_SCORE;
    }

    private boolean hasThreeOfAKind() {
        return hasNOfAKind(3);
    }

    private boolean hasNOfAKind(int i) {
        return dice.stream().filter(d -> Collections.frequency(dice, d) == i).count() == i;
    }

    private boolean hasPair() {
        return hasNOfAKind(2);
    }

    public int scoreYahtzee() {
        return dice.stream().allMatch(d->d == firstDie()) ? YAHTZEE : DEFAULT_SCORE;
    }

    private Integer firstDie() {
        return dice.get(0);
    }

    public int scoreChance() {
        return getSum();
    }
}
