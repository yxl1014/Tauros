package yxl.demo.y2022.m11.d16;

/**
 * @author yxl
 * @date 2022/11/16 下午1:24
 */
public class Solution {
    int n;
    int[] tr;

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x) {
        for (int i = x; i <= n; i += lowbit(i))
            tr[i]++;
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i))
            ans += tr[i];
        return ans;
    }

    /**
     * 作者：宫水三叶
     * 链接：https://leetcode.cn/problems/global-and-local-inversions/solutions/1973365/by-ac_oier-jc7a/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isIdealPermutation(int[] nums) {
        n = nums.length;
        tr = new int[n + 10];
        add(nums[0] + 1);
        int a = 0, b = 0;
        for (int i = 1; i < n; i++) {
            a += query(n) - query(nums[i] + 1);
            b += nums[i] < nums[i - 1] ? 1 : 0;
            add(nums[i] + 1);
        }
        return a == b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIdealPermutation(new int[]{1, 0, 2}));
    }

}
