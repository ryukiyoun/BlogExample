package game.player;

import game.card.Card;
import game.genealogy.Genealogy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserPlayer implements Player {
    private final Genealogy genealogy;

    private final String name;
    private final List<Card<?>> hand;
    private List<Card<?>> bestHand;

    public UserPlayer(String name, Genealogy genealogy) {
        this.hand = new ArrayList<>();
        this.bestHand = new ArrayList<>();
        this.name = name;
        this.genealogy = genealogy;
    }

    private void showHands(){
        System.out.println("----------------플레이어 패---------------");
        for (Card<?> card : hand) System.out.println(card.toString());
    }

    private List<Card<?>> chooseCards(){
        System.out.println("----------------카드 선택---------------");
        Scanner sc = new Scanner(System.in);

        List<Card<?>> list = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int index = hand.size() != 2 ? Integer.parseInt(sc.nextLine()) - 1 : i;
            index = index < 0 || index > hand.size() - 1 ? 0 : index;
            list.add(hand.get(index));
        }

        return list;
    }

    @Override
    public void receiveCard(Card<?> card) {
        hand.add(card);
    }

    @Override
    public int getScore() {
        if(bestHand.isEmpty())
            throw new RuntimeException("Not Select Best Hand");

        return genealogy.calcScore(bestHand);
    }

    @Override
    public void selectBestCards() {
        hand.sort(Comparator.comparingInt(Card::getNumber));

        showHands();

        bestHand = chooseCards();

        hand.clear();
    }

    @Override
    public String toString() {
        return this.name + "\n" +
                bestHand.get(0) + "\n" +
                bestHand.get(1) + "\n" +
                genealogy.genealogyName(bestHand);
    }
}
