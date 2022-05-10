package game.genealogy;

import game.card.StakeCard;

import java.util.List;

public class StakeGenealogy implements Genealogy<StakeCard> {
    @Override
    public String genealogyName(List<StakeCard> cards){
        StakeCard card1 = cards.get(0);
        StakeCard card2 = cards.get(1);

        if (card1.isGwang() && card2.isGwang()) return card1.getNumber() + "." + card2.getNumber() + "광땡";

        if (card1.isSameNumber(card2)) return card1.getNumber() == 10 ? "장땡" : card1.getNumber() + "땡";

        return card1.getNumber() + card2.getNumber() >= 10 ? (card1.getNumber() + card2.getNumber()) - 10 + "끗" : card1.getNumber() + card2.getNumber() + "끗";
    }

    @Override
    public int calcScore(List<StakeCard> cards) {
        StakeCard card1 = cards.get(0);
        StakeCard card2 = cards.get(1);

        if (card1.isGwang() && card2.isGwang())
            return 100;

        if (card1.isSameNumber(card2))
            return 90 + (card1.getNumber() - 2);

        return card1.getNumber() + card2.getNumber() >= 10 ? (card1.getNumber() + card2.getNumber()) - 10 : card1.getNumber() + card2.getNumber();
    }
}
