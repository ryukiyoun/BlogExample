package game.player;

import game.card.Card;
import game.genealogy.Genealogy;
import game.genealogy.StakeGenealogy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StakeAIPlayer implements Player {
    private static final Genealogy stakeGenealogy = new StakeGenealogy();

    private final String name;
    private final List<Card> hand;
    private List<Card> bestHand;
    private int score;

    public StakeAIPlayer(String name) {
        this.hand = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void receiveCard(Card card) {
        hand.add(card);
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void openHand() {
        Collections.sort(hand);
        bestHand = stakeGenealogy.selectBestHand(hand);

        this.score = stakeGenealogy.calcScore(bestHand);
        this.hand.clear();
    }

    @Override
    public String toString() {
        return this.name + "\n" +
                bestHand.get(0).toString() + "\n" +
                bestHand.get(1).toString() + "\n" +
                stakeGenealogy.genealogyName(bestHand);
    }
}
