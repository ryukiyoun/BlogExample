package spring.annotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.annotation.component.Pen;
import spring.annotation.component.Product;

import java.util.PriorityQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BeanComponentTest {

    @Autowired
    private PriorityQueue<Integer> sortedQueueBean;

    @Autowired
    private PriorityQueue<Integer> sortedSetNumQueue;

    @Test
    public void BeanAnnotationQueueTest(){
        assertThat(sortedQueueBean, is(not(nullValue())));
        assertThat(sortedQueueBean, is(instanceOf(PriorityQueue.class)));
    }

    @Test
    public void BeanAnnotationNumberQueueTest(){
        assertThat(sortedSetNumQueue, is(not(nullValue())));
        assertThat(sortedSetNumQueue.size(), is(4));
        assertThat(sortedQueueBean, is(instanceOf(PriorityQueue.class)));
    }

    @Autowired
    private Product prod;

    @Autowired
    private Product prodP;

    @Test
    public void ComponentAnnotationProductTest(){
        assertThat(prod, is(not(nullValue())));
        assertThat(prod, is(instanceOf(Product.class)));
    }

    @Test
    public void ComponentAnnotationPenTest(){
        assertThat(prodP, is(not(nullValue())));
        assertThat(prodP.getName(), is("pen"));
        assertThat(prodP.getCount(), is(12));
        assertThat(((Pen)prodP).getLength(), is(20));
        assertThat(prodP, is(instanceOf(Pen.class)));
    }
}
