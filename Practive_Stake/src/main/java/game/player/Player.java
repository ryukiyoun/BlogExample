package game.player;

import game.card.Card;

public interface Player {
    void getACard(Card card);
    void openHand();
    void clearHand();
}
