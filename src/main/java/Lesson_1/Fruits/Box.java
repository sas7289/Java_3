package Lesson_1.Fruits;

import java.util.ArrayList;
import java.util.Iterator;

public class Box<T extends Fruit> {

    ArrayList<T> fruitBox = new ArrayList<>();


    public void add(T fruit) {
        fruitBox.add(fruit);
    }

    public void remove() {
        fruitBox.remove(fruitBox.size() - 1);
    }

    public float getWeight() {
        if(fruitBox.size() == 0) return 0;
        return fruitBox.size() * fruitBox.get(0).getWeight();
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void transferTo(Box<T> box) {
        Iterator<T> iterator = fruitBox.iterator();
        while (iterator.hasNext()) {
            box.add(iterator.next());
            iterator.remove();
        }
    }

}
