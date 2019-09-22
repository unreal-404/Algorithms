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
    /**
     * 查询最大数组和，二分法
     * @param array    数组
     * @param min      起始下标
     * @param max      结束下标
     * @return         Integer[最大起始下标，最大结束下标，最大值和]
     */
    public static Integer[] findMaxSubarray(Integer[] array,Integer min,Integer max){
        if(min == max){
            return new Integer[]{min,max,array[min]};
        }else{
            Integer mid = (min+max)/2;
            Integer[] leftSum = findMaxSubarray(array, min, mid);
            Integer[] rightSum = findMaxSubarray(array,mid+1,max);
            Integer[] crossSum = findMaxCrossSubarray(array, min, mid, max);
            if(leftSum[2] >= rightSum[2] && leftSum[2] >= crossSum[2]){
                return leftSum;
            }else if(rightSum[2] >= leftSum[2] && rightSum[2] >= crossSum[2]){
                return rightSum;
            }else{
                return crossSum;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        Integer[] result = MaxArraySum.findMaxSubarray(array, 0, array.length-1);
        System.out.println("最大数组和为:"+result[2]+",最大数组和起始下标为:"+result[0]+",结束下标为:"+result[1]);
    }
}
