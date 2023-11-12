package mine;

import java.util.Objects;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        // Recolher input user
        Scanner scanner = new Scanner(System.in);

        // Pedir nome ao user
        System.out.print("Please input your name: ");

        // Recolher nome
        String name = scanner.nextLine();

        // Mostrar
        System.out.println("Welcome " + name + " to our app!");

        // Pedir ano nascimento
        System.out.print("When were you born? ");

        // Recolher ano nascimento
        String year = scanner.nextLine();

        int yearInt = Integer.parseInt(year);

        int age = 2023 - yearInt;

        System.out.println("You're " + age + " years old!");

        // Verif idade e se é velho
        int idadeVelho = 100;
        boolean velho = age > idadeVelho;

        System.out.println("It's " + velho + " that you're old!");

        // Verif nome diff manuel
        boolean nameManuel = !name.equals("Manuel");

        System.out.println("It's " + nameManuel + " that you're not Manuel!");

        // Verif acima de idade media
        boolean avgAge = age == 30;

        System.out.println("It's " + avgAge + " that you're above average age!");

        //
        boolean notManuelnotAvgAge = nameManuel && !avgAge;

        System.out.println("It's " + notManuelnotAvgAge + " that you're not Manuel and you're not above average age!R");

        scanner.close();
    }
}
