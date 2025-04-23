package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        List<Products> product = ProductReader.readProduct("products.csv");
//
//        for (Products pro : product){
//            System.out.println(pro.getName());
//        }

    List<Employee> employees = EmployeeReader.showEmployee("employee.csv");

    for(Employee e : employees){

        System.out.printf("\n\nEmployee ID: %d", e.getEmployeeID());
        System.out.printf("\nEmployee Name: %s", e.getName());
        System.out.printf("\nEmployee Gross Pay: %.2f", e.getGrossPay());

    }




    }
}