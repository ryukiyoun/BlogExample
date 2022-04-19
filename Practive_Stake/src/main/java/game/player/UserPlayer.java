package game.player;

import game.card.Card;
import game.genealogy.Genealogy;
import game.genealogy.StakeGenealogy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserPlayer implements Player{
    private static final Genealogy stakeGenealogy = new StakeGenealogy();

    private final String name;
    private final List<Card> hand;
    private final List<Card> bestHand;
    private int score;

    public UserPlayer(String name) {
        this.hand = new ArrayList<>();
        this.bestHand = new ArrayList<>();
        this.name = name;
    }

    private void showHands(){
        System.out.println("----------------플레이어 패---------------");
        for (Card card : hand) System.out.println(card.toString());
    }

    private void selectBestHand(Scanner sc){
        System.out.println("----------------카드 선택---------------");

        for(int i=0; i<2; i++) {
            int index = Integer.parseInt(sc.nextLine()) - 1;
            index = index < 0 || index > hand.size() - 1 ? 0 : index;
            bestHand.add(hand.get(index));
        }
    }

    @Override
    public void receiveCard(Card card) {
        hand.add(card);
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void openHand() {
        Collections.sort(hand);

        showHands();

        Scanner sc = new Scanner(System.in);
        selectBestHand(sc);

        score = stakeGenealogy.calcScore(bestHand);
        hand.clear();
    }

    @Override
    public String toString() {
        return name + "\n" +
                bestHand.get(0).toString() + "\n" +
                bestHand.get(1).toString() + "\n" +
                stakeGenealogy.genealogyName(bestHand);
    }
}
