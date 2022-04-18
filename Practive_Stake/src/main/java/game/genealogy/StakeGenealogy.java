package game.genealogy;

import game.card.Card;
import game.card.CardType;

import java.util.*;

public class StakeGenealogy implements Genealogy {
    private final Set<Card[]> combinationHand = new HashSet<>();

    private void combinationCards(List<Card> hand, boolean[] checks, int index, int count) {
        if (count == 0) {
            List<Card> combinationSelect = new ArrayList<>();

            for (int i = 0; i < hand.size(); i++) {
                if (checks[i])
                    combinationSelect.add(hand.get(i));
            }

            combinationHand.add(combinationSelect.toArray(new Card[0]));
        } else {
            for (int i = index; i < hand.size(); i++) {
                checks[i] = true;
                combinationCards(hand, checks, i + 1, count - 1);
                checks[i] = false;
            }
        }
    }

    @Override
    public String handName(Card... cards){
        Card card1 = cards[0];
        Card card2 = cards[1];

        if (card1.getTag() == CardType.SKETCH && card2.getTag() == CardType.SKETCH)
            return card1.getNumber() + "." + card2.getNumber() + "광땡";

        if (card1.getNumber() == card2.getNumber())
            return card1.getNumber() == 10 ? "장땡" : card1.getNumber() + "땡";

        return card1.getNumber() + card2.getNumber() >= 10 ? (card1.getNumber() + card2.getNumber()) - 10 + "끗" : card1.getNumber() + card2.getNumber() + "끗";
    }

    @Override
    public Card[] selectBestHand(List<Card> hand) {
        combinationHand.clear();
        boolean[] checks = new boolean[hand.size()];

        this.combinationCards(hand, checks, 0, 2);

        int maxScore = 0;
        Card[] maxCards = new Card[2];

        for (Card[] cards : combinationHand) {
            int score = calcScore(cards[0], cards[1]);

            if (maxScore < score) {
                maxScore = score;
                maxCards = cards;
            }
        }

        return maxCards;
    }

    @Override
    public int calcScore(Card... cards) {
        Card card1 = cards[0];
        Card card2 = cards[1];

        if (card1.getTag() == CardType.SKETCH && card2.getTag() == CardType.SKETCH) {
            if (card1.getNumber() == 3 && card2.getNumber() == 8)
                return 100;

            return 99;
        }

        if (card1.getNumber() == card2.getNumber())
            return 90 + (card1.getNumber() - 2);

        return card1.getNumber() + card2.getNumber() >= 10 ? (card1.getNumber() + card2.getNumber()) - 10 : card1.getNumber() + card2.getNumber();
    }
}
