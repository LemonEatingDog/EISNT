package mine;

import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {

        // scanner
        Scanner scanner = new Scanner(System.in);

        // ask user their age
        System.out.print("How old are you? ");
        // array
        String[] drinks = {"Martinis1", "Beer1", "Vodka1", "Shots1"};

        String[][] shelf = {drinks,{"Vodka", "Shots", "Coffee"}};

        for (int i=0; i < shelf.length; i++){
            for (int j=0; j < shelf[i].length; j++) {
                System.out.println(shelf[i][j]);
            }
            System.out.println("----------------");
        }


        // gather input
        int age = 0;

        try {
            age = scanner.nextInt();
        } catch (Exception ex) {
            System.out.println("Please input a number.");
        }

            // age check
            if (age < 18) {
                System.out.println("You're underage.");
            } else {
                System.out.println("You are of age.");
            }

            // Menu
            System.out.println("Please choose your option: ");

            for (int i = 0; i < drinks.length; i++){
                System.out.println(i + 1 + " - " + drinks[i]);

          }

            // Selection
            System.out.println("1 - Beer");
            System.out.println("2 - Martini");

            //quant
            int martini = 2;
            int beer = 2;

            while (martini > 0 && beer > 0) {

                // gather input
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        if (age < 18) {
                            System.out.println("You're underage, come back another time!.");
                        } else {
                            System.out.println("Enjoy your beer!");
                            beer--;
                        }
                        break;

                    case 2:
                        if (age < 18) {
                            System.out.println("You're underage, come back another time!");
                        } else {
                            System.out.println("Enjoy your Martini!");
                            martini--;
                        }
                        break;

                    default:
                        System.out.println("Option unavailable, please try again!");
                        break;
                }
            }
            int debt = 0;

            do {
                System.out.println("You have " + debt + "€ in debt!");
                System.out.println("How much will you pay?");
                int pay = scanner.nextInt();
                debt -= pay;
            } while (debt > 0);

            System.out.println("Our stock is over!");
            System.out.print("We're about to close...");
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }

            System.out.println("See you soon!");

            scanner.close();
        }

    }
