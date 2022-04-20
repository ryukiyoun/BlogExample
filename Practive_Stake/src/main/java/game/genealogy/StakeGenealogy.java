package game.genealogy;

import game.card.Card;
import game.card.CardType;

import java.util.*;

public class StakeGenealogy implements Genealogy {
    @Override
    public String genealogyName(List<Card> cards){
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);

        if (card1.getType() == CardType.SKETCH && card2.getType() == CardType.SKETCH)
            return card1.getNumber() + "." + card2.getNumber() + "광땡";

        if (card1.getNumber() == card2.getNumber())
            return card1.getNumber() == 10 ? "장땡" : card1.getNumber() + "땡";

        return card1.getNumber() + card2.getNumber() >= 10 ? (card1.getNumber() + card2.getNumber()) - 10 + "끗" : card1.getNumber() + card2.getNumber() + "끗";
    }

    @Override
    public int calcScore(List<Card> cards) {
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);

        if (card1.getType() == CardType.SKETCH && card2.getType() == CardType.SKETCH) {
            if (card1.getNumber() == 3 && card2.getNumber() == 8)
                return 100;

            return 99;
        }

        if (card1.getNumber() == card2.getNumber())
            return 90 + (card1.getNumber() - 2);

        return card1.getNumber() + card2.getNumber() >= 10 ? (card1.getNumber() + card2.getNumber()) - 10 : card1.getNumber() + card2.getNumber();
    }
}
