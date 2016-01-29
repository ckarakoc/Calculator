

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {

	private static long firstNumbers = 0, lastNumber = 0;
	private static String number = "";

	private static ArrayList<String> numbers = new ArrayList<String>();

	public static void processNumpad(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();

		if (value.matches("[0-9]")) {
			number += value;

			View.getTxt().clear();
			View.getTxt().appendText(number);
		}
	}

	public static void processOperator(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();

		switch (value) {
		case "=":
			calculate();
			break;
		case "+":
			calculateOperators(value);
			break;
		case "-":
			calculateOperators(value);
			break;
		case "/":
			calculateOperators(value);
			break;
		case "x":
			calculateOperators(value);
			break;

		}
	}

	private static void calculateOperators(String value) {
		if (!number.equals("")) {
			firstNumbers = Long.parseLong(number);
			numbers.add(number);
			numbers.add(value);
			System.out.println(numbers);
			number = "";
		}
	}

	private static void calculate() {
		if (!number.equals("")) {
			lastNumber = Long.parseLong(number);
			numbers.add(number);
			System.out.println(numbers);
			number = "";

			String operator = "";
			long number1, number2, answer = 0;
			for (int i = 0; i + 2 < numbers.size(); i++) {
				if ((i & 1) == 0) { // even [i, i+1, i+2]
					number1 = Long.parseLong(numbers.get(i));
					operator = numbers.get(i + 1);
					number2 = Long.parseLong(numbers.get(i + 2));

					// TODO: make a switch statement from this
					if (operator.equals("+")) {
						answer = Math.addExact(number1, number2);
						numbers.set(i + 2, Long.toString(answer));
					}
				}
			}
			System.out.println("answer is: " + answer);
			String test = "";
			//perhaps a way to implement the above calculation
			for (int i = 0; i < numbers.size(); i++) {
				test += numbers.get(i);
			}
			System.out.println("the test is " + test);
			numbers.clear();
		}
	}
}
