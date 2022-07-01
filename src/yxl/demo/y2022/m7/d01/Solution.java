package yxl.demo.y2022.m7.d01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yxl
 * 作者：LeetCode-Solution
 *     链接：https://leetcode.cn/problems/different-ways-to-add-parentheses/solution/wei-yun-suan-biao-da-shi-she-ji-you-xian-lyw6/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    static final int ADDITION = -1;
    static final int SUBTRACTION = -2;
    static final int MULTIPLICATION = -3;


    public List<Integer> diffWaysToCompute(String expression) {
        //拆分后的串
        List<Integer> ops = new ArrayList<Integer>();
        for (int i = 0; i < expression.length();) {
            //是否为字符
            if (!Character.isDigit(expression.charAt(i))) {
                if (expression.charAt(i) == '+') {
                    ops.add(ADDITION);
                } else if (expression.charAt(i) == '-') {
                    ops.add(SUBTRACTION);
                } else {
                    ops.add(MULTIPLICATION);
                }
                i++;
            } else {
                //若是数字则获取梳子
                int t = 0;
                //条件为下一位也是数字则 t×1=+这个数
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    t = t * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ops.add(t);
            }
        }
        //初始化结果集
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<Integer>();
            }
        }
        return dfs(dp, 0, ops.size() - 1, ops);
    }

    public List<Integer> dfs(List<Integer>[][] dp, int l, int r, List<Integer> ops) {
        if (dp[l][r].isEmpty()) {
            //如果到最后一个数则直接返回
            if (l == r) {
                dp[l][r].add(ops.get(l));
            } else {
                //获取每个运算符左边和右边的子串的结果集
                for (int i = l; i < r; i += 2) {
                    //获取左字串的结果集
                    List<Integer> left = dfs(dp, l, i, ops);
                    //获取右字串的结果集
                    List<Integer> right = dfs(dp, i + 2, r, ops);
                    //组合出左右结果集的总结果集
                    for (int lv : left) {
                        for (int rv : right) {
                            if (ops.get(i + 1) == ADDITION) {
                                dp[l][r].add(lv + rv);
                            } else if (ops.get(i + 1) == SUBTRACTION) {
                                dp[l][r].add(lv - rv);
                            } else {
                                dp[l][r].add(lv * rv);
                            }
                        }
                    }
                }
            }
        }
        //返回这个结果集
        return dp[l][r];
    }
}
