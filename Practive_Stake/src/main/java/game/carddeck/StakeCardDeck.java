package game.carddeck;

import game.card.Card;
import game.card.CardType;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class StakeCardDeck implements CardDeck {
    private static final int CARD_COUNT = 20;
    private static final Card[] cards = new Card[] {
            new Card(CardType.NORMAL, 1),
            new Card(CardType.NORMAL, 2),
            new Card(CardType.NORMAL, 3),
            new Card(CardType.NORMAL, 4),
            new Card(CardType.NORMAL, 5),
            new Card(CardType.NORMAL, 6),
            new Card(CardType.NORMAL, 7),
            new Card(CardType.NORMAL, 8),
            new Card(CardType.NORMAL, 9),
            new Card(CardType.NORMAL, 10),
            new Card(CardType.SKETCH, 1),
            new Card(CardType.NORMAL, 2),
            new Card(CardType.SKETCH, 3),
            new Card(CardType.NORMAL, 4),
            new Card(CardType.NORMAL, 5),
            new Card(CardType.NORMAL, 6),
            new Card(CardType.NORMAL, 7),
            new Card(CardType.SKETCH, 8),
            new Card(CardType.NORMAL, 9),
            new Card(CardType.NORMAL, 10),
    };

    private final Stack<Integer> deckOrder;

    public StakeCardDeck() {
        deckOrder = new Stack<>();

        deckShuffle();
    }

    private Integer getRandomCardNumber(){
        return ThreadLocalRandom.current().nextInt(0, CARD_COUNT);
    }

    @Override
    public void deckShuffle(){
        deckOrder.clear();

        while (deckOrder.size() != 20){
            int number = getRandomCardNumber();

            if(!deckOrder.contains(number))
                deckOrder.push(number);
        }
    }

    @Override
    public Card handOutCard(){
        return cards[deckOrder.pop()];
    }
}
