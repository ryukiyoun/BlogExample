package game.dealer;

import game.card.Card;
import game.player.Player;

import java.util.List;

public interface Dealer {
    void shuffleCardDeck();
    <T extends Card> T drawCard();
    <T extends Card> List<Player<T>> getWinner(List<Player<T>> players);
}
