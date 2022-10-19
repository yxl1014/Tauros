package yxl.demo.y2022.m10.d19;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author yxl
 * @date: 2022/10/19 下午2:00
 */
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();
        int sIndex = 0;
        for (int i : students) {
            if (i == sandwiches[sIndex]) {
                sIndex++;
            } else {
                queue.offer(i);
            }
        }
        int qSize = queue.size();
        int temp = 0;
        while (queue.size() != 0) {
            if (temp == qSize) {
                break;
            }
            if (queue.peek() == sandwiches[sIndex]) {
                sIndex++;
                queue.poll();
                qSize = queue.size();
                temp = 0;
            } else {
                temp++;
                queue.offer(queue.poll());
            }
        }
        return queue.size();
    }

    /**
     * 作者：AC_OIer
     * 链接：https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/solution/by-ac_oier-rvc3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int countStudents_V2(int[] a, int[] b) {
        int[] cnts = new int[2];
        for (int x : a)
            cnts[x]++;
        for (int i = 0; i < b.length; i++) {
            if (--cnts[b[i]] == -1)
                return b.length - i;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countStudents_V2(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
    }
}
