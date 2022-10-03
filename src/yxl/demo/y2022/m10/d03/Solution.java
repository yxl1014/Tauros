package yxl.demo.y2022.m10.d03;

/**
 * @author yxl
 * @date: 2022/10/3 上午11:28
 */
public class Solution {
    //该字符串 不含前导零
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
