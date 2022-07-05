package yxl.demo.y2022.m7.d05;

import sun.rmi.server.InactiveGroupException;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {

    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        this.map = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        if (map == null) {
            return false;
        }

        if (map.containsKey(start)) {
            return false;
        }

        Map.Entry<Integer, Integer> integerIntegerEntry = map.tailMap(start, false).firstEntry();

        if (integerIntegerEntry != null) {
            if (integerIntegerEntry.getKey() < end) {
                return false;
            }
        }

        Map.Entry<Integer, Integer> integerIntegerEntry1 = map.ceilingEntry(start);

        if (integerIntegerEntry1!=null){
            if (integerIntegerEntry1.getValue()>=start){
                return false;
            }
        }

        this.map.put(start,end);

        return true;
    }

    public static void main(String[] args) {
        MyCalendar c=new MyCalendar();
        System.out.println(c.book(10, 20));
        System.out.println(c.book(15, 25));
        System.out.println(c.book(20, 30));
    }
}
