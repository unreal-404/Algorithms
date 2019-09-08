package com.example.algorithms.sort;

public class MergeSort {
    //原始归并排序
    public static Integer[] defaultSort(Integer[] numbers,Integer prevIndex,Integer lastIndex){
        if(prevIndex < lastIndex){
            Integer middleIndex = (prevIndex + lastIndex)/2;
            defaultSort(numbers,prevIndex,middleIndex);
            defaultSort(numbers,middleIndex+1,lastIndex);
            merge(numbers,prevIndex,middleIndex,lastIndex);
        }
        return numbers;
    }

    private static Integer[] merge(Integer[] numbers,Integer prevIndex,Integer middleIndex,Integer lastIndex){
        Integer leftLength = middleIndex - prevIndex + 1;
        Integer rightLength = lastIndex - middleIndex;
        Integer[] arrayLeft = new Integer[leftLength];
        Integer[] arrayRight = new Integer[rightLength];
        for(int i = 0 ;i < arrayLeft.length;i++){
            arrayLeft[i] = numbers[prevIndex+i];
        }
        for(int j = 0; j < arrayRight.length;j++){
            arrayRight[j] = numbers[middleIndex+j+1];
        }
        int i=0,j=0;
        for(int k = prevIndex;k <= lastIndex;k++ ){
            if(i == arrayLeft.length){
                numbers[k] = arrayRight[j];
                j++;
                continue;
            }
            if(j == arrayRight.length){
                numbers[k] = arrayLeft[i];
                i++;
                continue;
            }
            if(arrayLeft[i] <= arrayRight[j]){
                numbers[k] = arrayLeft[i];
                i++ ;
            }else{
                numbers[k] = arrayRight[j];
                j++;
            }
        }
        return numbers;
    }
    //归并排序嵌套插入排序，节约空间开销
    public static Integer[] mergeSortByInsert(Integer[] numbers,Integer prevIndex,Integer lastIndex){
        if(prevIndex < lastIndex){
            Integer middleIndex = (prevIndex + lastIndex)/2;
            mergeSortByInsert(numbers,prevIndex,middleIndex);
            mergeSortByInsert(numbers,middleIndex+1,lastIndex);
            insert(numbers,prevIndex,middleIndex,lastIndex);
        }
        return numbers;
    }

    private static Integer[] insert(Integer[] numbers,Integer prevIndex,Integer middleIndex,Integer lastIndex){
        if (lastIndex - prevIndex <= 0){
            return numbers;
        }
        for(int i = middleIndex+1;i<=lastIndex;i++){
            Integer temp = numbers[i];
            int currentIndex = i;
            while(currentIndex > prevIndex && temp < numbers[currentIndex-1]){
                numbers[currentIndex] = numbers[currentIndex - 1];
                currentIndex--;
            }
            numbers[currentIndex] = temp;

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
        numbers = mergeSortByInsert(numbers,0,numbers.length-1);
        System.out.print("排序后:");
        for (Integer num: numbers) {
            System.out.print(" "+num);
        }
    }
}
