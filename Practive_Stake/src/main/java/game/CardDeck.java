package game;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class CardDeck {
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
    };

    private final Stack<Integer> deckOrder;

    public CardDeck() {
        deckOrder = new Stack<>();

        deckShuffle();
    }

    public void deckShuffle(){
        deckOrder.clear();

        while (deckOrder.size() != 20){
            int number = getRandomCardNumber();

            if(!deckOrder.contains(number))
                deckOrder.push(number);
        }
    }

    public Card getCard(){
        return cards[deckOrder.pop()];
    }

    public Integer getRandomCardNumber(){
        return ThreadLocalRandom.current().nextInt(0, CARD_COUNT);
    }

}
