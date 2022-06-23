package yxl.demo.y2022.m6.d17;

public class Solution {
    public void duplicateZeros(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0, j = 0; i < arr.length && j < arr.length; i++) {
            if (arr[i] == 0) {
                temp[j++] = 0;
                if (j < arr.length)
                    temp[j++] = 0;
            } else {
                temp[j++] = arr[i];
            }
        }
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }
}
