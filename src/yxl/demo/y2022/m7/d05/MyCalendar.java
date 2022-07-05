package yxl.demo.y2022.m7.d05;

import sun.rmi.server.InactiveGroupException;

import java.util.*;

public class MyCalendar {

    private List<int[]> list;

    public MyCalendar() {
        this.list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : list) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar c=new MyCalendar();
        System.out.println(c.book(10, 20));
        System.out.println(c.book(15, 25));
        System.out.println(c.book(20, 30));
    }
}
