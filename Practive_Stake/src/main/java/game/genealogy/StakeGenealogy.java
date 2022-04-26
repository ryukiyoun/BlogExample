package game.genealogy;

import game.card.Card;
import game.card.StakeCardType;

import java.util.List;

public class StakeGenealogy implements Genealogy {
    private boolean isGwang(Card card1, Card card2) {
        return card1.isSameType(StakeCardType.SKETCH) && card2.isSameType(StakeCardType.SKETCH);
    }

    private boolean isSameNumber(Card card1, Card card2){
        return card1.getNumber() == card2.getNumber();
    }

    @Override
    public String genealogyName(List<Card> cards){
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);

        if (isGwang(card1, card2)) return card1.getNumber() + "." + card2.getNumber() + "광땡";

        if (isSameNumber(card1, card2)) return card1.getNumber() == 10 ? "장땡" : card1.getNumber() + "땡";

        return card1.getNumber() + card2.getNumber() >= 10 ? (card1.getNumber() + card2.getNumber()) - 10 + "끗" : card1.getNumber() + card2.getNumber() + "끗";
    }

    @Override
    public int calcScore(List<Card> cards) {
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);

        if (isGwang(card1, card2))
            return 100;

        if (isSameNumber(card1, card2))
            return 90 + (card1.getNumber() - 2);

        return card1.getNumber() + card2.getNumber() >= 10 ? (card1.getNumber() + card2.getNumber()) - 10 : card1.getNumber() + card2.getNumber();
    }
}
