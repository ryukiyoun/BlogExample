package game.card;

public interface Card {
    <T> boolean isSameType(T type);
    int getNumber();
}
