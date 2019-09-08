package com.example.algorithms.sort;

public class SelectionSort {

    public static Integer[] defaultSort(Integer[] numbers){
        if(numbers.length <= 1){
            return numbers;
        }
        for(int i =0;i<numbers.length-1;i++){
            int min = i;
            int minNum = numbers[i];
            for(int j = i+1;j<numbers.length;j++){
                if(numbers[j] < numbers[min]){
                    min = j;
                    minNum = numbers[j];
                }
            }
            if(min != i){
                numbers[min] = numbers[i];
                numbers[i] = minNum;
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        Integer [] numbers = {5,2,4,6,1,3};
        System.out.print("排序前:");
        for (Integer num: numbers) {
            System.out.print(" "+num);
        }
        System.out.println();
        numbers = SelectionSort.defaultSort(numbers);
        System.out.print("排序后:");
        for (Integer num: numbers) {
            System.out.print(" "+num);
        }
    }
}
