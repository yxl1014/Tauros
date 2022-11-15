package yxl.demo.y2022.m11.d15;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yxl
 * @date 2022/11/15 下午2:05
 */
public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int sum = 0;
        int size = 0;
        int len = boxTypes.length;
        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        for (int i = 0; i < truckSize; ) {
            if (size >= len)
                break;
            if (boxTypes[size][0] != 0) {
                boxTypes[size][0]--;
                sum += boxTypes[size][1];
                i++;
            } else {
                size++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
    }
}
