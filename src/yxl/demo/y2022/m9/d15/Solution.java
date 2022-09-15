package yxl.demo.y2022.m9.d15;

public class Solution {
    /**
     *
     作者：capital-worker
     链接：https://leetcode.cn/problems/bulb-switcher-ii/solution/dengp-by-capital-worker-51rb/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     tai ta ma niu bi le
     * */
    public int flipLights(int n, int presses) {
        //不按开关
        if (presses == 0) {
            return 1;
        }
        //特殊情况处理
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            //特殊情况
            return presses == 1 ? 3 : 4;
        } else {
            //n >= 3
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }

}
