package controller;

import model.Vare;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kasseapparat {

    public static void printBon(List<String> kurv, Map<String, Vare> normalVare, Map<String, Vare> tilbudVare) {

        Map<String, Integer> amount = new HashMap<>();

        for (String ean : kurv) {
            // Integer::sum adds the ean to my amount hashmap, and if it already exists, it adds another
            amount.merge(ean, 1, Integer::sum);
        }


        double total = 0;
        double totalDiscount = 0;
        System.out.println("======= KASSEBON =======");

        for (var k : amount.entrySet()) {
            String id = k.getKey();
            int quantity = k.getValue();

            Vare normal = normalVare.get(id);
            if (normal == null) {
                System.out.println("FEJL: varen findes ikke i normalMap" + id);
                continue;
            }
            Vare discounted = tilbudVare.getOrDefault(id, normal);

            double price = discounted.getPrice();
            double totalPrice = quantity * price;

            System.out.println(normal.getName());
            System.out.printf(quantity + " x " + price + " = %.2f kr.\n",  totalPrice);

            if (discounted != normal) {
                double discount = (normal.getPrice() - discounted.getPrice()) * quantity;
                totalDiscount += discount;
                System.out.printf("SAVED: -%.2f kr.\n", discount);
            }
            System.out.println("");
            total += totalPrice;
        }

        double moms = total * 0.2;

        System.out.println("=================================");
        System.out.printf("TOTAL: %.2f kr.\n", total);
        System.out.printf("MOMS: %.2f kr.\n", moms);
        System.out.printf("TOTAL DISCOUNT: %.2f kr.\n", totalDiscount);
        System.out.println("=================================");

    }
}
