package com.design.templatecallback;

import com.design.templatecallback.callback.SortCallBack;
import com.design.templatecallback.template.SortTemplate;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TemplateCallbackTest {

    @Test
    public void BubbleSortLambdaTest(){
        SortTemplate template = new SortTemplate();

        int[] sort = template.Sort(10, (numbers, compareIndex) -> {
            int temp;

            if (numbers[compareIndex] > numbers[compareIndex + 1]) {
                temp = numbers[compareIndex];
                numbers[compareIndex] = numbers[compareIndex + 1];
                numbers[compareIndex + 1] = temp;
            }

            return numbers;
        });

        Integer[] newArray = Arrays.stream(Arrays.copyOf(sort, sort.length)).boxed().toArray(Integer[]::new);
        Arrays.sort(newArray);

        assertThat(newArray, is(sort));
    }

    @Test
    public void BubbleSortNewTest(){
        SortTemplate template = new SortTemplate();

        int[] sort = template.Sort(10, new SortCallBack() {
            @Override
            public int[] Sort(int[] numbers, int compareIndex) {
                int temp;

                if (numbers[compareIndex] > numbers[compareIndex + 1]) {
                    temp = numbers[compareIndex];
                    numbers[compareIndex] = numbers[compareIndex + 1];
                    numbers[compareIndex + 1] = temp;
                }

                return numbers;
            }
        });

        Integer[] newArray = Arrays.stream(Arrays.copyOf(sort, sort.length)).boxed().toArray(Integer[]::new);
        Arrays.sort(newArray);

        assertThat(newArray, is(sort));
    }

    @Test
    public void BubbleSortReverseNewTest(){
        SortTemplate template = new SortTemplate();

        int[] sort = template.Sort(10, new SortCallBack() {
            @Override
            public int[] Sort(int[] numbers, int compareIndex) {
                int temp;

                if (numbers[compareIndex] < numbers[compareIndex + 1]) {
                    temp = numbers[compareIndex];
                    numbers[compareIndex] = numbers[compareIndex + 1];
                    numbers[compareIndex + 1] = temp;
                }

                return numbers;
            }
        });

        Integer[] newArray = Arrays.stream(Arrays.copyOf(sort, sort.length)).boxed().toArray(Integer[]::new);
        Arrays.sort(newArray, Collections.reverseOrder());

        assertThat(newArray, is(sort));
    }

    @Test
    public void BubbleSortReverseLambdaTest(){
        SortTemplate template = new SortTemplate();

        int[] sort = template.Sort(10, (numbers, compareIndex) -> {
            int temp;

            if (numbers[compareIndex] < numbers[compareIndex + 1]) {
                temp = numbers[compareIndex];
                numbers[compareIndex] = numbers[compareIndex + 1];
                numbers[compareIndex + 1] = temp;
            }

            return numbers;
        });

        Integer[] newArray = Arrays.stream(Arrays.copyOf(sort, sort.length)).boxed().toArray(Integer[]::new);
        Arrays.sort(newArray, Collections.reverseOrder());

        assertThat(newArray, is(sort));
    }
}
