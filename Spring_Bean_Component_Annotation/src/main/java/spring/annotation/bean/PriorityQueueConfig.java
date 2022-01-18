package spring.annotation.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.PriorityQueue;

@Configuration
public class PriorityQueueConfig {

    @Bean(name = "sortedQueueBean")
    public PriorityQueue<Integer> sortedQueue(){
        return new PriorityQueue<>();
    }

    @Bean
    public PriorityQueue<Integer> sortedSetNumQueue(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(1);
        queue.offer(15);
        queue.offer(21);
        queue.offer(163);

        return queue;
    }
}
