package yxl.demo.y2022.m10.d17;

/**
 * @author yxl
 * @date: 2022/10/17 上午10:03
 */
public class Solution {
    public int totalFruit(int[] fruits) {
        int sum = 0;
        int[] t = new int[2];
        t[0] = t[1] = -1;
        for (int i = 0; i < fruits.length; i++) {
            int x = 0;
            for (int j = i; j < fruits.length; j++) {
                if (t[0] == -1 || t[0] == fruits[j]) {
                    t[0] = fruits[j];
                    x++;
                    continue;
                }
                if (t[1] == -1 || t[1] == fruits[j]) {
                    t[1] = fruits[j];
                    x++;
                    continue;
                }
                break;
            }
            sum = Math.max(sum, x);
            t[0] = t[1] = -1;
        }
        return sum;
    }


    /**
     *     作者：AC_OIer
     *     链接：https://leetcode.cn/problems/fruit-into-baskets/solution/by-ac_oier-skgk/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int totalFruit_V2(int[] fs) {
        int n = fs.length, ans = 0;
        int[] cnts = new int[n + 10];
        for (int i = 0, j = 0, tot = 0; i < n; i++) {
            if (++cnts[fs[i]] == 1) tot++;
            while (tot > 2) {
                if (--cnts[fs[j++]] == 0) tot--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
