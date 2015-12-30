package com.company;

/**
 * Created by nicoleg on 12/29/15.
 */
public class EggDemoEr extends DemoEr {
    private int n;
    private int tosses;
    private State state;
    private enum State {NO_EGGS_BROKEN, ONE_EGG_BROKEN, BOTH_EGGS_BROKEN}
    private int min;
    private int max;

    public EggDemoEr(int n){
        super(Integer.toString(n));
        this.n = n;
        this.tosses = 0;
        this.state = State.NO_EGGS_BROKEN;
        this.min = 1;
        this.max = 100;
    }

    public void toss(int floor){
        tosses++;
        System.out.println("tossing from " + floor + " floor");
        if (floor >= n){
            //we broke an egg.
            advanceState();
            this.max = floor;
        } else {
            //we didnt break an egg.
            this.min = floor + 1; //since the egg didn't break, we know n has to be the floor above or more.
        }
    }

    public void advanceState(){
        if (this.state == State.NO_EGGS_BROKEN){
            this.state = State.ONE_EGG_BROKEN;
        } else if (this.state == State.ONE_EGG_BROKEN){
            this.state = State.BOTH_EGGS_BROKEN;
        }
    }

    public void doWork(){
        //toss based on state (amount of eggs) and known items
        while (this.state != State.BOTH_EGGS_BROKEN && !(this.min == this.n && this.max == this.n)){
            performBestMove();
        }

        if (this.min == this.n && this.max == this.n){
            System.out.println("it seems we have succeeded in " + tosses + " tosses");
        } else {
            System.out.println("it seems we have failed in " + tosses + " tosses");
        }

    }

    public void performBestMove(){
        if (this.state == State.NO_EGGS_BROKEN){
            doFirstEggAlgorithm();
        } else if (this.state == State.ONE_EGG_BROKEN){
            doSecondEggAlgorithm();
        }
    }

    public void doFirstEggAlgorithm(){
        //trying different first egg algorithms
        //figure out what floor we should throw from now.

        //this first try, i try to divide the range up, and throw the egg in the center.
        //this transpires until an egg is broken.
        //int nextFloor = (max-min)/2 + min; //half the range, plus min as offset.
        //this method ends up being nice for things above 50. we're in good shape right away having cut out half
        //of the numbers.
        //this method isn't super performant for lower numbers. breaking that first egg immediately sucks and grinds
        //things to a hault. 49, for instance, takes 50 tosses. we had better explore other methods.


        //wwe could try a more cautious version of the ranges before we explore other things. what if,
        //since half is aggressive and likely to break, we quartered it instead? lower number, less likely to break.
        //int nextFloor = (max-min)/4 + min;
        //hmmm... while this does overall improve things, and was a decision in the right direction (since we reduced
        //risk we can cover more ground than the second egg algorithm), now higher ns, like 99, are up to 13 tosses.
        //also for a test case like 24, we would still need 25 tosses.
        //we should explore other things and see if this is the best we can do.

        //i guess im trying many of the same solutions, but im intrigued now. what is an acceptable starting point for
        //risk? its hard because the more careful i am, the longer it seems it takes me to get to my higher numbers.
        //int nextFloor = (max-min)/10 + min;
        //yep, a factor of 10 simply crawled to n=99, at a whopping 27 tosses.

        //so my next thought is, this is all because im dividing based on the numbers/range that are remaining. what
        //if i had a fixed interval to try until it didn't work?
        int nextFloor = min + 9;
        //now things that are one less than the factor will have to climb up maybe factor times on the second egg
        //algorithm here. seems problematic.

        toss(nextFloor);

    }

    public void doSecondEggAlgorithm(){
        //this inches its way up to n. probably will remain fixed no matter what i try with the first egg.
        toss(this.min);
    }
}
