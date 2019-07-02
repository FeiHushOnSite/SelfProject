package java1_8;

import java1_8.pojo.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class lambdaExpress {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("lambda表达式实现线程")).start();
        List<Person> personList = getPersonList();
        //  personList.forEach(person -> System.out.println(person.toString()));
        personList.forEach(System.out::println);  //双冒号::  表示方法引用，可以引用其他方法
        personList.stream().filter(e -> e.getAge() > 20)
                .forEach(e -> System.out.println("年龄大于20岁的人" + e.toString()));
        System.out.println("----------------------------");
        personList.stream().limit(2).filter(e -> e.getAge() > 20)
                .forEach(e -> System.out.println(e.toString()));

        //年龄排序
        personList.stream().sorted((p1,p2) -> (p1.getAge() - p2.getAge()))
                .forEach(e -> System.out.println(e.toString()));
        //姓名排序
        System.out.println("----------------------------");
        personList.stream().sorted(Comparator.comparing(Person::getName))
                .forEach(e -> System.out.println(e.toString()));
    }

    private static List<Person> getPersonList() {
        Person p1 = new Person("liu", 22, "male");
        Person p2 = new Person("zhao", 22, "male");
        Person p3 = new Person("li", 18, "female");
        Person p4 = new Person("wang", 21, "female");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        return list;
    }

}
