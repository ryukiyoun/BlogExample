package game.player;

import game.card.Card;
import game.card.StakeCard;
import game.combination.Combination;
import game.genealogy.Genealogy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class StakeAIPlayer implements Player<StakeCard> {
    private final Genealogy<StakeCard> genealogy;
    private final Combination<StakeCard> combinationGenerator;

    private final String name;
    private final List<StakeCard> hand;
    private List<StakeCard> bestHand;

    public StakeAIPlayer(String name, Genealogy<StakeCard> genealogy, Combination<StakeCard> combinationGenerator) {
        this.hand = new ArrayList<>();
        this.name = name;
        this.genealogy = genealogy;
        this.combinationGenerator = combinationGenerator;
    }

    private void selectMaxScoreCardSet(Set<List<StakeCard>> combinationCards) {
        int maxScore = -1;

        for (List<StakeCard> cards : combinationCards) {
            int score = genealogy.calcScore(cards);

            if (maxScore < score) {
                maxScore = score;
                bestHand = cards;
            }
        }
    }

    private Set<List<StakeCard>> getCardCombination() {
        return combinationGenerator.generate(hand, 2);
    }

    @Override
    public void receiveCard(StakeCard card) {
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
