package game.carddeck;

import game.card.Card;

public interface CardDeck {
    void deckShuffle();
    <T extends Card> T handOutCard();
}
