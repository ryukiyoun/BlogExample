package game.card;

public class Card<T> implements Comparable<Card<?>> {
    protected int number;
    protected T type;

    public Card(int number, T type){
        this.number = number;
        this.type = type;
    }

    public boolean isSameNumber(Card<?> card){
        return this.number == card.number;
    }

    public int getNumber(){
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
