package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void main(String[] args) throws InputMismatchException {
        boolean isAgain = false;
        boolean isSearch = false;
        Scanner scanner = new Scanner(System.in);
while(!isAgain) {
    try {
        loadInventory();

        System.out.print("\nEnter the product ID: ");
        int id = scanner.nextInt();


        Product matchedProduct = inventory.get(id);
        if (matchedProduct == null) {
            System.out.println("\nID not found");

        }else{
            System.out.printf("\nWe carry %s and the price is $%.2f\n",
                    matchedProduct.getName(), matchedProduct.getPrice());
            isSearch = false;
        }
    } catch (InputMismatchException e) {
        System.out.println("\nInvalid Input");
        isSearch = false;
    }

    while(!isSearch) {
        scanner.nextLine();
        System.out.print("\nDo you want to search again ? [y/n]: ");
        String search = scanner.next().toLowerCase();
        if (search.equalsIgnoreCase("n")) {
            System.out.println("\nGoodbye");
            isAgain = true;
            isSearch = true;
        } else if (search.equalsIgnoreCase("y")) {
            isSearch = true;
            }
    }

}
    }
    public static void loadInventory(){
        try{
            BufferedReader buff = new BufferedReader(new FileReader("inventory.csv"));

            String line;
            while((line = buff.readLine()) !=null){
                String[] token = line.split("\\|");
                if(token.length == 3){
                    int id = Integer.parseInt(token[0]);
                    String name = token[1];
                    float price = Float.parseFloat(token[2]);

                    inventory.put(id, new Product(id,name,price));

                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        }
        catch (IOException e) {
            System.out.println("\nError ! File is not found.");
        }

    }


}