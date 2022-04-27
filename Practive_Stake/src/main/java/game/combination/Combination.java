package game.combination;

import java.util.List;
import java.util.Set;

public interface Combination<T> {
    Set<List<T>> generate(List<T> cards, int count);
}
