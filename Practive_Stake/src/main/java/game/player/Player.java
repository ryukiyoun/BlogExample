package game.player;

import game.card.Card;

public interface Player {
    void receiveCard(Card<?> card);
    void selectBestCards();
    int getScore();
    String toString();
}
