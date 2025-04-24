package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InventorySearch {

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
