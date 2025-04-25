package org.example;

import javax.swing.plaf.ButtonUI;
import java.io.*;
import java.util.*;

public class ShowInventory {

public static Scanner scanner = new Scanner(System.in);

   public static ArrayList<Product> inventory = new ArrayList<>();
    public static ArrayList<Product> getInventory(String file) {

        try{
            BufferedReader buff = new BufferedReader(new FileReader(file));

            String line;
            while((line = buff.readLine()) != null){
                String[] token = line.split("\\|");
                if(token.length ==3){
                    int id = Integer.parseInt(token[0]);
                    String name = token[1];
                    float price = Float.parseFloat(token[2]);

                    Product pro = new Product(id,name,price);
                    inventory.add(pro);
                }
            }
            buff.close();
        }catch (IOException e) {
            System.out.println("\nError ! File is not found.");
        }
        return inventory;
    }

    public static void menu(){
            int choice;
        boolean istrue = false;

        System.out.println("\nWhat do you want to do?\n" +
                "1- List all products\n" +
                "2- Lookup a product by its id\n" +
                "3- Find all products within a price range\n" +
                "4- Add a new product\n" +
                "5- Quit the application");
        while(!istrue){
            try{
        System.out.print("\nEnter your choice: ");

        choice = scanner.nextInt();
        switch (choice){
            case 1:
                InventoryShow("inventory.csv");

            case 2:
                IdSearch("inventory.csv");
            case 3:
                FindPriceRange("inventory.csv");
            case 4:
                AddProduct("inventory.csv");
            case 5:
                System.exit(0);
            default:
                System.out.println("\nEnter between 1 and 5 only");
        }
            } catch (InputMismatchException e) {
                System.out.println("\nError ! Invalid Input !");
                scanner.nextLine();
            }

        }
    }

    private static void AddProduct(String file) {

       // ArrayList<Product> inventory = getInventory(file);

        try {

            System.out.print("\nEnter Product ID : ");
            int id = scanner.nextInt();
            System.out.print("Enter Product Name : ");
            String name = scanner.next();
            System.out.print("Enter Product Price: ");
            float price = scanner.nextFloat();

            Product productEntry = new Product(id,name,price);
            // String productEntry = String.format("%d",id) + "|" + name + "|" + String.format("%.2f", price);
           inventory.add(productEntry);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(Product product : inventory){
                writer.write(String.format("%d|%s|%.2f",product.getId(),product.getName(),product.getPrice()));
               // writer.newLine();
            }
            System.out.println("\nProduct is added");

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        menu();

    }

    private static void FindPriceRange(String file) {
        boolean isTrue = false;
      //  ArrayList<Product> inventory = getInventory(file);
        while(!isTrue){
            try{
            System.out.print("\nEnter the minimum Price: ");
            float minPrice = scanner.nextFloat();
            System.out.print("Enter the maximum Price: ");
            float maxPrice = scanner.nextFloat();
            if(minPrice>maxPrice){
                System.out.println("\nMinimum Price must be smaller than Maximum Price");
                FindPriceRange(file);
            }

                for (Product product : inventory) {
                    float priceSearch = product.getPrice();
                    if(minPrice <=priceSearch && maxPrice >= priceSearch) {
                        //inventory.sort(Comparator.comparing(Product::getName));
                        System.out.printf("\nid: %d - Name: %s - Price: $%.2f\n", product.getId(), product.getName(), product.getPrice());
                        isTrue = true;

                    }
                }
                if(!isTrue){
                    System.out.println("\nNo Product found within the inputted price range");
                }else{
                    menu();
                }
            } catch (InputMismatchException e) {
                System.out.println("\nWrong input");
                scanner.nextLine();
            }
        }
    }

    private static void IdSearch(String file) {
      //  ArrayList<Product> inventory = getInventory(file);
        boolean isTrue = false;
        while(!isTrue) {
            try {
                System.out.print("Enter the product ID: ");
                int idsearch = scanner.nextInt();

                for (Product product : inventory) {
                    int id = product.getId();
                    if (id == idsearch) {
                        //inventory.sort(Comparator.comparing(Product::getName));
                        System.out.printf("\nid: %d - Name: %s - Price: $%.2f\n", product.getId(), product.getName(), product.getPrice());
                        isTrue = true;
                    }
                }
                if(!isTrue){
                        System.out.println("\nProduct ID not found.");
                }else{
                    menu();
                }
            }catch (InputMismatchException e){
                System.out.println("\nInvalid Input");
                scanner.nextLine();

            } catch (ConcurrentModificationException e) {
                System.out.println("\nError ! input a number only.");
                scanner.nextLine();
            }
        }

    }

    public static void InventoryShow(String file){

       // ArrayList<Product> inventory = getInventory(file);

                for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            inventory.sort(Comparator.comparing(Product::getName));
            System.out.printf("\nid: %d - Name: %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
        menu();
    }


}
