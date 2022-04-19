package game.dealer;

import game.player.Player;

import java.util.List;

public interface Dealer {
    void shuffleCardDeck();
    void drawCard(List<Player> players);
    List<Player> getWinner(List<Player> players);
}
