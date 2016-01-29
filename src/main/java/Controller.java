import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {

    private static String number = "";
    private static String previousNumber = "0";
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
            numbers.add(number);
            numbers.add(value); //ArrayList: {number (i.e. 0), value (i.e. +))
            number = "";
            System.out.println(numbers);
        } else {
            numbers.add(previousNumber);
            numbers.add(value);
        }
    }

    private static void calculate() { //equals method
        System.out.println("number is:"+number);
        if (!number.equals("")) {
            numbers.add(number);
            number = "";

            String operator = "";
            double number1, number2, answer = 0;
            for (int i = 0; i + 2 < numbers.size(); i++) { // i+2: we skip the last two for no OutOfBoundsException
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
//                            double division = number1 / number2;
//                            double numbersBehindComma;
//                            int amountOfNumbersBehindComma;
//                            if (division < 0) {
//                                numbersBehindComma = division + Math.floor(number1 / number2);
//                                String tempString = Double.toString(numbersBehindComma);
//                                amountOfNumbersBehindComma = tempString.length() - 2;
//                                if (amountOfNumbersBehindComma > 15) {
//                                    int E = amountOfNumbersBehindComma - 15; //12.123456789012345E... <--the E-value
//                                    //15 zero's round up: before point
//                                    answer = (Math.round((number1 / number2) * 1000000000000000.0) / 1000000000000000.0);
//                                    System.out.println(answer);
//                                } else {
//                                    answer = division;
//                                }
//
//                            } else if (division > 0) {
//                                numbersBehindComma = division - Math.ceil(number1 / number2);
//                                String tempString = Double.toString(numbersBehindComma);
//                                amountOfNumbersBehindComma = tempString.length() - 2;
//                                if (amountOfNumbersBehindComma > 15) {
//                                    int E = amountOfNumbersBehindComma - 15; //12.123456789012345E... <--the E-value
//                                    //15 zero's round up: before point
//                                    answer = (Math.round((number1 / number2) * 1000000000000000.0) / 1000000000000000.0);
//                                    System.out.println(answer);
//                                } else {
//                                    answer = division;
//                                }
//
//                            } else if (division == 0) {
//                                System.out.println("[ERROR] CANNOT DIVIDE WITH 0");
//                                break;
//                            }
//
//                            numbers.set(i + 2, Double.toString(answer));
                            break;
                        case "x":
//                            answer = number1 * number2;
//                            numbers.set(i + 2, Double.toString(answer));
//                            break;
                    }
                }
            }
            System.out.println("answer is: " + answer);
            previousNumber = Double.toString(answer);
            numbers.clear();
//            numbers.add(Double.toString(answer));
//            System.out.println(numbers);
        }
    }
}
