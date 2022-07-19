package yxl.demo.y2022.m7.d19;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: yxl
 * @Date: 2022/7/19 10:16
 */
public class MyCalendarTwo {
    TreeMap<Integer, Integer> cnt;

    public MyCalendarTwo() {
        cnt = new TreeMap<Integer, Integer>();
    }

    //开始的时候+1，结束的时候-1，最后累加，有一段时间>2说明这段时间有三个事务
    public boolean book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
            if (maxBook > 2) {
                cnt.put(start, cnt.getOrDefault(start, 0) - 1);
                cnt.put(end, cnt.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}
