package Lesson_1;

import Lesson_1.Fruits.Apple;
import Lesson_1.Fruits.Box;
import Lesson_1.Fruits.Orange;

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


        /////////
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());

        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        System.out.println(orangeBox.getWeight());

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println(appleBox.getWeight());

        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        System.out.println(appleBox2.getWeight());


        appleBox.transferTo(appleBox2);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());

        System.out.println(orangeBox.compare(appleBox));

        orangeBox.remove();
        appleBox2.remove();
        System.out.println(appleBox2.compare(orangeBox));


    }
}
