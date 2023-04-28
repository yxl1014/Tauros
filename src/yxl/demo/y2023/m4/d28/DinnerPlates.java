package yxl.demo.y2023.m4.d28;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei 1627419257@qq.com
 * @date 2023/4/28 下午7:13
 */
public class DinnerPlates {
    private int capacity;
    private List<MyStack> stacks;
    private int index = -1;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
    }

    public void push(int val) {
        for (MyStack stack : this.stacks) {
            if (stack.getSize() == this.capacity) {
                continue;
            }
            stack.push(val);
            return;
        }
        MyStack stack = new MyStack(capacity);
        stack.push(val);
        stacks.add(stack);
        index++;
    }

    public int pop() {
        MyStack stack;
        boolean flag = true;
        do {
            if (index == -1) {
                return -1;
            }
            stack = stacks.get(index);
            if (stack == null || stack.getSize() == 0) {
                stacks.remove(index--);
            } else {
                flag = false;
            }
        }
        while (flag);
        int pop = stack.pop();
        if (stack.getSize() == 0) {
            stacks.remove(index--);
        }
        return pop;
    }

    public int popAtStack(int index) {
        if (index == -1 || index >= this.stacks.size()) {
            return -1;
        }
        MyStack stack = stacks.get(index);
        if (stack == null || stack.getSize() == 0) {
            return -1;
        }
        int pop = stack.pop();
        if (stack.getSize() == 0 && index == this.index) {
            stacks.remove(this.index--);
        }
        return pop;
    }

    class MyStack {
        private int size;
        private int index;
        private int[] data;

        public MyStack(int capacity) {
            this.size = 0;
            this.index = -1;
            this.data = new int[capacity];
        }

        public void push(int val) {
            this.data[++index] = val;
            this.size++;
        }

        public int pop() {
            this.size--;
            return this.data[index--];
        }

        public int getSize() {
            return size;
        }
    }

    public static void main(String[] args) {
        DinnerPlates D = new DinnerPlates(2);
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(7);
        System.out.println(D.popAtStack(8));
        D.push(20);
        D.push(21);
        System.out.println(D.popAtStack(0));
        System.out.println(D.popAtStack(2));
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
    }
}
