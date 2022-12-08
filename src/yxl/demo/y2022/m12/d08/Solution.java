package yxl.demo.y2022.m12.d08;

/**
 * @author yxl
 * @date 2022/12/8 下午2:55
 */
public class Solution {
    public boolean squareIsWhite(String coordinates) {
        if (coordinates.charAt(0) % 2 == 1) {
            return coordinates.charAt(1) % 2 == 0;
        } else {
            return coordinates.charAt(1) % 2 == 1;
        }
    }
}
