package game.card;

public class Card implements Comparable<Card>{
    private final CardType type;
    private final int number;

    public Card(CardType tag, int number) {
        this.type = tag;
        this.number = number;
    }

    public CardType getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "카트 타입 : " + type.toString() + "카드 숫자 : " + number;
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.number, o.number);
    }
}
