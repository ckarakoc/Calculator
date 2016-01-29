import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Model {

	private long answer;

	public long calculate(long number1, long number2, String operator) {
		switch (operator) {
		case "+":
			return addNumbers(number1, number2);
		case "-":
			return number1 - number2;
		case "*":
			return number1 * number2;
		case "/":
			if (number2 == 0)
				return 0;

			return number1 / number2;
		}

		System.out.println("Unknown operator - " + operator);
		return 0;
	}
	
	// ARITHMATIC----------------------------------------------------------
	public long addNumbers(long a, long b){
		answer = Math.addExact(a, b);
		return answer;
	}


}
