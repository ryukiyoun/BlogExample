package game.genealogy;

import game.card.Card;

import java.util.List;

public interface Genealogy {
    int calcScore(List<Card> cards);
    String genealogyName(List<Card> cards);
}
