package com.company;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        //link list demo
        System.out.println("begin linked list demo. Print the linked list backwards.");
        new LinkedListDemoEr(new LinkedList<>(Arrays.asList(1,7,4,5))).demo();
        new LinkedListDemoEr(new LinkedList<>(Arrays.asList(1,7,null,5))).demo();

        System.out.println("begin string demo. Determine if one string is a permutation of the other");
        new ListDemoEr("probz", "test").demo();
        new ListDemoEr("eellv", "level").demo();
        new ListDemoEr("ZOMG", "ZGMO").demo();
        new ListDemoEr(" ", "").demo();
        new ListDemoEr(":D", ":(").demo();
        new ListDemoEr("madam i'", "im adam").demo();

        System.out.println("begin locker demo er. flip all the lockers. brain teaser");
        new LockerDemoEr(new Locker[100]).demo();
    }

}
