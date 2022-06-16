package yxl.demo.y2022.m6.d16;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findPairs(int[] nums, int k) {//因为set是不可重复的，所以若后面的值与之前的值想减等于k也不会重复
        Set<Integer> visited = new HashSet<>();//已经访问过的数据
        Set<Integer> res = new HashSet<>();//若两数想减=k则添加进去。最后他的size就是数对的数量
        for (int num : nums) {//遍历数组中所有的数
            if (visited.contains(num - k)) {// 若当前数-k 存在在这个set中 说明存在set数组中的数与当前数想减=k，讲之前的数存入res中
                res.add(num - k);
            }
            if (visited.contains(num + k)) {//同上
                res.add(num);
            }
            visited.add(num);//将此树添加进已访问过数据的set
        }
        return res.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
    }
}
