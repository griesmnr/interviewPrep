package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by nicoleg on 12/20/15.
 */
public class LinkedListDemoEr extends DemoEr{
    protected LinkedList<Integer> testCase;

    public LinkedListDemoEr(LinkedList<Integer> testCase){
        super(testCase.toString());
        this.testCase = testCase;
    }

    public LinkedList<Integer> getTestCase() {
        return testCase;
    }

    public void doWork(){
        Iterator<Integer> iterator = this.testCase.iterator();
        Stack<Integer> stack = new Stack<>();
        while (iterator.hasNext()){
            stack.push(iterator.next());
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
