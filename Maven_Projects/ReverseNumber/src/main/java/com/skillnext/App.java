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
        System.out.println("Enter the number to reverse the number :");
        int num = sc.nextInt();
        System.out.println("Initially given Number is : "+ num);
        int rev =0;
        while(num>0){
            rev = (rev*10)+(num%10);
            num/=10;
        }
         System.out.println("Reverse of given Number is : "+ rev);
    }
}
