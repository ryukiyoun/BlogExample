package game.player;

import game.card.Card;
import game.genealogy.Genealogy;

import java.util.*;

public class AIPlayer implements Player {
    private final Genealogy genealogy;

    private final Set<List<Card<?>>> combinationHand = new HashSet<>();
    private final String name;
    private final List<Card<?>> hand;
    private List<Card<?>> bestHand;

    public AIPlayer(String name, Genealogy genealogy) {
        this.hand = new ArrayList<>();
        this.name = name;
        this.genealogy = genealogy;
    }

    private void combinationCards(List<Card<?>> hand, boolean[] checks, int index, int count) {
        if (count == 0) {
            List<Card<?>> combinationSelect = new ArrayList<>();

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
    public void receiveCard(Card<?> card) {
        hand.add(card);
    }

    @Override
    public int getScore() {
        if(bestHand.isEmpty())
            throw new RuntimeException("Not Select Best Hand");

        return genealogy.calcScore(bestHand);
    }

    @Override
    public void selectBestCards() {
        hand.sort(Comparator.comparingInt(Card::getNumber));

        combinationHand.clear();
        boolean[] checks = new boolean[hand.size()];

        combinationCards(hand, checks, 0, 2);

        int maxScore = -1;

        for (List<Card<?>> cards : combinationHand) {
            int score = genealogy.calcScore(cards);

            if (maxScore < score) {
                maxScore = score;
                bestHand = cards;
            }
        }

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
