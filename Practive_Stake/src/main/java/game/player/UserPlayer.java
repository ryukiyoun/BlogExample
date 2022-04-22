package game.player;

import game.card.Card;
import game.genealogy.Genealogy;
import game.genealogy.StakeGenealogy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserPlayer implements Player {
    private static final Genealogy stakeGenealogy = new StakeGenealogy();

    private final String name;
    private final List<Card<?>> hand;
    private List<Card<?>> bestHand;
    private int score;

    public UserPlayer(String name) {
        this.hand = new ArrayList<>();
        this.bestHand = new ArrayList<>();
        this.name = name;
    }

    private void showHands(){
        System.out.println("----------------플레이어 패---------------");
        for (Card<?> card : hand) System.out.println(card.toString());
    }

    @Override
    public void receiveCard(Card<?> card) {
        hand.add(card);
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void openHand() {
        hand.sort(Comparator.comparingInt(Card::getNumber));

        showHands();

        bestHand = selectBestHand(hand);

        score = stakeGenealogy.calcScore(bestHand);
        hand.clear();
    }

    @Override
    public List<Card<?>> selectBestHand(List<Card<?>> hand) {
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
    public String toString() {
        return this.name + "\n" +
                bestHand.get(0) + "\n" +
                bestHand.get(1) + "\n" +
                stakeGenealogy.genealogyName(bestHand);
    }
}
