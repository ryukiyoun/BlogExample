package game.carddeck;

import game.card.Card;
import game.card.StakeCard;
import game.card.StakeCardType;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class StakeCardDeck implements CardDeck {
    private static final int CARD_COUNT = 20;
    private static final Card[] cards = new StakeCard[] {
            new StakeCard(StakeCardType.NORMAL, 1),
            new StakeCard(StakeCardType.NORMAL, 2),
            new StakeCard(StakeCardType.NORMAL, 3),
            new StakeCard(StakeCardType.NORMAL, 4),
            new StakeCard(StakeCardType.NORMAL, 5),
            new StakeCard(StakeCardType.NORMAL, 6),
            new StakeCard(StakeCardType.NORMAL, 7),
            new StakeCard(StakeCardType.NORMAL, 8),
            new StakeCard(StakeCardType.NORMAL, 9),
            new StakeCard(StakeCardType.NORMAL, 10),
            new StakeCard(StakeCardType.SKETCH, 1),
            new StakeCard(StakeCardType.NORMAL, 2),
            new StakeCard(StakeCardType.SKETCH, 3),
            new StakeCard(StakeCardType.NORMAL, 4),
            new StakeCard(StakeCardType.NORMAL, 5),
            new StakeCard(StakeCardType.NORMAL, 6),
            new StakeCard(StakeCardType.NORMAL, 7),
            new StakeCard(StakeCardType.SKETCH, 8),
            new StakeCard(StakeCardType.NORMAL, 9),
            new StakeCard(StakeCardType.NORMAL, 10),
    };

    private final Stack<Integer> deckOrder;

    public StakeCardDeck() {
        deckOrder = new Stack<>();

        deckShuffle();
    }

    private int getRandomCardNumber(){
        return ThreadLocalRandom.current().nextInt(0, CARD_COUNT);
    }

    @Override
    public void deckShuffle(){
        deckOrder.clear();

        while (deckOrder.size() != CARD_COUNT){
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
