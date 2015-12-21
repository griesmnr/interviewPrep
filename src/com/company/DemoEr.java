package com.company;

import java.util.LinkedList;

/**
 * Created by nicoleg on 12/20/15.
 */
public abstract class DemoEr {
    private String stringTestCase;

    public DemoEr(String stringyTestCase){
        this.stringTestCase = stringyTestCase;
    }

    public void demo(){
        System.out.println("Our test case(s) looks like this:");
        System.out.println(this.stringTestCase);
        System.out.println("and here is the result:");
        doWork();
    }

    public abstract void doWork();
}
