package yxl.demo.y2023.m2.d9;

import java.util.HashMap;

/**
 * @author yxl
 * @date 2023/2/9 下午8:50
 */
public class AuthenticationManager {

    private final int timeToLive;

    private final HashMap<String, Integer> map = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer ctime = map.get(tokenId);
        if (ctime == null)
            return;
        if (currentTime < ctime + this.timeToLive) {
            map.put(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Integer i:map.values()){
            if (i+this.timeToLive>currentTime){
                count++;
            }
        }
        return count;
    }
}
