package yxl.demo.y2022.m12.d20;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yxl
 * @date 2022/12/20 下午3:13
 */
public class Solution {
    /**
     * 使用二分查找法
     * 作者：Tizzi
     * 链接：https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/solutions/2026576/javac-er-fen-cha-zhao-by-tizzi-t04d/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums 数组
     * @param op   操作次数
     * @return 操作后最大数
     */
    public int minimumSize(int[] nums, int op) {
        //获取左边界和右边界
        int l = 1, r = Arrays.stream(nums).max().getAsInt();
        //开始二分查找
        while (l < r) {
            //获取中间值
            int mid = (l + r) / 2;
            //能则右边界左移
            if (check(mid, nums, op)) r = mid;
            //否则左边右移
            else l = mid + 1;
        }
        return r;
    }

    /**
     * @param mid  中间
     * @param nums 数组
     * @param op   操作数
     * @return 是否能在操作数内让所有数都小于等于mid
     */
    boolean check(int mid, int[] nums, int op) {
        //遍历所有数
        //首先对于一个数x若小于等于mid,那么不用划分。
        //若大于x,那么需要进行划分。
        //当x位于[mid+1,2∗mid]需要花费一次，
        //位于[2∗mid+1,3∗mid]需要花费2次。
        //那么可以看出每次的次数为(x−1)/mid。
        for (int x : nums) op -= (x - 1) / mid;
        return op >= 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSize(new int[]{9}, 2));
    }
}
