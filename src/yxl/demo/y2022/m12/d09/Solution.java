package yxl.demo.y2022.m12.d09;

/**
 * @author yxl
 * @date 2022/12/9 下午4:27
 */
public class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
