package game.carddeck;

import game.card.Card;
import game.card.StakeCard;
import game.card.StakeCardType;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class StakeCardDeck implements CardDeck {
    private static final int CARD_COUNT = 20;
    private static final Card<StakeCardType>[] cards = new StakeCard[] {
            new StakeCard(1, StakeCardType.NORMAL),
            new StakeCard(2, StakeCardType.NORMAL),
            new StakeCard(3, StakeCardType.NORMAL),
            new StakeCard(4, StakeCardType.NORMAL),
            new StakeCard(5, StakeCardType.NORMAL),
            new StakeCard(6, StakeCardType.NORMAL),
            new StakeCard(7, StakeCardType.NORMAL),
            new StakeCard(8, StakeCardType.NORMAL),
            new StakeCard(9, StakeCardType.NORMAL),
            new StakeCard(10, StakeCardType.NORMAL),
            new StakeCard(1, StakeCardType.SKETCH),
            new StakeCard(2, StakeCardType.NORMAL),
            new StakeCard(3, StakeCardType.SKETCH),
            new StakeCard(4, StakeCardType.NORMAL),
            new StakeCard(5, StakeCardType.NORMAL),
            new StakeCard(6, StakeCardType.NORMAL),
            new StakeCard(7, StakeCardType.NORMAL),
            new StakeCard(8, StakeCardType.SKETCH),
            new StakeCard(9, StakeCardType.NORMAL),
            new StakeCard(10, StakeCardType.NORMAL),
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
