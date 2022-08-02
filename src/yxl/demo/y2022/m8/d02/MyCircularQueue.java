package yxl.demo.y2022.m8.d02;

/**
 * @Author: yxl
 * @Date: 2022/8/2 10:28
 * 执行用时：4 ms , 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：42.2 MB, 在所有 Java 提交中击败了9.98%的用户
 */
public class MyCircularQueue {

    private final int[] data;
    private int size;

    private final int len;
    private int first;
    private int last;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.size = 0;
        this.len = k;
        this.first = -1;
        this.last = -1;
    }

    public boolean enQueue(int value) {
        if (this.first == -1) {
            this.first = this.last = 0;
            this.size++;
            this.data[first] = value;
        } else {
            if (this.size < this.len) {
                if (++this.last >= this.len) {
                    this.last = 0;
                }
                this.data[this.last] = value;
                this.size++;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean deQueue() {
        if (this.size == 0) {
            return false;
        }
        if (++this.first >= this.len) {
            this.first = 0;
        }
        this.size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : this.data[this.first];
    }

    public int Rear() {
        return isEmpty() ? -1 : this.data[this.last];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.len;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1)); // 返回 true
        System.out.println(circularQueue.enQueue(2)); // 返回 true
        System.out.println(circularQueue.enQueue(3)); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 false，队列已满
        System.out.println(circularQueue.Rear()); // 返回 3
        System.out.println(circularQueue.isFull()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 true
        System.out.println(circularQueue.Rear()); // 返回 4
    }
}
