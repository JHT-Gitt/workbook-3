package com.pluralsight;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int easyNumber = (int)(Math.random() * 10) + 1;
        int hardNumber = (int)(Math.random() * 100) + 1;
        int input, enter;
        int tries = 5;
        boolean isFound= false;

    while(!isFound) {
    try {
        System.out.println("\n----GUESSING GAME----");
        System.out.println(" 1 - Easy mode");
        System.out.println(" 2 - Hard Mode");
        System.out.print("Your Choice ? : ");
        input = scanner.nextInt();

        switch (input){
            case 1:
                while(!isFound) {
                    System.out.println("\n--EASY MODE--");
                    System.out.print("\nEnter a number between 1 and 10: ");
                    enter = scanner.nextInt();
                    scanner.nextLine();
                    if(enter < 1 || enter > 10){
                        System.out.println("\nChoose only between 1 and 10");
                        continue;
                    }
                    if (enter == easyNumber) {
                        System.out.println("\nWow ! You guessed it right");
                        isFound = true;
                    } else if (enter < easyNumber) {
                        System.out.println("\nOops ! Too low !");
                    } else if (enter > easyNumber){
                        System.out.println("\nAargh ! Too high !");
                    }
                }
            case 2:

                    System.out.println("--Hard Mode--");
                    System.out.println("YOU'RE A BRAVE LAD");
                while(!isFound) {

                    if(tries == 0){
                        System.out.println("The number youre looking for is .... " + hardNumber);
                        System.out.println("\nYOU HAVE NO MORE TRIES LEFT !!!\nYOU SUCKKKK");
                        break;
                    }
                    System.out.println("\n" + tries + " tries left");
                    System.out.print("\nEnter a number between 1 and 100: ");
                    enter = scanner.nextInt();
                    if(enter < 1 || enter > 100){
                        System.out.println("\nChoose only between 1 and 10");
                        continue;
                    }

                    if (enter == hardNumber) {
                        System.out.println("\nWow ! You guessed it right");
                        isFound = true;
                    }
                    else if(enter < hardNumber){
                        System.out.println("\nToo Low");
                        tries--;
                        //System.out.printf(tries + " tries left");

                    }else if(enter > hardNumber){
                        System.out.println("\nToo high");
                        tries--;
                        //System.out.printf(tries + " tries left");

                    }


                }

        }














    } catch (InputMismatchException e) {
        System.out.println(" Not a valid number. Please enter digits only.");
        scanner.nextLine(); // clear invalid input
    } catch (Exception e) {
        System.out.println("⚠️ Something else went wrong: " + e.getMessage());
        scanner.nextLine();
    }
}





        scanner.close();
    }

//    public void menu(){
//        int input;
//
//        System.out.println("----GUESSING GAME----");
//        System.out.println(" 1 - Easy mode");
//        System.out.println(" 2 - Hard Mode");
//        System.out.println("Your Choice ? : ");
//        input = scanner.nextInt();
//
//        switch (input){
//            case 1:
//
//        }
//
//
//    }

}

