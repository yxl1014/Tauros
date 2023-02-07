package yxl.demo.y2023.m2.d7;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author yxl
 * @date 2023/2/7 下午2:04
 */
public class Solution {
    /**
     * 我自己写的这个 时间必须是有序的
     */
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        TreeSet<String> set = new TreeSet<>();
        Map<String, ArrayDeque<String>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            if (!map.containsKey(keyName[i])) {
                ArrayDeque<String> queue = new ArrayDeque<>();
                queue.offer(keyTime[i]);
                map.put(keyName[i], queue);
                continue;
            }
            ArrayDeque<String> q = map.get(keyName[i]);
            String time = q.getFirst();
            String[] times = time.split(":");
            String[] times2 = keyTime[i].split(":");
            int t1 = (Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]));
            int t2 = (Integer.parseInt(times2[0]) * 60 + Integer.parseInt(times2[1]));
            if (t1 <= t2 && t2 - t1 <= 60) {
                q.offerLast(keyTime[i]);
                if (q.size() >= 3) {
                    set.add(keyName[i]);
                }
            } else if (t1 > t2) {
                ArrayDeque<String> queue = new ArrayDeque<>();
                queue.offer(keyTime[i]);
                map.put(keyName[i], queue);
            } else {
                do {
                    q.pollFirst();
                    time = q.peekFirst();
                    if (time == null)
                        break;
                    times = time.split(":");
                    times2 = keyTime[i].split(":");
                } while ((Integer.parseInt(times2[0]) * 60 + Integer.parseInt(times2[1])) -
                        (Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1])) > 60);
                q.offerLast(keyTime[i]);
            }
        }
        return new ArrayList<>(set);
    }
}
