/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medic;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author anthony
 */
public class Question {

	// instance field
	public int num1;
	public int num2;
	public char operator;

	// constructors
	public Question() {

	}
//	public String generateQuestion(){
//		
//}
	private int generateNumber(int range){
		Random generator = new Random();
		int i = generator.nextInt(range);
		return i;
	}
	private double generateQuestion(){
		double correctResult = 0;
	}
	public boolean isDuplicated(ArrayList<Question> QuestionList) {
		for (Question question : QuestionList) {
			if (this.operator == question.operator) {
				return false;
			} else if (this.num1 == question.num1 || this.num1 == question.num2 || this.num2 == question.num1 || this.num2 == question.num2) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}


}
