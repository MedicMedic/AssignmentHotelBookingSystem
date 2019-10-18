package mathquiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Question {

    private Map<String, Double> map;

    public Question(int n) {
        generateQuestion(n);
    }

    public void generateQuestion(int n) {
        double correctResult = 0;
        int operator;
        String opStr = "";
        int num1 = 0, num2 = 0;
        String question;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            num1 = generateNumber(100);
            num2 = generateNumber(100);
            operator = generateNumber(4);
            switch (operator) {
                case 0:
                    correctResult = num1 + num2;
                    opStr = " + ";
                    break;
                case 1:
                    correctResult = num1 - num2;
                    opStr = " - ";
                    break;
                case 2:
                    correctResult = num1 * num2;
                    opStr = " * ";
                    break;
                default:
                    while (num2 == 0) {
                        num2 = generateNumber(100);
                    }
                    correctResult = 1.0 * num1 / num2;
                    opStr = " / ";
                    break;
            }
            question = num1 + opStr + num2;
            if (map.get(question) != null) {
                n++;
            } else {
                map.put(num1 + opStr + num2, correctResult);
            }
        }

    }

    public int generateNumber(int range) {
        Random generator = new Random();
        int i = generator.nextInt(range);
        return i;
    }

    public Map<String, Double> getMap() {
        return map;
    }
}
