package org.example;


import java.util.Random;
import java.util.Scanner;

public class Main {

    public static <T extends Comparable<T>> T getMin(MySet<T> set) {
        T minimum = set.getItems().getFirst();
        for (T item : set.getItems()) {
            if (minimum.compareTo(item) > 0) {
                minimum = item;
            }
        }
        return minimum;
    }

    public static MySet<Integer> createUserSet() {
        Scanner scanner = new Scanner(System.in);
        MySet<Integer> set = new MySet<>();
        System.out.print("Enter the first number in the set: ");
        set.insert(scanner.nextInt());
        System.out.print("Enter the second number i the set: ");
        set.insert(scanner.nextInt());
        return set;

    }

    public static Integer createUserNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item number: ");
        return scanner.nextInt();


    }

    public static void ExB() {
        int size = 10;
        Random rand = new Random();

        MySet<Integer> set1 = new MySet<>();
        MySet<Integer> set2 = new MySet<>();
        MySet<Integer> set3 = new MySet<>();

        for (int i = 0; i < size; i++) {
            set1.insert(rand.nextInt(100));
            set2.insert(rand.nextInt(100));
            set3.insert(rand.nextInt(100));
        }

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);

        // Union
        set1.union(set2);
        System.out.println(set1);

        // Intersection
        set1.intersect(set3);
        System.out.println(set1);

        // User input set
        MySet<Integer> userSet = createUserSet();
        System.out.printf("User input set: %s \n", userSet);
        System.out.printf("Is User input set subset of set1: %b \n", set1.isSubset(userSet));
        System.out.printf("Is User input set subset of set2: %b \n", set2.isSubset(userSet));
        System.out.printf("Is User input set subset of set3: %b \n", set3.isSubset(userSet));

        // User input number
        int userNumber = createUserNumber();
        System.out.printf("User input number: %d \n", userNumber);
        System.out.printf("Is in first set: %b \n", set1.isMember(userNumber));
        set2.insert(userNumber);
        System.out.printf("Set 2 with user number: %s \n", set2);
        set3.delete(userNumber);
        System.out.printf("Set 3 after delete user number: %s \n", set3);


    }

    public static void ExC() {
        MySet<Person> persons = new MySet<>();
        Person p1 = new Person("moshe", "moshe", "3311", 2001);
        persons.insert(p1);
        Person p2 = new Person("fofo", "fofo", "3221", 2002);
        persons.insert(p2);
        Person p3 = new Person("dodo", "dodo", "3231", 2003);
        persons.insert(p3);

        System.out.printf("Person input set: %s \n", persons);
        System.out.printf("Person minimum: %s \n", getMin(persons));
    }

    public static void main(String[] args) {
        // MySet
        ExB();

        // Persons
        ExC();


    }
}
