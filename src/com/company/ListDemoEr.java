package com.company;

/**
 * Created by nicoleg on 12/20/15.
 */
public class ListDemoEr extends DemoEr {
    private String testCase1;
    private String testCase2;

    public ListDemoEr(String testCase1, String testCase2){
        super("'" + testCase1 + "', '" + testCase2 + "'");
        this.testCase1 = testCase1;
        this.testCase2 = testCase2;
    }

    public void doWork(){
        int[] test1Alphabet = populateAlphabetArray(testCase1);
        int[] test2Alphabet = populateAlphabetArray(testCase2);

        for (int i=0; i<26; i++){
            if (test2Alphabet[i] != test1Alphabet[i]){
                System.out.println("not a palindrome");
                return ;
            }
        }
        System.out.println("yes a palindrome");
    }

    private int[] populateAlphabetArray(String testCase){
        //initializes to all zeroes
        int[] alphabetSoup = new int[26];

        int length = testCase.length();

        //todo java 8 this.
        for (int i=0; i<length; i++){
            char currentChar = testCase.charAt(i);
            int currentCharCode = Character.toLowerCase(currentChar);
            if (currentCharCode >= 97 && currentCharCode <= 122){
                int index = currentCharCode - 97;
                alphabetSoup[index] += 1;
            }
        }
        return alphabetSoup;
    }
}
