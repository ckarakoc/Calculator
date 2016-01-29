import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class View extends Application {

	private Button one, two, three, four, five, six, seven, eight, nine, zero, plus, min, keer, delen, comma, equals,
			percent, wortel;
	private boolean add, substract, multiply, divide;
	public Rectangle screen;
	static TextField txt;
	TextField txt2;

	private long x, y;
	private static String number = "", answer = "";
	private ArrayList<String> numbers = new ArrayList<String>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(10);

		StackPane stack = new StackPane();

		screen = new Rectangle(500 + grid.getHgap() * 4, 200 + grid.getVgap() * 3);

		Model model = new Model();

		txt = new TextField();
		txt2 = new TextField();

		txt.setTranslateY(-100 - grid.getVgap() * 3);
		txt.setMaxSize(200, 100);
		txt2.setMaxSize(200, 100);
		txt2.setFont(Font.font(30));

		stack.getChildren().addAll(screen, txt, txt2);
		stack.setAlignment(Pos.BOTTOM_RIGHT);

		// Buttons for numbers
		one = new Button("1");
		two = new Button("2");
		three = new Button("3");
		four = new Button("4");
		five = new Button("5");
		six = new Button("6");
		seven = new Button("7");
		eight = new Button("8");
		nine = new Button("9");
		zero = new Button("0");

		// Buttons for calculations
		plus = new Button("+");
		min = new Button("-");
		keer = new Button("x");
		delen = new Button("/");
		equals = new Button("=");

		// extra buttons
		comma = new Button(",");
		percent = new Button("%");
		wortel = new Button("√");

		// ActionEvents
		one.setOnAction(e -> Controller.processNumpad(e));
		two.setOnAction(e -> Controller.processNumpad(e));
		three.setOnAction(e -> Controller.processNumpad(e));
		four.setOnAction(e -> Controller.processNumpad(e));
		five.setOnAction(e -> Controller.processNumpad(e));
		six.setOnAction(e -> Controller.processNumpad(e));
		seven.setOnAction(e -> Controller.processNumpad(e));
		eight.setOnAction(e -> Controller.processNumpad(e));
		nine.setOnAction(e -> Controller.processNumpad(e));
		zero.setOnAction(e -> Controller.processNumpad(e));
		
		plus.setOnAction((e -> Controller.processOperator(e)));
		min.setOnAction((e -> Controller.processOperator(e)));	
		keer.setOnAction((e -> Controller.processOperator(e)));
		delen.setOnAction((e -> Controller.processOperator(e)));
		equals.setOnAction(e -> Controller.processOperator(e));

		// setting the sizes of the buttons
		one.setPrefSize(100, 100);
		two.setPrefSize(100, 100);
		three.setPrefSize(100, 100);
		four.setPrefSize(100, 100);
		five.setPrefSize(100, 100);
		six.setPrefSize(100, 100);
		seven.setPrefSize(100, 100);
		eight.setPrefSize(100, 100);
		nine.setPrefSize(100, 100);
		zero.setPrefSize(200 + grid.getHgap(), 100);

		plus.setPrefSize(100, 100);
		min.setPrefSize(100, 100);
		delen.setPrefSize(100, 100);
		keer.setPrefSize(100, 100);
		comma.setPrefSize(100, 100);
		equals.setPrefSize(100, 200 + grid.getVgap());
		wortel.setPrefSize(100, 100);
		percent.setPrefSize(100, 100);

		// Setting up de nodes
		// Screen
		GridPane.setConstraints(stack, 0, 0, 5, 1);
		GridPane.setConstraints(screen, 0, 0, 5, 1);

		// Numpad and arithmatic
		GridPane.setConstraints(seven, 0, 1);
		GridPane.setConstraints(eight, 1, 1);
		GridPane.setConstraints(nine, 2, 1);
		GridPane.setConstraints(delen, 3, 1);
		GridPane.setConstraints(wortel, 4, 1);

		GridPane.setConstraints(four, 0, 2);
		GridPane.setConstraints(five, 1, 2);
		GridPane.setConstraints(six, 2, 2);
		GridPane.setConstraints(keer, 3, 2);
		GridPane.setConstraints(percent, 4, 2);

		GridPane.setConstraints(one, 0, 3);
		GridPane.setConstraints(two, 1, 3);
		GridPane.setConstraints(three, 2, 3);
		GridPane.setConstraints(min, 3, 3);

		GridPane.setConstraints(zero, 0, 4, 2, 1);
		GridPane.setConstraints(comma, 2, 4);
		GridPane.setConstraints(plus, 3, 4);

		GridPane.setConstraints(equals, 4, 3, 1, 2);

		Scene scene = new Scene(grid);

		// #CSS

		// style of nodes
		grid.setStyle(".button{ \n " + "-fx-background-radius: 3,2,1;}\n" + ".text-area *.text{"
				+ "-fx-font-style: italic}\n");
		grid.setAlignment(Pos.CENTER);

		grid.getChildren().addAll(one, two, three, four, five, six, seven, eight, nine, zero, plus, min, keer, delen,
				comma, wortel, percent, equals, stack);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	// Getters and setters
	public static TextField getTxt() {
		return txt;
	}

	public void setTxt(TextField txt) {
		this.txt = txt;
	}

	public TextField getTxt2() {
		return txt2;
	}

	public void setTxt2(TextField txt2) {
		this.txt2 = txt2;
	}

	public static String getNumber() {
		return number;
	}

	public static void setNumber(String nmb) {
		number = nmb;
	}

	public ArrayList<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(ArrayList<String> numbers) {
		this.numbers = numbers;
	}

}
