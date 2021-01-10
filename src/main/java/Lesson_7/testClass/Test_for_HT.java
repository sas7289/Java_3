package Lesson_7.testClass;

import Lesson_7.Main;

public class Test_for_HT {
    public void withoutAnnotationMethod() {
        System.out.println("WithoutAnnotation");
    }

    @Main.BeforeSuite
    public static void first() {
        System.out.println("BeforeSuite");
    }
    @Main.AfterSuite
    public static void last() {
        System.out.println("AfterSuite");
    }


    @Main.Test(rate = 7)
    public static void test1() {
        System.out.println("test1");
    }
    @Main.Test(rate = 1)
    public static void test2() {
        System.out.println("test2");
    }
    @Main.Test(rate = 6)
    public static void test3() {
        System.out.println("test3");
    }
    @Main.Test(rate = 4)
    public static void test4() {
        System.out.println("test4");
    }
    @Main.Test(rate = 9)
    public static void test5() {
        System.out.println("test5");
    }
    @Main.Test(rate = 5)
    public static void test6() {
        System.out.println("test6");
    }
    @Main.Test(rate = 3)
    public static void test7() {
        System.out.println("test7");
    }
    @Main.Test(rate = 3)
    public static void test8() {
        System.out.println("test8");
    }
}
