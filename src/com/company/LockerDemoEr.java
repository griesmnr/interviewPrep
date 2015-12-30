package com.company;

import java.util.ArrayList;

/**
 * Created by nicoleg on 12/29/15.
 */
public class LockerDemoEr extends DemoEr {
    private Locker[] lockers;

    public LockerDemoEr(Locker[] lockers){
        super(lockers.length + " closed lockers");
        //instantiate lockers
        for (int i=0; i<lockers.length; i++){
            lockers[i] = new Locker(i);
        }
        this.lockers = lockers;
    }

    public void doWork(){
        for (int i=0; i<lockers.length; i++){ //keeping track of which we are flipping and which we arent
            //humanize the number
            int shiftedIndex = i+1;
            System.out.println("shifting every " + shiftedIndex + "th");
            //actually doing the flipping
            for (int j=0; j<lockers.length; j++){
                //humanize the number again
                int shiftedInnerIndex = j+1;
                //dividing gets no remainder
                if (shiftedInnerIndex%shiftedIndex == 0){
                    System.out.println("shifting " + shiftedInnerIndex);
                    lockers[j].toggle();
                } else {
                    System.out.println("not shifting " +shiftedInnerIndex);
                }
            }
        }
        int opens = 0;
        for (int i=0; i<lockers.length; i++){
            if (lockers[i].isOpen()){
                opens++;
            }
            System.out.println(lockers[i].toString());
        }
        System.out.println("How many are open: " + opens);
    }
}
