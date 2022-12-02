package yxl.demo.y2022.m12.d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yxl
 * @date 2022/12/2 下午2:31
 */
public class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] result = new int[len];
        List<Integer> box = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (boxes.charAt(i) == '1')
                box.add(i);
        }
        for(int i=0;i<len;i++){
            for (Integer ii:box){
                result[i]+=Math.abs(ii-i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().minOperations("001011")));
    }
}
