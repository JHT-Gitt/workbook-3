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

        System.out.printf("Employee ID: %d", e.getEmployeeID());
        System.out.printf("Employee Name: %s", e.getName());
       // System.out.println("Employee Gross Pay: %.2f", e.getGrossPay());

    }




    }
}