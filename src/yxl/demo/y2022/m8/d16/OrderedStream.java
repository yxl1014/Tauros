package yxl.demo.y2022.m8.d16;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yxl
 * @Date: 2022/8/16 9:29
 */
public class OrderedStream {
    private String[] stream;
    private int ptr;

    public OrderedStream(int n) {
        stream = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        List<String> res = new ArrayList<String>();
        while (ptr < stream.length && stream[ptr] != null) {
            res.add(stream[ptr]);
            ++ptr;
        }
        return res;
    }
}
