package Lesson_7;

import Lesson_7.testClass.Test_for_HT;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        start(Test_for_HT.class);
    }


    public static void start(Class testClass) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Method[] methods = testClass.getDeclaredMethods();
        ArrayList<Method> methodList = new ArrayList<>(Arrays.asList(methods));
        Iterator<Method> methodIterator = methodList.iterator();
        boolean beforeSuitePassed = false;
        boolean afterSuitePassed = false;

        Method firstMethod = null;
        Method lastMethod = null;

        //Проходим по всем методоам
        while (methodIterator.hasNext()) {
            Method temp = methodIterator.next();
            //Если это метод с аннотацией BeforeSuite, то для ясности присваиваем его переменной
            //firstMethod, а также ставим флаг beforeSuitePassed после чего удаляем метод из списка.
            //В случае наличия таких методов более одного выбросится RuntimeException.
            if (temp.getAnnotation(BeforeSuite.class) != null) {
                if (beforeSuitePassed) {
                    throw new RuntimeException();
                }
                firstMethod = temp;
                methodIterator.remove();
                beforeSuitePassed = true;
                continue;
            }

            //Если это метод с аннотацией AfterSuite, то для ясности присваиваем его переменной
            //lastMethod, а также ставим флаг afterSuitePassed после чего удаляем метод из списка
            //В случае наличия таких методов более одного выбросится RuntimeException.
            if (temp.getAnnotation(AfterSuite.class) != null) {
                if (afterSuitePassed) {
                    throw new RuntimeException();
                }
                lastMethod = temp;
                methodIterator.remove();
                afterSuitePassed = true;
                continue;
            }

            //Если предыдущие два условия не сработали, то проверяем метод на наличие аннотации Test,
            //в слуае отсутствия которой удаляем данный метод из списка
            if (temp.getAnnotation(Test.class) == null) {
                methodIterator.remove();
            }
        }

        firstMethod.invoke(null);

        //Так как методы с аннотацией Test необходимо вызывать в порядке возрастания их приоритета,
        //то сначала отсортируем список оставшихся методов
        methodList.sort(new Comparator<Method>() {
            @Override
            public int compare(Method method1, Method method2) {
                int m1 = method1.getAnnotation(Test.class).rate();
                int m2 = method2.getAnnotation(Test.class).rate();
                if (m1 < m2) {
                    return 1;
                } else if (m1 > m2) {
                    return -1;
                } else return 0;
            }
        });

        methodIterator = methodList.iterator();
        while (methodIterator.hasNext()) {
            Method temp = methodIterator.next();
            temp.invoke(null);
        }

        lastMethod.invoke(null);
    }


    public static void start(String nameClass) {
        try {
            start(Class.forName(nameClass));
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Test {
        int rate();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface BeforeSuite {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface AfterSuite {
    }

}
