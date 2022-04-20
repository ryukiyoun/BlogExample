package game.player;

import game.card.Card;
import game.genealogy.Genealogy;
import game.genealogy.StakeGenealogy;

import java.util.*;

public class StakeAIPlayer implements Player {
    private static final Genealogy stakeGenealogy = new StakeGenealogy();

    private final Set<List<Card>> combinationHand = new HashSet<>();
    private final String name;
    private final List<Card> hand;
    private List<Card> bestHand;
    private int score;

    public StakeAIPlayer(String name) {
        this.hand = new ArrayList<>();
        this.name = name;
    }

    private void combinationCards(List<Card> hand, boolean[] checks, int index, int count) {
        if (count == 0) {
            List<Card> combinationSelect = new ArrayList<>();

            for (int i = 0; i < hand.size(); i++) {
                if (checks[i])
                    combinationSelect.add(hand.get(i));
            }

            combinationHand.add(combinationSelect);
        } else {
            for (int i = index; i < hand.size(); i++) {
                checks[i] = true;
                combinationCards(hand, checks, i + 1, count - 1);
                checks[i] = false;
            }
        }
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
        bestHand = selectBestHand(hand);

        this.score = stakeGenealogy.calcScore(bestHand);
        this.hand.clear();
    }

    @Override
    public List<Card> selectBestHand(List<Card> hand) {
        combinationHand.clear();
        boolean[] checks = new boolean[hand.size()];

        this.combinationCards(hand, checks, 0, 2);

        int maxScore = -1;
        List<Card> maxCards = new ArrayList<>();

        for (List<Card> cards : combinationHand) {
            int score = stakeGenealogy.calcScore(cards);

            if (maxScore < score) {
                maxScore = score;
                maxCards = cards;
            }
        }

        return maxCards;
    }

    @Override
    public String toString() {
        return this.name + "\n" +
                bestHand.get(0).toString() + "\n" +
                bestHand.get(1).toString() + "\n" +
                stakeGenealogy.genealogyName(bestHand);
    }
}
