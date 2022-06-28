package yxl.demo.y2022.m6.d26;

import java.util.*;

public class Solution {
    private TreeMap<Double, Integer> map = new TreeMap<>();

    public Solution(int n, int[] blacklist) {
        List<Integer> list = new ArrayList<>();
        for (int j : blacklist) {
            list.add(j);
        }
        int weight = n - blacklist.length;
        for (int i = 0; i < n; i++) {
            if (list.contains(i)) {
                continue;
            }
            map.put(1.0 / weight + (map.size() != 0 ? map.lastKey() : 0), i);
        }
    }

    public int pick() {
        Double d = Math.random();
        SortedMap<Double, Integer>  tailMap = this.map.tailMap(d, false);
        return this.map.get(tailMap.firstKey());
    }

    public static void main(String[] args) {
        Solution s=new Solution(7, new int[]{2, 3, 5});
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
    }
}
