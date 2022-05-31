package chapter7.array;

import java.util.ArrayList;

public class ArrayListTest {
    static public void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        for(String s : list) {
            System.out.println(s);
        }
        for(int i = 0; i < list.size(); i ++) {
            System.out.println(list.get(i));
        }
    }
}
