package yxl.demo.y2023.m2.d4;

import java.util.Arrays;

/**
 * @author yxl
 * @date 2023/2/4 下午4:29
 */
public class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);

        int r = 1;
        for(int coin : coins) {
            if(coin > r) { break; }
            r += coin;
        }

        return r;
    }
}
