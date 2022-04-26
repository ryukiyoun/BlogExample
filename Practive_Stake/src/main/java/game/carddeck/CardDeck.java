package game.carddeck;

import game.card.Card;

public interface CardDeck {
    void deckShuffle();
    Card handOutCard();
}
