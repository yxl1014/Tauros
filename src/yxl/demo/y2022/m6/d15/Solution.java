package yxl.demo.y2022.m6.d15;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);//对数组进行排序
        int len = nums.length;//获取数组的长度
        int left = 0;//左边界
        int right = nums[len - 1] - nums[0];//有边界
        while (left < right) {//若左边界等于又边界，那么这个left就是他第k个对数距离
            int mid = (left + right) / 2;//获取最大对数值和最小对数值得中间值
            int count = countLessEquals(nums, mid);//获取这个0到这个中间值对数的个数
            if (count < k) {//若小于这个数量，则折半查找
                // 如果小于等于 mid 的个数严格小于 k 个，说明 mid 太小了
                // 下一轮搜索区间为 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间为 [left..mid]
                right = mid;
            }
        }
        return left;
    }

    /**
     * 统计距离（数值之差的绝对值）小于等于 threshold 的个数
     *
     * @param nums
     * @param threshold
     * @return
     */
    private int countLessEquals(int[] nums, int threshold) {
        int count = 0;//对数的个数
        int len = nums.length;//数组的长度
        for (int left = 0, right = 0; right < len; right++) {//滑动窗口移动
            while (nums[right] - nums[left] > threshold) {//若大于这个数，因为数组是有序的，所以right右移还是比这个数大，所以left右移
                left++;
            }
            count += right - left;//通过排列组合获取对数的个数，两个数是对数组合就为1,三个数时就为2
        }
        return count;//返回这个区间的个数
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestDistancePair(new int[]{2,3, 6, 8, 10, 12, 16}, 4));
    }
}
