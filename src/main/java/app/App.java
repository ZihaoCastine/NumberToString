package app;

import convert.ConvertNumberToWord;

import java.util.Scanner;

/**
 * Created by zihaocastine on 6/9/16.
 */
public class App {

    public static void main(String[] args) {
        App app=new App();
        app.run();
    }

    public void run(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a integer (-1 to exit): ");
        String sales=input.next();
        while(!sales.equals(-1)) {
            System.out.println(new ConvertNumberToWord(sales).convert());
            System.out.print("Enter a integer (-1 to exit): ");
            sales = input.next();
        }
    }

}
