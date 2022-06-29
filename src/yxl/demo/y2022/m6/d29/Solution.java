package yxl.demo.y2022.m6.d29;

import java.util.HashMap;
import java.util.Map;

/**
作者：LeetCode-Solution
链接：https://leetcode.cn/problems/encode-and-decode-tinyurl/solution/tinyurl-de-jia-mi-yu-jie-mi-by-leetcode-ty5yp/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    private Map<Integer, String> dataBase = new HashMap<Integer, String>();
    private int id;

    public String encode(String longUrl) {
        id++;
        dataBase.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return dataBase.get(key);
    }

}
