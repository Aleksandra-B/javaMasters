package exam;

import java.util.*;

// Пример: входная последовательность 1 2 2 1 1
// Результат: 1
// Входная последовательность 4 2 6 6
// Результат: 2
// данные вводятся с клавиатуры через пробел

class Task2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        String[] numbers = s.split("\\s+");

        List<String> wordList = Arrays.asList(numbers);
        List<Integer> gcdList = new ArrayList<>();

        for (String i : wordList) {
            List<Integer> divList = new ArrayList<>();
            int num1 = Integer.parseInt(i);

            for (String j : wordList) {
                int num2 = Integer.parseInt(j);

                if ((num1 == 0) || (num2 % num1 == 0)) {
                    divList.add(0);
                } else {
                    divList.add(-1);
                }
            }
            ;

            boolean allEqual = (divList.stream().allMatch(divList.get(0)::equals)) && (divList.get(0) != -1);
            if (allEqual) {
                if (num1 != 0) {
                    gcdList.add(num1);
                }
            }
        }

        if (!gcdList.isEmpty()) {
            int min = Collections.min(gcdList);
            System.out.println(min);
        } else {
            System.out.println("-1");
        }
    }
}