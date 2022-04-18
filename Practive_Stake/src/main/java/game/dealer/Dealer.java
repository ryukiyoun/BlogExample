package game.dealer;

import game.player.Player;

public interface Dealer {
    void shuffleCardDeck();
    void drawCard(Player... players);
}
