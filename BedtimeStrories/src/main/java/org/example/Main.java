package org.example;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;

public class Main {
   public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    String input;
    boolean success = false;
        try {
            FileInputStream docs = new FileInputStream("goldilocks.txt");
            Scanner scanner = new Scanner(docs);

            while (scanner.hasNextLine()){
                System.out.println("Enter the name of a Story: ");
                input = scanner.next().toLowerCase();
            }

        }catch (IOException e){

        }

        scanner.close();
    }



}