package Lesson_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyArray<String> arr = new MyArray<>(2);
        System.out.println(arr);
        arr.add("1");
        arr.add("2");
        System.out.println(arr);
        arr.add("3");
        System.out.println(arr);
        arr.add("4");
        System.out.println(arr);
        arr.add("5");
        System.out.println(arr);
        arr.swap(0,4);
        System.out.println(arr);
        ArrayList<String> arrayList = arr.toArrayList();
        System.out.println(arrayList);
    }
}
