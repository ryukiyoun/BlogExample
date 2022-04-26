package game.combination;

import game.card.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationCards {
    private final Set<List<Card>> combinationHand;

    public CombinationCards() {
        this.combinationHand = new HashSet<>();
    }

    public Set<List<Card>> calcCombination(List<Card> cards, boolean[] isConfirm, int index, int count){
        combinationCards(cards, isConfirm, index, count);
        return combinationHand;
    }

    private void combinationCards(List<Card> hand, boolean[] checks, int index, int count) {
        if (count == 0) {
            combinationHand.add(getCombinationCardList(hand, checks));
            return;
        }

        for (int i = index; i < hand.size(); i++) {
            checks[i] = true;
            combinationCards(hand, checks, i + 1, count - 1);
            checks[i] = false;
        }
    }

    private List<Card> getCombinationCardList(List<Card> hand, boolean[] checks) {
        List<Card> combinationSelect = new ArrayList<>();

        for (int i = 0; i < hand.size(); i++) {
            if (checks[i])
                combinationSelect.add(hand.get(i));
        }

        return combinationSelect;
    }
}
