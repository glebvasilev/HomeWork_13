package com.company;

import java.util.Arrays;
import java.util.Comparator;

class PersonSuperComparator {
    /*
     *  Class serves for comparing persons
     */

    private String name;
    private int age;

    public PersonSuperComparator(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}

class Compare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

class SortedByAge implements Comparator<PersonSuperComparator> {

    public int compare(PersonSuperComparator a1, PersonSuperComparator a2) {
        int age1 = a1.getAge();
        int age2 = a2.getAge();

        if (age1 > age2)
            return 1;
        else if (age1 < age2)
            return -1;
        else
            return 0;
    }
}

class SortedByName implements Comparator<PersonSuperComparator> {

    public int compare(PersonSuperComparator n1, PersonSuperComparator n2) {
        String name1 = n1.getName();
        String name2 = n2.getName();
        return name1.compareTo(name2);
    }
}

public class Main {

    public static void main(String[] args) {

        PersonSuperComparator[] persons = new PersonSuperComparator[4];
        persons[0] = new PersonSuperComparator("Tomas", 35);
        persons[1] = new PersonSuperComparator("Sandy", 19);
        persons[2] = new PersonSuperComparator("Bobby", 28);
        persons[3] = new PersonSuperComparator("Karlos", 12);

        System.out.println("Without sorting:");
        for (PersonSuperComparator p:persons)
            System.out.println(p);
        System.out.println(" ");

        Arrays.sort(persons, new SortedByAge());
        System.out.println("Sorted by age:");
        for (PersonSuperComparator p:persons)
            System.out.println(p);
        System.out.println(" ");

        Arrays.sort(persons, new SortedByName());
        System.out.println("Sorted by name:");
        for (PersonSuperComparator p:persons)
            System.out.println(p);
        System.out.println(" ");
    }
}

