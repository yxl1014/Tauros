package yxl.demo.y2023.m1.d16;

/**
 * @author yxl
 * @date 2023/1/16 下午3:03
 */
public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0, j = 0;
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        while (j < words1.length - i && j < words2.length - i && words1[words1.length - j - 1].equals(words2[words2.length - j - 1])) {
            j++;
        }
        return i + j == Math.min(words1.length, words2.length);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().areSentencesSimilar("My name is Haley", "My Haley"));
    }
}
