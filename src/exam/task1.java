package exam;

import java.util.*;


// Пример: Ivan 5, Petr 3, Alex 10, Petr 8, Ivan 6, Alex 5, Ivan 1, Petr 5, Alex 1
// Результат: Petr
// данные вводятся с клавиатуры через запятую

class Task1 {
    public static void main(String[] args) {
        Scanner dis = new Scanner(System.in);

        int counter = 1;
        Map<String, Integer> hm = new HashMap();
        Map<String, Integer> hm_who_is_first = new HashMap();

        String line;
        line = dis.nextLine();

        for (String i : line.split(",")) {
            String[] player = i.trim().split("\\s+");

            String name = player[0];
            int score = Integer.parseInt(player[1]);


            if (!hm.containsKey(name)) {
                hm.put(name, score);
                hm_who_is_first.put(name, 0);
            } else {
                hm.put(name, hm.get(name) + score);
                hm_who_is_first.put(name, hm_who_is_first.get(name) + counter);
            }
            counter += 1;
        }

        int max = Collections.max(hm.values());

        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == max) {
                keys.add(entry.getKey());
            }
        }

        Map<String, Integer> items = new HashMap<>();
        keys.forEach(n -> items.put(n, hm_who_is_first.get(n)));

        int min = Collections.min(items.values());

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            if (entry.getValue() == min) {
                res.add(entry.getKey());
            }
        }

        System.out.print(res.get(0));
    }
}
