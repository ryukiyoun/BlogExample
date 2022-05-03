package game.genealogy;

import game.card.Card;

import java.util.List;

public interface Genealogy<T extends Card> {
    int calcScore(List<T> cards);
    String genealogyName(List<T> cards);
}
