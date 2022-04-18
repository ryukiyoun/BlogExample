package game;

import game.carddeck.CardDeck;
import game.carddeck.StakeCardDeck;
import game.dealer.Dealer;
import game.dealer.StakeDealer;
import game.player.Player;
import game.player.StakePlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private static final int PLAYER_CARD_COUNT = 3;

    public static void main(String[] args){
        CardDeck deck = new StakeCardDeck();
        Dealer dealer = new StakeDealer(deck);

        dealer.shuffleCardDeck();

        StakePlayer player1 = new StakePlayer("홍길동");
        StakePlayer player2 = new StakePlayer("도둑놈");
        StakePlayer player3 = new StakePlayer("명탐정");
        StakePlayer player4 = new StakePlayer("갈비찜");

        List<StakePlayer> players = new ArrayList<>(List.of(player1, player2, player3, player4));

        for(int i=0; i<PLAYER_CARD_COUNT; i++)
            dealer.drawCard(players.toArray(Player[]::new));

        player1.openHand();
        player2.openHand();
        player3.openHand();
        player4.openHand();

        players.sort(Collections.reverseOrder());

        System.out.println("----------------" + "최종 승자" + "---------------");
        System.out.println(players.get(0).toString());
    }
}
