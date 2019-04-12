import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YahtzeeTest {
    @Test
    public void given11244AndOnesReturn2() {
        assertEquals(2, new Yahtzee(1, 1, 2, 4, 4).scoreOnes());
    }

    @Test
    public void given22244AndOnesReturn0() {
        assertEquals(0, new Yahtzee(2, 2, 2, 4, 4).scoreOnes());
    }

    @Test
    public void given22244Return6() {
        assertEquals(6, new Yahtzee(2, 2, 2, 4, 4).scoreTwos());
    }

    @Test
    public void given11144Return0() {
        assertEquals(0, new Yahtzee(1, 1, 1, 4, 4).scoreTwos());
    }

    @Test
    public void given33344Return9() {
        assertEquals(9, new Yahtzee(3, 3, 3, 4, 4).scoreThrees());
    }

    @Test
    public void scoreThreesGiven11144Return0() {
        assertEquals(0, new Yahtzee(1, 1, 1, 4, 4).scoreThrees());
    }

    @Test
    public void scoreFoursGiven11144Return8() {
        assertEquals(8, new Yahtzee(1, 1, 1, 4, 4).scoreFours());
    }

    @Test
    public void scoreFivesGiven11145Return5() {
        assertEquals(5, new Yahtzee(1, 1, 1, 4, 5).scoreFives());
    }

    @Test
    public void scoreSixesGiven66645Return18() {
        assertEquals(18, new Yahtzee(6, 6, 6, 4, 5).scoreSixes());
    }

    @Test
    public void scoreHighestPairGiven33344Return8() {
        assertEquals(8, new Yahtzee(3, 3, 3, 4, 4).scoreHighestPair());
    }

    @Test
    public void scoreHighestPairGiven35544Return10() {
        assertEquals(10, new Yahtzee(3, 5, 5, 4, 4).scoreHighestPair());
    }

    @Test
    public void scoreTwoPairGiven35544Return18() {
        assertEquals(18, new Yahtzee(3, 5, 5, 4, 4).scoreTwoPair());
    }

    @Test
    public void scoreTwoPairGiven32544Return0() {
        assertEquals(0, new Yahtzee(3, 2, 5, 4, 4).scoreTwoPair());
    }

    @Test
    public void scoreThreeOfAKindGiven33345Return9() {
        assertEquals(9, new Yahtzee(3, 3, 3, 4, 5).scoreThreeOfAKind());
    }

    @Test
    public void scoreThreeOfAKindGiven33145Return0() {
        assertEquals(0, new Yahtzee(3, 3, 1, 4, 5).scoreThreeOfAKind());
    }

    @Test
    public void scoreFourOfAKindGiven33335Return12() {
        assertEquals(12, new Yahtzee(3, 3, 3, 3, 5).scoreFourOfAKind());
    }

    @Test
    public void scoreSmallStraightGiven12345Return15() {
        assertEquals(15, new Yahtzee(1, 2, 3, 4, 5).scoreSmallStraight());
    }

    @Test
    public void scoreSmallStraightGiven12346Return0() {
        assertEquals(0, new Yahtzee(1, 2, 3, 4, 6).scoreSmallStraight());
    }

    @Test
    public void scoreLargeStraightGiven23456Return20() {
        assertEquals(20, new Yahtzee( 2, 3, 4, 5, 6).scoreLargeStraight());
    }

    @Test
    public void scoreFullHouseGiven11222Return8() {
        assertEquals(8, new Yahtzee( 1, 1, 2, 2, 2).scoreFullHouse());
    }

    @Test
    public void scoreFullHouseGiven22222Return0() {
        assertEquals(0, new Yahtzee( 2, 2, 2, 2, 2).scoreFullHouse());
    }

    @Test
    public void scoreYahtzeeeGiven32222Return50() {
        assertEquals(0, new Yahtzee( 3, 2, 2, 2, 2).scoreYahtzee());
    }

    @Test
    public void scoreChanceGiven32222Return11() {
        assertEquals(11, new Yahtzee( 3, 2, 2, 2, 2).scoreChance());
    }

    @Test
    public void scoreChanceGiven22222Return11() {
        assertEquals(10, new Yahtzee( 2, 2, 2, 2, 2).scoreChance());
    }
}
