package com.joysis.capstone;

import java.util.Scanner;

public class Capstone1_Yabes {
    static double loadBalance = 200.0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ussdCode();
        while (true){
            try {
                clearScreen();
                mainMenu();
            } catch (Exception e) {
                System.out.println("Invalid Input! Please enter a number");
                input.nextLine(); // Clear Invalid Input
            }
        }

    }

    public static void ussdCode() {
        // validate USSD Code
        System.out.println("Dial *143# to access Smart Services");
        System.out.print("Enter USSD Code: ");
        String ussdCode = input.nextLine();

        if (ussdCode.isEmpty() || !ussdCode.equals("*143#")) {
            System.out.println("Invalid USSD Code. Exiting...");
            System.exit(0); // Exit System
        }

    }

    public static void mainMenu() {
        clearScreen();
        System.out.println("** Load Registration **");
        System.out.println("    [1] Unli Text");
        System.out.println("    [2] Unli Call");
        System.out.println("    [3] Unli Call N Text");
        System.out.println("    [4] Check Balance");
        System.out.println("    [5] Exit");
        System.out.print("Enter choice: ");
        int mainMenuChoice = input.nextInt();

        switch (mainMenuChoice) {
            case 1:
                unliTextPromo();
                break;
            case 2:
                unliCallPromo();
                break;
            case 3:
                unliCallAndTextPromo();
                break;
            case 4:
                checkBalance();
                break;
            default:
                System.out.println("Invalid Choice");
                System.exit(0);
        }
    }

    public static void unliTextPromo(){
        clearScreen();
        System.out.println("-- Enjoy Unli Text --");
        System.out.println("    [1] 1 Day for P10");
        System.out.println("    [2] 3 Days for P30");
        System.out.println("    [3] 5 Days for P50");
        System.out.println("    [4] Back");
        System.out.print("Enter choice: ");
        int unliTextPromoChoice = input.nextInt();

        switch (unliTextPromoChoice) {
            case 1:
                subscriptionConfirmation("1 Day for P10", 1, 10);
                break;
            case 2:
                subscriptionConfirmation("3 Days for P30", 3, 30);
                break;
            case 3:
                subscriptionConfirmation("5 Days for P50", 5, 50);
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    public static void subscriptionConfirmation(String promo, int days, int price) {
        clearScreen();
        System.out.println("-> Get " + promo + " good for " + days + "Day/s for only P" + price);
        System.out.println("    [1] Subscribe");
        System.out.println("    [2] Back");
        System.out.println("    [3] Exit");
        System.out.println("Enter choice: ");
        int confirmationChoice = input.nextInt();

        if (confirmationChoice == 1) {
            if (loadBalance >= price) {
                loadBalance -= price;

                System.out.println("Successfully Subscribed");
                System.out.println("Current Balance: " + loadBalance);

            }

        } else {
            System.out.println("Invalid input!");
        }
    }

    public static void unliCallPromo(){
        clearScreen();
        System.out.println("-- Enjoy Unli Call Promo --");
    }

    public static void unliCallAndTextPromo() {
        clearScreen();
        System.out.println("-- Enjoy Unli Call And Text Promo --");
    }

    public static void clearScreen() {
        System.out.flush();
    }

    public static void checkBalance() {
        clearScreen();
        System.out.println("Your load balance is: P" + loadBalance);
    }





}
