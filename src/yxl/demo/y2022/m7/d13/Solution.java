package yxl.demo.y2022.m7.d13;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: yxl
 * @Date: 2022/7/13 9:48
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/asteroid-collision/solution/xing-xing-peng-zhuang-by-leetcode-soluti-u3k0/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    //总体思路为从左往右遍历，若是负的则不会发生碰撞直接入队，执行下一个元素
    //若是正的即向右的则直接入队，若为负的则需要看栈顶元素是正是负，若为负的也不会发生碰撞，正的则需要发生碰撞
    public int[] asteroidCollision(int[] asteroids) {
        //用队列当成栈来使用
        Deque<Integer> stack = new ArrayDeque<>();
        //遍历所有元素
        for (int aster : asteroids) {
            //初始化状态
            boolean alive = true;
            //当前状态为true  此元素小于0     栈不为空            栈顶元素大于0
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                //判断此元素是否还存在
                alive = stack.peek() < -aster; // aster 是否存在
                //判断栈内比较元素是否还存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            //经过碰撞之后若还存在则入队
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }


}
