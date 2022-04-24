package game.card;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CardTest {
    private Card<StakeCardType> fixture = new Card<StakeCardType>() {
        @Override
        public StakeCardType getType() {
            return StakeCardType.NORMAL;
        }

        @Override
        public int getNumber() {
            return 100;
        }
    };

    @Test
    public void testGetType() {
        //when, then
        assertThat(fixture.getType(), is(StakeCardType.NORMAL));
    }

    @Test
    public void testGetNumber() {
        //when, then
        assertThat(fixture.getNumber(), is(100));
    }
}