package game.player;

import game.card.Card;
import game.combination.CombinationCards;
import game.genealogy.Genealogy;

import java.util.*;

public class AIPlayer implements Player {
    private final Genealogy genealogy;

    private final String name;
    private final List<Card> hand;
    private List<Card> bestHand;

    public AIPlayer(String name, Genealogy genealogy) {
        this.hand = new ArrayList<>();
        this.name = name;
        this.genealogy = genealogy;
    }

    private void selectMaxScoreCardSet(Set<List<Card>> combinationCards) {
        int maxScore = -1;

        for (List<Card> cards : combinationCards) {
            int score = genealogy.calcScore(cards);

            if (maxScore < score) {
                maxScore = score;
                bestHand = cards;
            }
        }
    }

    private Set<List<Card>> getCardCombination() {
        boolean[] checks = new boolean[hand.size()];
        return new CombinationCards().calcCombination(hand, checks, 0, 2);
    }

    @Override
    public void receiveCard(Card card) {
        hand.add(card);
        hand.sort(Comparator.comparingInt(Card::getNumber));
    }

    @Override
    public int getScore() {
        if(bestHand.isEmpty())
            throw new RuntimeException("Not Select Best Hand");

        return genealogy.calcScore(bestHand);
    }

    @Override
    public void selectBestCards() {
        selectMaxScoreCardSet(getCardCombination());
        hand.clear();
    }

    @Override
    public String toString() {
        return this.name + "\n" +
                bestHand.get(0) + "\n" +
                bestHand.get(1) + "\n" +
                genealogy.genealogyName(bestHand);
    }
}
