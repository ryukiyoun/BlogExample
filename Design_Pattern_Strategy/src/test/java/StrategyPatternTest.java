import Context.User;
import Strategy.KGamePoint;
import Strategy.PGamePoint;
import org.junit.Test;

public class StrategyPatternTest {
    @Test
    public void StrategyPatternPointTest() {
        User user1 = new User();

        for (int i = 0; i < 10; i++) {
            int value = (int) (Math.random() * 10);

            if (value % 3 == 0)
                user1.setStrategy(new PGamePoint.JumboPGamePoint());
            else
                user1.setStrategy(new PGamePoint.NormalPGamePoint());

            user1.appendPoint(value);
        }

        user1.printPointHistory();
    }

    @Test
    public void StrategyPatternKPointTest() {
        User user1 = new User();

        for (int i = 0; i < 10; i++) {
            int value = (int)(Math.random() * 10);

            if(value == 0)
                user1.setStrategy(new KGamePoint.NormalKGamePoint());
            else if (value % 3 == 0)
                user1.setStrategy(new PGamePoint.JumboPGamePoint());
            else
                user1.setStrategy(new PGamePoint.NormalPGamePoint());

            user1.appendPoint(value);
        }

        user1.printPointHistory();
    }
}
