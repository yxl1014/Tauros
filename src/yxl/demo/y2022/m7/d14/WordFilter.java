package yxl.demo.y2022.m7.d14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yxl
 * @Date: 2022/7/14 9:18
 */
public class WordFilter {

    private Map<Integer, Map<String, Integer>> maps = new HashMap<>();;

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            int ii = words[i].charAt(0);
            this.maps.computeIfAbsent(ii, k -> new HashMap<>());
            this.maps.get(ii).put(words[i], i);
        }
    }

    public int f(String pref, String suff) {
        int index = -1;
        int i = pref.charAt(0);
        Map<String, Integer> stringIntegerMap = this.maps.get(i);
        if (stringIntegerMap==null)
            return index;
        for (Map.Entry<String, Integer> en : stringIntegerMap.entrySet()) {
            if (en.getKey().startsWith(pref) && en.getKey().endsWith(suff)) {
                if (index < en.getValue())
                    index = en.getValue();
            }
        }
        return index;
    }

    public static void main(String[] args) {
        WordFilter ff=new WordFilter(new String[]{"apple"});
        ff.f("a","e");
    }
}
