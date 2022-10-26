package yxl.demo.y2022.m10.d26;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author yxl
 * @date: 2022/10/26 下午2:15
 */
public class Solution {

    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        int min = len + 1;
        int i = 0, j = 0, sum = 0;
        boolean flag = false;
        while (i < len && j < len) {
            if (!flag)
                sum += nums[j];
            if (sum >= k) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
                flag = true;
            } else {
                j++;
                flag = false;
            }
        }
        return min != len + 1 ? min : -1;
    }

    public int test(int[] nums, int k) {
        int n = nums.length, res = Integer.MAX_VALUE;
        long sum = 0;
        Deque<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{-1, 0});
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (queue.size() > 0 && sum - queue.peek()[1] >= k) {
                res = (int) Math.min(res, i - queue.poll()[0]);
            }
            //这个 我不懂
            while (queue.size() > 0 && queue.peekLast()[1] >= sum) {
                queue.pollLast();
            }
            queue.offer(new long[]{i, sum});
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int shortestSubarray_(int[] nums, int k) {
        int ans = (int) 1e6;
        Queue<long[]> q = new PriorityQueue<>((a, b) -> a[0] < b[0] ? -1 : 1);
        q.add(new long[]{0, -1});//[前缀和，下标]
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long target = sum - k;
            while (!q.isEmpty() && q.peek()[0] <= target) {
                ans = Math.min(ans, i - (int) q.poll()[1]);
            }
            q.add(new long[]{sum, i});
        }
        return ans <= nums.length ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestSubarray_(new int[]{84, -37, 32, 40, 95}, 167));
    }
}
