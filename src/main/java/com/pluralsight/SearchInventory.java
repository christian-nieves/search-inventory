package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        for (Product product : inventory) {
            System.out.println(product);

        }
    }

    public static ArrayList<Product> getInventory() throws FileNotFoundException {
        ArrayList<Product> inventory = new ArrayList<>();

        String fileName = "inventory.csv";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split("\\|");

                int id = Integer.parseInt(info[0]);
                String name = info[1];
                float price = Float.parseFloat(info[2]);

                Product product = new Product(id, name, price);
                inventory.add(product);
            }



        } catch (Exception ex) {
            System.out.println("An error has occurred, please try again.");
        }



        return inventory;
    }
}
