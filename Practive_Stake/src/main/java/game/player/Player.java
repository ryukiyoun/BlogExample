package game.player;

import game.card.Card;

import java.util.List;

public interface Player {
    void receiveCard(Card card);
    void openHand();
    int getScore();
    List<Card> selectBestHand(List<Card> hand);
    String toString();
}
