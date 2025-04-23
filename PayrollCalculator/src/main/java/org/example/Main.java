package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Products> product = ProductReader.readProduct("products.csv");

        for (Products pro : product){
            System.out.println(pro.getName());
        }




    }
}