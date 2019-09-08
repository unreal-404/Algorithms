package com.example.algorithms.sort;

public class BubbleSort {
    /**
     * 冒泡排序
     * @param numbers
     * @return
     */
    public static Integer[] defaultSort(Integer[] numbers){
        Integer temp = 0;
        for(int i = 0;i<numbers.length-1;i++){
            for(int j = 1;j<numbers.length-i;j++){
                if(numbers[j-1] > numbers[j]){
                    temp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        Integer [] numbers = {5,2,4,6,1,3,9,7,8};
        System.out.print("排序前:");
        for (Integer num: numbers) {
            System.out.print(" "+num);
        }
        System.out.println();
        numbers = defaultSort(numbers);
        System.out.print("排序后:");
        for (Integer num: numbers) {
            System.out.print(" "+num);
        }
    }
}
