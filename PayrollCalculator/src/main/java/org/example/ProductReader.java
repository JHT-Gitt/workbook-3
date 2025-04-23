package org.example;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class ProductReader {

    public static List<Products> readProduct(String filename){

        List<Products> productList = new ArrayList<>();
        try{

            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);

            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts, using comma as the separator
                String[] parts = line.split(",");

                // Check if the line has exactly 4 parts (id, name, price, stock)
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);        // Convert the first part to an integer (ID)
                    String name = parts[1];                     // Get the name as text
                    double price = Double.parseDouble(parts[2]); // Convert price to a decimal number
                    int stock = Integer.parseInt(parts[3]);     // Convert stock to an integer

                    // Create a new Product object using the parts
                    Products p = new Products(id, name, price, stock);

                    // Add the product to the list
                    productList.add(p);
                    System.out.println(p.getName() + " was added");
                }
}
            reader.close();
        }catch (IOException e){
            System.out.println("\nError ! Something went wrong.");

        }

        return productList;
    }


}
