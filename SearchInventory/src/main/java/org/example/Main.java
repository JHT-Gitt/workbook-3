package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String file = "inventory.csv";
        ArrayList<Product> inventory = ShowInventory.getInventory(file);

        ShowInventory.menu();
        
//        System.out.println("We carry the following inventory: ");
//
//        for (int i = 0; i < inventory.size(); i++) {
//            Product p = inventory.get(i);
//            inventory.sort(Comparator.comparing(Product::getName));
//            System.out.printf("id: %d - Name: %s - Price: $%.2f\n",
//                    p.getId(), p.getName(), p.getPrice());
//        }
    }
//    public static ArrayList<Product> getInventory(String file) {
//        ArrayList<Product> inventory = new ArrayList<>();
//        try{
//            BufferedReader buff = new BufferedReader(new FileReader(file));
//
//            String line;
//            while((line = buff.readLine()) != null){
//                String[] token = line.split("\\|");
//                if(token.length ==3){
//                    int id = Integer.parseInt(token[0]);
//                    String name = token[1];
//                    float price = Float.parseFloat(token[2]);
//
//                    Product pro = new Product(id,name,price);
//                    inventory.add(pro);
//                }
//            }
//            buff.close();
//        }catch (IOException e) {
//            System.out.println("\nError ! File is not found.");
//        }
//        return inventory;
//    }



}