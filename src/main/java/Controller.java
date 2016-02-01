import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {

    private static String number = "";
    private static String previousNumber = "0";
    private static ArrayList<String> numbers = new ArrayList<String>();

    /**
     * Gets the string {@code value} from withing the button (i.e. '+', '-', etc.).
     * Stores those values inside {@code number} and appends the {@code value} to the view.
     * @param event
     */
    public static void processNumpad(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (value.matches("[0-9]")) {
            number += value;

            View.getTxt().appendText(value);
        }
    }

    /**
     * The process of each operator (.i.e. '+', '-', '*', etc.) represented by {@code value}.
     * @param event
     */
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

    /**
     * The {@code number} and the {@code value} is stored within an ArrayList.
     * After that the {@code number} is set to an empty string.
     * @param value
     */
    private static void calculateOperators(String value) {
        if (!number.equals("")) {
            numbers.add(number);
            numbers.add(value); //ArrayList: [{number (i.e. 0)}, {value (i.e. +)}]
            number = "";
            System.out.println("[INFO] The current state of the ArrayList: " + numbers);

            View.getTxt().appendText(" " + value + " ");
        } else {
            numbers.add(previousNumber);
            numbers.add(value);
            System.out.println("[INFO] The current state of the ArrayList: " + numbers);

            if(numbers.size() == 2)
                View.getTxt().appendText(previousNumber + " " + value + " ");
        }
    }


    //TOO LAZY TO WRITE JAVADOC SIGH!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private static void calculate() { //equals method
        if (!number.equals("")) {
            numbers.add(number);
            number = "";
            System.out.println("[INFO] The current state of the ArrayList: " + numbers);

            String operator;
            double number1, number2, answer = 0;
            for (int i = 0; i + 2 < numbers.size(); i++) { // i+2: we skip the last two: so no OutOfBoundsException
                if ((i & 1) == 0) { // even [i, i+1, i+2]
                    number1 = Double.parseDouble(numbers.get(i));
                    operator = numbers.get(i + 1);
                    number2 = Double.parseDouble(numbers.get(i + 2));

                    switch (operator) {
                        case "+":
                            answer = number1 + number2;
                            numbers.set(i + 2, Double.toString(answer));
                            break;
                        case "-":
                            answer = number1 - number2;
                            numbers.set(i + 2, Double.toString(answer));
                            break;
                        case "/":
                            answer = number1 / number2;
                            numbers.set(i + 2, Double.toString(answer));
                            break;
                        case "x":
                            answer = number1 * number2;
                            numbers.set(i + 2, Double.toString(answer));
                            break;
                    }
                }
            }
            System.out.println("[INFO] The answer to the equation is: " + answer + "\n");
            View.getTxt2().setText(Double.toString(answer));
            previousNumber = Double.toString(answer);
            numbers.clear();
            View.getTxt().clear();
        }
    }
}
