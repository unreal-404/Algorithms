package com.example.algorithms.question;

public class MaxArraySum {
    /**
     * 查找最大的数组和起始结束下标
     * @param array        被搜索的数组
     * @param min          起始下标
     * @param mid          中位下标
     * @param max          结束下标
     * @return             Integer[最大起始下标，最大结束下标，最大值和]
     */
    public static Integer[] findMaxCrossSubarray(Integer[] array,Integer min,Integer mid,Integer max){
        int leftMaxIndex = -10000000;           //模拟负无穷大
        int leftSum = 0;
        int rightMaxIndex = -10000000;          //模拟负无穷大
        int rightSum = 0;
        int currentSum = 0;
        for(int i = mid; i>=min; i--){
            currentSum = currentSum + array[i];
            if(currentSum > leftSum){
                leftSum = currentSum;
                leftMaxIndex = i;
            }
        }
        currentSum = 0;
        for(int j = mid+1; j<=max; j++){
            currentSum = currentSum + array[j];
            if(currentSum > rightSum){
                rightSum = currentSum;
                rightMaxIndex = j;
            }
        }
        return new Integer[]{leftMaxIndex,rightMaxIndex,leftSum+rightSum};
    }
}
