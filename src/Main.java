import controller.Kasseapparat;
import controller.Robot;
import model.Vare;
import util.FileIO;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Vare> alleVarer = FileIO.readFile("data/varer.csv");
        List<Vare> tilbudVarer = FileIO.readFile("data/tilbud.csv");

        Map<String, Vare> normalMap = new HashMap<>();
        for (Vare v : alleVarer) {
            normalMap.put(v.getEan(), v);
        }
        Map<String, Vare> tilbudMap = new HashMap<>();
        for (Vare v : tilbudVarer) {
            tilbudMap.put(v.getEan(), v);
        }

        Robot robot = new Robot();

        List<String> basket = robot.fyldIKurv(alleVarer);

        Kasseapparat.printBon(basket, normalMap, tilbudMap);
    }
}
