package game;

import game.carddeck.CardDeck;
import game.carddeck.StakeCardDeck;
import game.dealer.Dealer;
import game.dealer.StakeDealer;
import game.player.Player;
import game.player.StakeAIPlayer;
import game.player.UserPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int PLAYER_CARD_COUNT;
    private int AI_PLAYER_COUNT;

    public void playGame(){
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------" + "콘솔 섯다" + "---------------");

        selectStakeType(sc);
        selectAIPlayer(sc);

        List<Player> players = makeAIPlayer();

        players.add(initPlayer(sc));

        CardDeck deck = new StakeCardDeck();
        Dealer dealer = new StakeDealer(deck);

        dealer.shuffleCardDeck();

        for(int i=0; i<PLAYER_CARD_COUNT; i++)
            dealer.drawCard(players);

        for(Player player : players)
            player.openHand();

        System.out.println("최종 우승자");
        for(Player player : dealer.getWinner(players))
            System.out.println(player.toString());
    }

    private void selectStakeType(Scanner sc){
        System.out.println("2섯, 3섯 선택 -> 2:2섯   3:3섯");
        PLAYER_CARD_COUNT = Integer.parseInt(sc.nextLine());
        PLAYER_CARD_COUNT = PLAYER_CARD_COUNT != 3 ? 2 : 3;
    }

    private void selectAIPlayer(Scanner sc){
        System.out.println("플레이할 AI 수 선택(최대 3명)");
        AI_PLAYER_COUNT = Integer.parseInt(sc.nextLine());
        AI_PLAYER_COUNT = AI_PLAYER_COUNT > 0 && AI_PLAYER_COUNT < 4 ? AI_PLAYER_COUNT : 3;
    }

    private List<Player> makeAIPlayer(){
        List<Player> players = new ArrayList<>();

        for(int i=0; i<AI_PLAYER_COUNT; i++)
            players.add(new StakeAIPlayer("AI-" + i));

        return players;
    }

    private Player initPlayer(Scanner sc){
        System.out.println("플레이어 이름 입력");
        return new UserPlayer(sc.nextLine());
    }
}
