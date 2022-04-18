package game;

public class Card {
    private final CardType tag;
    private final int number;

    public Card(CardType tag, int number) {
        this.tag = tag;
        this.number = number;
    }

    @Override
    public String toString() {
        return "카트 타입 : " + tag.toString() + "카드 숫자 : " + number;
    }
}
