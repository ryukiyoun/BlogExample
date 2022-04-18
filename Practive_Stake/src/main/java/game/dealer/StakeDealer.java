package game.dealer;

import game.carddeck.CardDeck;
import game.player.Player;

public class StakeDealer implements Dealer {
    private final CardDeck stakeCardDeck;

    public StakeDealer(CardDeck stakeCardDeck) {
        this.stakeCardDeck = stakeCardDeck;
    }

    @Override
    public void shuffleCardDeck() {
        this.stakeCardDeck.deckShuffle();
    }

    @Override
    public void drawCard(Player... players) {
        for(Player player : players)
            player.getACard(stakeCardDeck.handOutCard());
    }
}
