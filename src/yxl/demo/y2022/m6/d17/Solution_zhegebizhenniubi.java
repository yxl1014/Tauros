package yxl.demo.y2022.m6.d17;

import java.util.Arrays;

public class Solution_zhegebizhenniubi {
    public void DuplicateZeros(int[] arr) {
        String s = "";
        for (int i : arr) {
            s += i;
        }
        s=s.replaceAll("0", "00");
        char[] c = s.toCharArray();
        for (int i = 0; i < arr.length; ++i)
            arr[i] = c[i] - '0';
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        new Solution_zhegebizhenniubi().DuplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }
}
