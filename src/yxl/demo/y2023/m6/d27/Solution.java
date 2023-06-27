package yxl.demo.y2023.m6.d27;

public class Solution {
    public int maximumSum(int[] arr) {
        //这是一个滑动窗口
        //dp0代表前面没有删除的所有子数组和的最大值
        //dp1代表删除一次的最大值
        //res是这两种情况的大的那个
        int dp0 = arr[0], dp1 = 0, res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //删除一次分两种情况
            //1、删除之前的数
            //那么就是dp1+这次这个数
            //2、删除最新的这个数
            //那么就把之前没删的最大值拿来
            //两种情况做比较 就是删除一次的最大值
            dp1 = Math.max(dp0, dp1 + arr[i]);
            //没删除按道理说直接加上最新的数就行
            //但是因为要最大值，所以也有两种情况
            //1、如果之前的最大值是负的
            //那么前面的数就不要了，直接从0开始
            //2、如果之前的最大值不是负的
            //那么就用最大值然后加上最新的数就可以了
            dp0 = Math.max(dp0, 0) + arr[i];
            //最后比较这原本的res和这两种情况的最大值
            res = Math.max(res, Math.max(dp0, dp1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSum(new int[]{1,-2,0,3}));
    }
}
