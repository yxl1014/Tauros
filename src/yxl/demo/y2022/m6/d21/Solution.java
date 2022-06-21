package yxl.demo.y2022.m6.d21;

public class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().defangIPaddr("1.1.1.1"));
    }
}
