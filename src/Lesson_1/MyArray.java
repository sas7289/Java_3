package Lesson_1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MyArray<T> {
    private T[] arr;
    private int currentSize;
    private int capacity;

    public MyArray() {
        this(5);
    }
    public MyArray(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public void add(T element) {
        if(currentSize == capacity) {
            newCapacity();
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[currentSize] = element;
        currentSize++;
    }
    
    
    public void swap(int first, int second) {
        T temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }



    private void newCapacity() {
        this.capacity = this.capacity * 3 / 2 + 1;
    }

    @Override
    public String toString() {
        String result = "";
        for (T t : arr) {
            result += t + " ";
        }
        return result;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> temp = new ArrayList<>();
        Collections.addAll(temp, arr);
        return temp;
    }
}
