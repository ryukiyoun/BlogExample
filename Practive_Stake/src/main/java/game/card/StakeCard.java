package game.card;

public class StakeCard implements Card, Comparable<StakeCard>{
    private final StakeCardType type;
    private final int number;

    public StakeCard(StakeCardType tag, int number) {
        this.type = tag;
        this.number = number;
    }

    public boolean isGwang(){
        return this.type.equals(StakeCardType.SKETCH);
    }

    public boolean isSameCardNumber(StakeCard card){
        return this.number == card.number;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "카트 타입 : " + type.toString() + "카드 숫자 : " + number;
    }

    @Override
    public int compareTo(StakeCard o) {
        return Integer.compare(this.number, o.number);
    }
}
