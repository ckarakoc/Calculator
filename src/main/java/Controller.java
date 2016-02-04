import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {

    private static String number = "";
    private static String previousNumber = "0";
    private static ArrayList<String> numbers = new ArrayList<String>();
    private static boolean commaAlreadyUsed;
    private static double answer = 0;

    /**
     * Gets the string {@code value} from withing the button (i.e. '+', '-', etc.).
     * Stores those values inside {@code number} and appends the {@code value} to the view.
     *
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
     *
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


    public static void processComma() {
        if (!number.equals("") && !commaAlreadyUsed) {
            number += ".";
            commaAlreadyUsed = true;

            View.getTxt().appendText(".");
        }
    }

    /**
     * The {@code number} and the {@code value} is stored within an ArrayList.
     * After that the {@code number} is set to an empty string.
     *
     * @param value
     */
    private static void calculateOperators(String value) {
        if (!number.equals("")) {
            numbers.add(number);
            numbers.add(value); //ArrayList: [{number (i.e. 0)}, {value (i.e. +)}]
            number = "";
            System.out.println("[INFO] The current state of the ArrayList: " + numbers);

            commaAlreadyUsed = false;
            View.getTxt().appendText(" " + value + " ");
        } else if (!value.matches("x") && !value.matches("/")) { //TODO MAKE THIS BETTER!
//            if (numbers.size() == 2) {
            numbers.add(previousNumber);
            numbers.add(value);
            System.out.println("[INFO] The current state of the ArrayList: " + numbers);
            View.getTxt().appendText(previousNumber + " " + value + " ");
//            }
        }
    }


    //TOO LAZY TO WRITE JAVADOC SIGH!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private static void calculate() { //equals method
        if (!number.equals("")) {
            numbers.add(number);
            number = "";
            commaAlreadyUsed = false;
            System.out.println("[INFO] The current state of the ArrayList: " + numbers);

            // x and / come before + and -
            calculationMulDiv();
            calculationSubAdd();

            System.out.println("[INFO] The answer to the equation is: " + answer + "\n");
            View.getTxt2().setText(Double.toString(answer));
            previousNumber = Double.toString(answer);
            numbers.clear();
            View.getTxt().clear();
        }
    }

    private static void calculationMulDiv() {
        String operator;
        double number1, number2;
        for (int i = 0; i + 1 < numbers.size(); i++) {
            if (!((i & 1) == 0)) {
                operator = numbers.get(i);
                switch (operator) {
                    case "x":
                        number1 = Double.parseDouble(numbers.get(i - 1)); // number before the x
                        number2 = Double.parseDouble(numbers.get(i + 1)); // number after the x
                        answer = number1 * number2;
                        numbers.set(i - 1, Double.toString(answer)); // storing the answer in [i-1]
                        numbers.remove(i);
                        numbers.remove(i); //removing the empty spaces in the arraylist
                        break;
                    case "/":
                        number1 = Double.parseDouble(numbers.get(i - 1)); // number before the x
                        number2 = Double.parseDouble(numbers.get(i + 1)); // number after the x
                        answer = number1 / number2;
                        numbers.set(i - 1, Double.toString(answer)); // storing the answer in [i-1]
                        numbers.remove(i);
                        numbers.remove(i); //removing the empty spaces in the arraylist
                        break;
                }
            }
        }
    }

    private static void calculationSubAdd() {
        String operator;
        double number1, number2;
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
                }
            }
        }
    }

    //getter and setters
    public static ArrayList<String> getNumbers(){
        return numbers;
    }
}
