package yxl.demo.y2023.m1.d18;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author yxl
 * @date 2023/1/18 下午7:13
 */
public class MKAverage {

    private int length = 0;
    private int m;
    private int k;

    private ArrayList<Integer> list = new ArrayList<>();

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        this.length++;
        this.list.add(num);
    }

    public int calculateMKAverage() {
        if (this.length < this.m)
            return -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = this.length - 1; i >= this.length - this.m; i--) {
            list.add(this.list.get(i));
        }
        Collections.sort(list);
        for (int i = 0; i < k; i++) {
            list.remove(0);
            list.remove(list.size() - 1);
        }
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum / list.size();
    }

    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);        // 当前元素为 [3]
        obj.addElement(1);        // 当前元素为 [3,1]
        System.out.println(obj.calculateMKAverage()); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        obj.addElement(10);       // 当前元素为 [3,1,10]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        obj.addElement(5);        // 当前元素为 [3,1,10,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
        System.out.println(obj.calculateMKAverage());
    }
}
