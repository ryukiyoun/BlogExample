package game;

public class Game {
    public static void main(String[] args){
        CardDeck deck = new CardDeck();

        for(int i=0; i<10; i++)
            System.out.println(deck.getCard().toString());
    }
}
