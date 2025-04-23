package org.example;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class Main {
   public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int input;
        boolean success = false;

        while (!success) {

            System.out.println("\n--Bed Time Stories--");
            System.out.println(" 1 - Goldilocks");
            System.out.println(" 2 - Hansel and Gretel");
            System.out.println(" 3 - Mary had a Little Lamb");
            System.out.println(" 0 - Exit");
            System.out.print("What do you wanna read ?: ");
            input = scanner.nextInt();

            try {
            switch (input){
                case 1:
                    System.out.println("\n");
                    bedStory("goldilocks.txt");
                   // success = true;
                    break;
                case 2:
                    System.out.println("\n");
                    bedStory("hansel_and_gretel.txt");
                  //  success = true;
                    break;
                case 3:
                    System.out.println("\n");
                    bedStory("mary_had_a_little_lamb.txt");
                    //success = true;
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("\nWrong input\n");
            }

            } catch (InputMismatchException e) {

            } catch (FileNotFoundException e) {
                //throw new RuntimeException(e);
            }catch (IllegalStateException e){

            }


        }
        scanner.close();
    }
    public static void bedStory(String story) throws FileNotFoundException {
        FileInputStream txt = new FileInputStream(story);
        Scanner scanner = new Scanner(txt);

        String input;
        while(scanner.hasNextLine()) {
            input = scanner.nextLine();
            System.out.println(input);
        }


    }



}