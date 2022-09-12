package yxl.demo.y2022.m9.d12;

/**
 * @author yxl
 * @date: 2022/9/12 上午11:58
 */
public class Solution {

    /*
    * 执行用时：
1 ms
, 在所有 Java 提交中击败了
81.80%
的用户
内存消耗：
39.4 MB
, 在所有 Java 提交中击败了
42.93%
的用户*/
    public int specialArray(int[] nums) {
        int x = -1;
        for (int i = 0; i <= nums.length; i++) {
            int len = 0;
            for (int ii : nums) {
                if (ii >= i) {
                    len++;
                }
            }
            if (len == i) {
                x = i;
                break;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().specialArray(new int[]{3,6,7,7,0}));
    }
}
