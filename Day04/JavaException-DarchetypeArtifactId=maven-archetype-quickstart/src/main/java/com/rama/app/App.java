package com.rama.app;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void validate( int age ) throws VarshaException
    {
        if(age!= 23){
            throw new VarshaException("Not Correct Exception");
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Varsha age: ");
        int x= sc.nextInt();
        try{
            validate(x);
        }
        catch(VarshaException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Invalid Input");
        }
    }
}
