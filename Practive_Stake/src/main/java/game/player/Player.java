package game.player;

import game.card.Card;

public interface Player<T extends Card> {
    void receiveCard(T card);
    void selectBestCards();
    int getScore();
    String toString();
}
