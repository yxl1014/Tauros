package yxl.demo.y2023.m2.d11;

import java.util.Arrays;

/**
 * @author yxl
 * @date 2023/2/11 下午10:47
 */
public class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[0] + amount[1] <= amount[2]) {
            return amount[2];
        } else {
            int t = amount[1] + amount[0] - amount[2];
            return (t + 1) / 2 + amount[2];
        }
    }
}
