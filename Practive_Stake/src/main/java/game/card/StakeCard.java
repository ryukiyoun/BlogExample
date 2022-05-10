package game.card;

public class StakeCard extends Card<StakeCardType> {
    public StakeCard(int number, StakeCardType type) {
        super(number, type);
    }

    public boolean isGwang(){
        return super.type.equals(StakeCardType.SKETCH);
    }
}
