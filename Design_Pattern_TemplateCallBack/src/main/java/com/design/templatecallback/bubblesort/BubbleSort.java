package com.design.templatecallback.bubblesort;

public class BubbleSort {

    public int[] AscSort(int numCount){
        int[] numbers = new int[numCount];
        for(int i=0; i<numCount; i++) {
            numbers[i] = (int)(Math.random() * 100);
        }

        int length = numbers.length, temp;

        for(int i=length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(numbers[j] > numbers[j+1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        return numbers;
    }

    public int[] DescReverseSort(int numCount){
        int[] numbers = new int[numCount];
        for(int i=0; i<numCount; i++) {
            numbers[i] = (int)(Math.random() * 100);
        }

        int length = numbers.length, temp;

        for(int i=length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(numbers[j] < numbers[j+1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        return numbers;
    }
}
