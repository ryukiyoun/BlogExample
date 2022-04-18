package game.player;

import game.card.Card;
import game.genealogy.Genealogy;
import game.genealogy.StakeGenealogy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StakePlayer implements Player, Comparable<StakePlayer> {
    private static final Genealogy stakeGenealogy = new StakeGenealogy();

    private final String name;
    private final List<Card> hand;
    private Card[] bestHand;
    private int score;

    public StakePlayer(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    @Override
    public void getACard(Card card) {
        hand.add(card);
    }

    @Override
    public void openHand() {
        System.out.println("----------------" + this.name + "---------------");
        for (Card card : hand)
            System.out.println(card.toString());

        Collections.sort(hand);
        bestHand = stakeGenealogy.selectBestHand(hand);

        System.out.println("----------------" + "최적의 패" + "---------------");
        System.out.println(bestHand[0].toString());
        System.out.println(bestHand[1].toString());
        System.out.println(stakeGenealogy.handName(bestHand));

        this.score = stakeGenealogy.calcScore(bestHand);
        this.clearHand();
    }

    @Override
    public void clearHand() {
        hand.clear();
    }

    @Override
    public int compareTo(StakePlayer o) {
        return Integer.compare(this.score, o.score);
    }

    @Override
    public String toString() {
        return this.name + "\n" +
                bestHand[0].toString() + "\n" +
                bestHand[1].toString() + "\n" +
                stakeGenealogy.handName(bestHand);
    }
}
