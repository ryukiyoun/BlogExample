package game;

import game.card.StakeCard;
import game.carddeck.CardDeck;
import game.carddeck.StakeCardDeck;
import game.combination.CombinationGenerator;
import game.dealer.Dealer;
import game.dealer.StakeDealer;
import game.genealogy.StakeGenealogy;
import game.player.StakeAIPlayer;
import game.player.Player;
import game.player.StakeUserPlayer;

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

        List<Player<StakeCard>> players = makeAIPlayer();

        players.add(initPlayer(sc));

        CardDeck deck = new StakeCardDeck();
        Dealer dealer = new StakeDealer(deck);

        dealer.shuffleCardDeck();

        handOutCards2Player(players, dealer);

        playerHandOpen(players);

        showWinner(players, dealer);
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

    private List<Player<StakeCard>> makeAIPlayer(){
        List<Player<StakeCard>> players = new ArrayList<>();

        for(int i=0; i<AI_PLAYER_COUNT; i++)
            players.add(new StakeAIPlayer("AI-" + i, new StakeGenealogy(), new CombinationGenerator<>()));

        return players;
    }

    private Player<StakeCard> initPlayer(Scanner sc){
        System.out.println("플레이어 이름 입력");
        return new StakeUserPlayer(sc.nextLine(), new StakeGenealogy());
    }

    private void handOutCards2Player(List<Player<StakeCard>> players, Dealer dealer){
        for(int i=0; i<PLAYER_CARD_COUNT; i++) {
            for(Player<StakeCard> player : players)
                player.receiveCard(dealer.drawCard());
        }
    }

    private void playerHandOpen(List<Player<StakeCard>> players){
        for(Player<StakeCard> player : players)
            player.selectBestCards();
    }

    private void showWinner(List<Player<StakeCard>> players, Dealer dealer){
        System.out.println("최종 우승자");
        for(Player<StakeCard> player : dealer.getWinner(players))
            System.out.println(player.toString());
    }
}
