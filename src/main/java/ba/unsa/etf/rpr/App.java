package ba.unsa.etf.rpr;

import java.util.Scanner;

/**
 * @author Faris Ćosić
 * @version 1.0
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Unesite izraz: ");
        Scanner u = new Scanner(System.in);
        String s = u.nextLine();
        System.out.println("Rezultat je: ");
        ExpressionEvaluator eksp = new ExpressionEvaluator();

        try{
            System.out.println(eksp.evaluate(s));
        }catch (RuntimeException e){
            e.getMessage();
        }
    }
}
