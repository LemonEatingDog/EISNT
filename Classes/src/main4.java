package mine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> convidados = new ArrayList<String>();

        System.out.println("Adiciona um convidado: ");
        String convidadoAdicionado = scanner.nextLine();

        convidados.add(convidadoAdicionado);
        convidados.add("Jonas");

        boolean existe = convidados.contains("Jonas");

        for (String convidado : convidados){
            System.out.println(convidado);
        }

        scanner.close();
    }
}
