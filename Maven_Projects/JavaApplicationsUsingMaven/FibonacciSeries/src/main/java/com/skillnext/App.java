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
        System.out.println( "FibonacciSeries" );
        System.out.println("enter fibonacci number (n>0) :");
        int n = sc.nextInt();
        System.out.println("Below is the fibonacci Series ");
        int f2=0;
        int f1=1;
        int fn;
        if(n==1){
            System.out.println(f2);
        }else if(n==2){
            System.out.println(f2+" "+f1);
        }else{
                System.out.print(f2+" "+f1+" ");
                n=n-2;
                while(n>=0){
                    fn=f1+f2;
                    System.out.print(fn+" ");
                    f2=f1;
                    f1=fn;
                    n--;
                }
        }
        
    }
}
