package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        String[] names = {
                "Ezra", "Elisha", "Ian",
                "Siddalee", "Pursalane", "Zephaniah"
        };
        boolean success = false;

        while (!success) {
            try {
                System.out.print("Pick a kid (select #1 - #6): ");
                int index = scanner.nextInt();
                scanner.nextLine(); // clear newline

                if (index < 1 || index > 6) {
                    System.out.println(" Number out of range. Pick between 1 and 6.");
                    continue;
                }

                index--;
                System.out.println(" You picked: " + names[index]);
                success = true;

            } catch (InputMismatchException e) {
                System.out.println(" Not a valid number. Please enter digits only.");
                scanner.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("⚠️ Something else went wrong: " + e.getMessage());
                scanner.nextLine();
            }
        }

        scanner.close();



//        int index = 0;
//
//while(index < 1 || index > 6){
//    try {
//        String[] names = {
//                "Ezra", "Elisha", "Ian",
//                "Siddalee", "Pursalane", "Zephaniah"
//        };
//        System.out.print("Pick a kid (select #1 - #6): ");
//        index = scanner.nextInt();
//
//        if(index < 1 || index > 6){
//            System.out.println("number is out of range");
//            continue;
//        }
//
//        index--;
//        System.out.println(names[index-1]);
//    }
//    catch (ArrayIndexOutOfBoundsException e){
//        System.out.println("Your number was out of range!");
//    }
//    catch (InputMismatchException e){
//        System.out.println("Your number was a miss match");
//    } catch (Exception e) {
//        System.out.println("Something went wrong");
//    }
//    scanner.close();
//}

//        try {
//            int result = 10 / 0;
//
//            System.out.println("Result: " + result);
//        } catch (ArithmeticException e) {
//            System.out.println("⚠️ Oops! You can't divide by zero.");
//           // e.printStackTrace();
//        }
//
//        System.out.println("Program continues after handling the error.");
    }
}