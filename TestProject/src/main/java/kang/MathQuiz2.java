/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kang;

import java.util.Scanner;

/**
 *
 * @author woc
 */
public class MathQuiz2 extends MathQuiz {
     public static void main(String[] args) {
        int score = 0;
        int rounds = 3;

        mathquiz.MathQuiz quiz = new mathquiz.MathQuiz();

        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean terminate = false;
        for (int round = 0; round < rounds; ++round) {
            System.out.println("Round " + (round + 1));
            //好吧。
            double correctAnswer =()-> new Question();
//                    quiz.generateQuestion();
            double uAnswer = 0d;
            boolean valid = false;
            do {
                userInput = scanner.nextLine();
                if (userInput.trim().equals("x")) {
                    terminate = true;
                    break;
                }
                try {
                    uAnswer = Double.parseDouble(userInput.trim());
                    valid = true;
                } catch (NumberFormatException e) {
                    valid = false;
                    System.out.println("The input is invalid, please enter the answer again.");
                }
            } while (!valid);
            if (terminate) {
                break;
            }
            if (quiz.checkAnswer(uAnswer, correctAnswer) == 1) {
                System.out.println("Answer correct!");
                score += 10;
            } else {
                System.out.println("Sorry, you are wrong.");
                score -= 10;
            }
        }

        System.out.println("You got: " + score);

    }
    
}
