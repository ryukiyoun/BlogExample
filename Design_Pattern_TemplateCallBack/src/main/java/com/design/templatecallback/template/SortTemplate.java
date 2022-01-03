package com.design.templatecallback.template;

import com.design.templatecallback.callback.SortCallBack;

public class SortTemplate {

    public int[] Sort(int numCount, SortCallBack callBack){
        int[] numbers = new int[numCount];
        for(int i=0; i<numCount; i++) {
            numbers[i] = (int)(Math.random() * 100);
        }

        for(int i=numbers.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                callBack.Sort(numbers, j);
            }
        }

        return numbers;
    }
}
