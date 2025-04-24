package org.example;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class EmployeeReader {

    public static List<Employee> showEmployee(String fileName) {


        List<Employee> employees = new ArrayList<>();
        try {
           BufferedReader buffRead = new BufferedReader(new FileReader(fileName));

            buffRead.readLine();
            String line;
            while((line = buffRead.readLine()) != null){
                String[] token = line.split("\\|");
                if(token.length == 4){
                    int id = Integer.parseInt(token[0]);
                    String name = token[1];
                    float hoursW = Float.parseFloat(token[2]);
                    float rate = Float.parseFloat(token[3]);

                    Employee employ = new Employee(id,name,hoursW,rate);

                    employees.add(employ);

                }
            }
            buffRead.close();
        } catch (IOException e) {
            System.out.println("\nError ! File is not found.");
            System.exit(0);
        }

       return employees;
    }
}
