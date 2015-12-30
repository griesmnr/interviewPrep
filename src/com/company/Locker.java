package com.company;

/**
 * Created by nicoleg on 12/29/15.
 */
public class Locker {
    private boolean isOpen;
    private int index;

    public Locker(int index){
        this.index = index;
        this.isOpen = false;
    }

    public void toggle(){
        this.isOpen = !this.isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String toString(){
        String str = "This " +(this.index+1) + "th locker is ";
        if (isOpen){
            str += "open";
        } else {
            str +="closed";
        }
        return str;
    }
}
