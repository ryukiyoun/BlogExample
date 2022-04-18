package game.card;

public class Card implements Comparable<Card>{
    private final CardType tag;
    private final int number;

    public Card(CardType tag, int number) {
        this.tag = tag;
        this.number = number;
    }

    public CardType getTag() {
        return tag;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "카트 타입 : " + tag.toString() + "카드 숫자 : " + number;
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.number, o.number);
    }
}
