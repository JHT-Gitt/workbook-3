package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

//        List<Products> product = ProductReader.readProduct("products.csv");
//
//        for (Products pro : product){
//            System.out.println(pro.getName());
//        }
        String input, inputTxt, text;
        System.out.print("Enter the name of the file employee file to process: ");
        input = scanner.nextLine();
        List<Employee> employees = EmployeeReader.showEmployee(input);
        List<Employee> grossPayEmployee = new ArrayList<>();
//    for(Employee e : employees){
//
//        System.out.printf("Employee ID: %d", e.getEmployeeID());
//        System.out.printf("\nEmployee Name: %s", e.getName());
//        System.out.printf("\nEmployee Gross Pay: %.2f \n\n", e.getGrossPay());
//
//    }
        for (Employee e : employees) {
            int newID = e.getEmployeeID();
            String newname = e.getName();
            float grossPay = e.getGrossPay();

            Employee employeeGrossPay = new Employee(newID, newname, grossPay);

            grossPayEmployee.add(employeeGrossPay);
        }
        try {
            System.out.print("Enter the name of the payroll file to create(.csv): ");
        inputTxt = scanner.nextLine();
        FileWriter fileWriter = new FileWriter(inputTxt);
        BufferedWriter bufWriter = new BufferedWriter(fileWriter);

        for(Employee ee : grossPayEmployee){
            text = String.format("%s|%s|%s\n", ee.getEmployeeID(),ee.getName(),ee.getGrossPayment());
            bufWriter.write(text);
        }
        bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();
        }

    }
}