package yxl.demo.y2023.m6.d19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int[][] dfs = new int[3][nums.length];
        int i = -1, j = -1, k = -1;
        for (Integer n : nums) {
            switch (n % 3) {
                case 0: {
                    dfs[0][++i] = n;
                    break;
                }
                case 1: {
                    dfs[1][++j] = n;
                    break;
                }
                case 2: {
                    dfs[2][++k] = n;
                    break;
                }
            }
        }
        int sum = 0;
        while (i >= 0) {
            sum += dfs[0][i];
        }
        while (j >= 0 && k >= 0) {
            sum += dfs[1][j--] + dfs[2][k--];
        }
        return sum;
    }

    int maxSumDivThree_V2(int[] nums) {
        //三位记录 当前 能被整除 余1 余2的最大数
        int[] remainder = new int[3];
        for (int num : nums) {
            int a, b, c;
            //这一步是最新的数加上这三位数加上的最大值
            a = remainder[0] + num;
            b = remainder[1] + num;
            c = remainder[2] + num;
            //讲最新的数和之前最大的数做比较 大的存到对阴的记录最大值的里面
            //举个例子说  假设现在这个 a 是 10  那么算出来余1 那么就应该和 在下标 为 1的原来的值做比较大的放里面
            //那么问题来饿了 按常理说应该每次新的值都是最大值 为什么要比，有一种可能 abc都是余1 那么就需要比较了
            //通俗易懂的讲 每个位置的最大值都在变 然后加上新的值取余 应该在那个位置 就改变哪个位置的值 依次类推
            remainder[a % 3] = Math.max(remainder[a % 3], a);
            remainder[b % 3] = Math.max(remainder[b % 3], b);
            remainder[c % 3] = Math.max(remainder[c % 3], c);
        }
        return remainder[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumDivThree_V2(new int[]{1, 2, 3, 4, 4}));
    }
}
