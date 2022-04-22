package game.dealer;

import game.card.Card;
import game.carddeck.CardDeck;
import game.player.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

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
    public Card<?> drawCard() {
        return stakeCardDeck.handOutCard();
    }

    @Override
    public List<Player> getWinner(List<Player> players) {
        return players.stream()
                .collect(groupingBy(Player::getScore))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getKey))
                .orElseThrow(() -> new RuntimeException("Not Found Winner"))
                .getValue();
    }
}
