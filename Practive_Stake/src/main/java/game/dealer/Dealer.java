package game.dealer;

import game.card.Card;
import game.player.Player;

import java.util.List;

public interface Dealer {
    void shuffleCardDeck();
    Card drawCard();
    List<Player> getWinner(List<Player> players);
}
