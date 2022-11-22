package yxl.demo.y2022.m11.d22;

/**
 * @author yxl
 * @date 2022/11/22 下午4:11
 */
public class Solution {
    static final int MOD = 1000000007;

    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/nth-magical-number/solutions/1983699/di-n-ge-shen-qi-shu-zi-by-leetcode-solut-6vyy/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int nthMagicalNumber(int n, int a, int b) {
        int c = lcm(a, b);
        int m = c / a + c / b - 1;
        int r = n % m;
        int res = (int) ((long) c * (n / m) % MOD);
        if (r == 0) {
            return res;
        }
        int addA = a, addB = b;
        for (int i = 0; i < r - 1; ++i) {
            if (addA < addB) {
                addA += a;
            } else {
                addB += b;
            }
        }
        return (res + Math.min(addA, addB) % MOD) % MOD;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
