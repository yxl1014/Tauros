package yxl.demo.y2023.m3.d23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yxl
 * @date 2023/3/23 上午11:10
 */
public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        int len = l.length;
        for (int i = 0; i < len; i++) {
            int size = r[i] - l[i]+1;
            int[] t = new int[size];
            System.arraycopy(nums, l[i], t, 0, size);
            Arrays.sort(t);
            int x = t[1] - t[0];
            boolean flag = true;
            for (int j = 0; j < size - 1; j++) {
                if (t[j + 1] - t[j] != x) {
                    flag = false;
                    break;
                }
            }
            list.add(flag);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkArithmeticSubarrays(new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5}));
    }
}
