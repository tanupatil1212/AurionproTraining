package com.aurionpro.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.aurionpro.model.Country;

public class CountryTest {

    private static Map<String, Country> countryMap = new HashMap<>();

    public static void main(String[] args) {
        loadCountryData();

        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Enter 1 for Country ID search\n" +
                "Enter 2 for country name search\n" +
                "Enter 3 for region list");

        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                searchCountryById(scanner);
                break;
            case 2:
                searchCountryByName(scanner);
                break;
            case 3:
                searchCountryByRegion(scanner);
                break;
            default:
                System.out.println("Invalid user input");
        }

        scanner.close();
    }

    private static void loadCountryData() {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Aurionpro\\core java\\27-Country\\country.txt"))) {
            String line;                              //hold each line read from the file
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length == 3) {
                    String key = arr[0].trim().replaceAll("\"", "");
                    String value1 = arr[1].trim().replaceAll("\"", "");
                    int value2 = Integer.parseInt(arr[2].trim());
                    countryMap.put(key, new Country(value1, value2));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchCountryById(Scanner scanner) {
        System.out.println("Enter country ID");
        String countryIDFromUser = scanner.next();
        
        Country country = countryMap.get(countryIDFromUser);
        if (country != null) {
            System.out.println("Found");
            System.out.println(countryIDFromUser + " " + country);
        } else {
            System.out.println("Not Found");
        }
    }

    private static void searchCountryByName(Scanner scanner) {
        System.out.println("Enter country Name");
        scanner.nextLine(); // Consume newline
        String countryNameFromUser = scanner.nextLine();
        
        boolean foundFlag = false;
        for (Entry<String, Country> entry : countryMap.entrySet()) {
            if (entry.getValue().getCountryName().equalsIgnoreCase(countryNameFromUser)) {
                System.out.println("Found");
                System.out.println(entry.getKey() + " " + entry.getValue());
                foundFlag = true;
            }
        }
        
        if (!foundFlag) {
            System.out.println("Not Found");
        }
    }

    private static void searchCountryByRegion(Scanner scanner) {
        System.out.println("Enter Region ID");
        int regionIDFromUser = scanner.nextInt();
        
        for (Entry<String, Country> entry : countryMap.entrySet()) {
            if (entry.getValue().getId() == regionIDFromUser) {
                System.out.println("Found");
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
