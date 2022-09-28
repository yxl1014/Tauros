package yxl.demo.y2022.m9.d28;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author yxl
 * @date: 2022/9/28 下午10:16
 */
public class Solution {
    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int magic = 0;
        for (int i = 0; i < k; i++) {
            long curr = heap.poll();
            magic = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return magic;
    }

}
