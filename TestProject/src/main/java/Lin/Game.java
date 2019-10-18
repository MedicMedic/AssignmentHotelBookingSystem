package mathquiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private int questionNum = 10;
    private Question question;
    private Map<String, Double> map;
    private User user;

    public Game() {

    }

    public void getQuestion() {
        question = new Question(questionNum);
        map = new HashMap<>();
        map = question.getMap();
    }

    public void startGame() {
        getQuestion();
        Scanner scan = new Scanner(System.in);
        Double answer;

        System.out.println("Please input your first name:");     
        String name = scan.nextLine();
        user = new User(name);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=");
            answer = scan.nextDouble();

            int flag = checkAnswer(answer, entry.getValue());
            if (flag == 1) {
                System.out.println("Answer correct!");
                user.setScore(user.getScore()+10);
            } else {
                System.out.println("Sorry, you are wrong.");
                user.setScore(user.getScore()-10);
            }
        }
        user.writeFile();
    }

    public int checkAnswer(double uAnswer, double cAnswer) {
        if (Math.abs(uAnswer - cAnswer) <= 0.1) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

}
