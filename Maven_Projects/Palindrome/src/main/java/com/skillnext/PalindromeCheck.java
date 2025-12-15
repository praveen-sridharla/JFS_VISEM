package com.skillnext;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class PalindromeCheck
{
    public static void main( String[] args )
    {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the String to check as it is a palindroem or not :");
       String s = sc.nextLine();
       boolean isPalindrome = true;
       int i=0;
       int j=s.length()-1;
       while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                isPalindrome=false;
                break;
            }
            i++;
            j--;
       }
       if(isPalindrome){
        System.err.println(s+" is a palindrome");
       }else{
         System.err.println(s+" is not a palindrome");
       }
    }
}
