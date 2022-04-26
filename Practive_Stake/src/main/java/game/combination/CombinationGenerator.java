package game.combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationGenerator<T>{
    private final Set<List<T>> combinationHand;

    public CombinationGenerator() {
        this.combinationHand = new HashSet<>();
    }

    public Set<List<T>> generate(List<T> cards, int count){
        boolean[] Confirms = new boolean[cards.size()];
        combination(cards, Confirms, 0, count);
        return combinationHand;
    }

    private void combination(List<T> hand, boolean[] checks, int startIndex, int loopCount) {
        if (loopCount == 0) {
            combinationHand.add(getCombinationResult(hand, checks));
            return;
        }

        for (int i = startIndex; i < hand.size(); i++) {
            checks[i] = true;
            combination(hand, checks, i + 1, loopCount - 1);
            checks[i] = false;
        }
    }

    private List<T> getCombinationResult(List<T> hand, boolean[] checks) {
        List<T> combinationSelect = new ArrayList<>();

        for (int i = 0; i < hand.size(); i++) {
            if (checks[i])
                combinationSelect.add(hand.get(i));
        }

        return combinationSelect;
    }
}
