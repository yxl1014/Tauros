package yxl.demo.y2023.m2.d18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yxl
 * @date 2023/2/18 下午9:52
 */
public class Solution {

    public interface CustomFunction {
        int f(int x, int y);
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        int x = 1, y = 1000;
        while (x <= 1000 && y > 0) {
            int res = customfunction.f(x, y);
            if (res < z) ++x;
            else if (res > z) --y;
            else {
                List<Integer> list = new ArrayList<>();
                list.add(x++);
                list.add(y--);
                ans.add(list);
            }
        }
        return ans;
    }
}
