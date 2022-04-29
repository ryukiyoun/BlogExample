package game.player;

import game.card.Card;
import game.combination.Combination;
import game.genealogy.Genealogy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AIPlayer implements Player {
    private final Genealogy genealogy;
    private final Combination<Card> combinationGenerator;

    private final String name;
    private final List<Card> hand;
    private List<Card> bestHand;

    public AIPlayer(String name, Genealogy genealogy, Combination<Card> combinationGenerator) {
        this.hand = new ArrayList<>();
        this.name = name;
        this.genealogy = genealogy;
        this.combinationGenerator = combinationGenerator;
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
        return combinationGenerator.generate(hand, 2);
    }

    @Override
    public void receiveCard(Card card) {
        hand.add(card);
        hand.sort(Comparator.comparingInt(Card::getNumber));
    }

    @Override
    public int getScore() {
        if(bestHand.isEmpty())
            return 0;

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
