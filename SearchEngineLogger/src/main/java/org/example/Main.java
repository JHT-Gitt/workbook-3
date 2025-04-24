package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter timeToday = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String getDate = today.format(timeToday);
        boolean isExited = false;
        String log = "logs.txt";

        try{
            FileWriter writer = new FileWriter(log);
            BufferedWriter buff = new BufferedWriter(writer);

            writer.write(getDate + " launch\n");

            while(!isExited){
                System.out.print("Enter a search term (X to exit):");
                String search = scanner.nextLine();
                if(search.equalsIgnoreCase("x")){
                    writer.write(getDate + " exit");
                    isExited = true;
                }else{
                    writer.write(getDate + " search : " + search + "\n");
                }
            }
        buff.close();
        } catch (InputMismatchException e) {
            System.out.println("Error: Wrong input");
        }
        catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();
        }







    }
}