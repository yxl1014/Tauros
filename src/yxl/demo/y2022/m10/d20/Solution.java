package yxl.demo.y2022.m10.d20;

/**
 * @author yxl
 * @date: 2022/10/20 下午4:29
 *
作者：LeetCode-Solution
链接：https://leetcode.cn/problems/k-th-symbol-in-grammar/solution/di-kge-yu-fa-fu-hao-by-leetcode-solution-zgwd/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthGrammar(10, 5));
    }

}
