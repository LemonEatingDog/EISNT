package mine;

import java.util.*;

public class main5 {
    public static void main(String[] args) {
        Map<String, Double> banco = new HashMap<String, Double>();

        banco.put("Jonas",300.00);
        banco.put("Tania",800.00);
        banco.put("Fernando",1000.00);

        banco.forEach((k, v) -> {
            System.out.print(k + " ");
            System.out.println(v + " ");
        });

        banco.put("Tania", 900.0);

        Double valorTania = banco.get("Tania");
        System.out.println("A Tania tem " + valorTania + "€ no banco");

        banco.clear();

        if (banco.isEmpty()) {
            System.out.println("Banco está vazio");
        }

        Set<Integer> notas = new HashSet<Integer>();
        notas.add(5);
        notas.add(10);
        notas.add(20);
        notas.add(50);

        List<Integer> verificaNotas = new ArrayList<>();

        verificaNotas.add(5);
        verificaNotas.add(50);

        boolean verdade = notas.containsAll(verificaNotas);

        System.out.println(verdade);
    }
}
