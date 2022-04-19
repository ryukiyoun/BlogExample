package game.genealogy;

import game.card.Card;

import java.util.List;

public interface Genealogy {
    List<Card> selectBestHand(List<Card> hand);
    int calcScore(List<Card> cards);
    String genealogyName(List<Card> cards);
}
