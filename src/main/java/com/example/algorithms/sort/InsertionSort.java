package com.example.algorithms.sort;

public class InsertionSort {
//    插入排序(升序)
    public static Integer[] defaultSort(Integer[] numbers){
        if(numbers.length <= 1){
            return  numbers;
        }
        for(int i = 1;i < numbers.length;i++){
            Integer temp = numbers[i];
            int j = i - 1;
            while(j >= 0 && numbers[j] > temp){
                numbers[j+1] = numbers[j];
                j = j - 1;
            }
            numbers[j+1] = temp;
        }
        return numbers;
    }

    public static Integer[] SortByType(Integer[] numbers,OrderType type){
        if(numbers.length <= 1){
            return  numbers;
        }
        for(int i = 1;i < numbers.length;i++){
            Integer temp = numbers[i];
            int j = i - 1;
            if(type == OrderType.ASC){
                while(j >= 0 && numbers[j] > temp){
                    numbers[j+1] = numbers[j];
                    j = j - 1;
                }
            }else{
                while(j >= 0 && numbers[j] < temp){
                    numbers[j+1] = numbers[j];
                    j = j - 1;
                }
            }
            numbers[j+1] = temp;
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
        numbers = InsertionSort.SortByType(numbers,OrderType.ASC);
        System.out.print("排序后:");
        for (Integer num: numbers) {
            System.out.print(" "+num);
        }
    }
}
