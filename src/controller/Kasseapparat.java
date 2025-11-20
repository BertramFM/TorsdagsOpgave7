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

        for (var entry : amount.entrySet()) {
            String id = entry.getKey();
            int quantity = entry.getValue();

            Vare normal = normalVare.get(id);
            Vare discounted = tilbudVare.getOrDefault(id, normal);

            double price = discounted.getPrice();
            double totalPrice = quantity * price;

            System.out.println(normal.getName());
            System.out.println(quantity + " x " + price + " = " + totalPrice);

            if (discounted != normal) {
                double discount = (normal.getPrice() - discounted.getPrice()) * quantity;
                totalDiscount += discount;
                System.out.println("SAVED: -" + discount);
            }

            total += totalPrice;
        }

        double moms = total * 0.2;

        System.out.println("=================================");
        System.out.println("TOTAL: " + total);
        System.out.println("MOMS: " + moms);
        System.out.println("TOTAL DISCOUNT: " + totalDiscount);
        System.out.println("=================================");

    }
}
