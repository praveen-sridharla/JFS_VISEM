package com.skillnext;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println( "Enter the number to check as it is prime or not :" );
        int num = sc.nextInt();
        if(isPalindrome(num)){
            System.err.println("given num "+num+" is a prime number");
        }else{
             System.err.println("given num "+num+" is not a prime number");
        }
        // System.out.println(Math.sqrt(num)+"  -->  "+(num>>1));
    }
    public static boolean isPalindrome(int num){
        for(int i=2; i*i<num; i++){
            // System.out.println(i);
            if(num%i==0) return false;
        }
        return true;
    }
}
