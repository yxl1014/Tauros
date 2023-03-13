package yxl.demo.y2023.m3.d13;

/**
 * @author yxl
 * @date 2023/3/13 上午10:48
 */
public class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        int n = energy.length;
        if (n == 0) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            if (initialEnergy <= energy[i] || initialExperience <= experience[i]) {
                if (energy[i] >= initialEnergy) {
                    int need = energy[i] - initialEnergy + 1;
                    res += need;
                    initialEnergy += need;
                }
                if (experience[i] >= initialExperience) {
                    int need = experience[i] - initialExperience + 1;
                    res += need;
                    initialExperience += need;
                }
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumberOfHours(5,3,new int[]{1,4},new int[]{2,5}));
    }
}
