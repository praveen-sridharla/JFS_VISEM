package com.skillnext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String s = "rotor";
        boolean isPalindrome = true;
        int i=0;
        int j=s.length();
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                isPalindrome=false;
                break;
            }
            i++;
            j--;
        }
        if(isPalindrome){
            System.out.println(s+" is a palindrome!");
        }else{
             System.err.println(s+" is not a palindrome!");
        }
    }
}
