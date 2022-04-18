package game.genealogy;

import game.card.Card;

import java.util.List;

public interface Genealogy {
    Card[] selectBestHand(List<Card> hand);
    int calcScore(Card... cards);
    String handName(Card... cards);
}
