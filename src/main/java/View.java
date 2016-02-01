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
    private StackPane stack;
    private boolean add, subtract, multiply, divide;
    public Rectangle screen;

    static TextField txt;
    static TextField txt2;


    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        stack = new StackPane();

        screen = new Rectangle(500 + grid.getHgap() * 4, 200 + grid.getVgap() * 3);

        Model model = new Model();

        txt = new TextField();
        txt2 = new TextField();

        stack.getChildren().addAll(screen, txt, txt2);
        stack.setAlignment(Pos.BOTTOM_RIGHT);

        // Buttons
        generateButtons();

        // ActionEvents
        generateActionEvents();

        // GridPane-coordinates
        generateConstraints();

        // Setting up scene
        Scene scene = new Scene(grid);

        // #CSS
        scene.getStylesheets().add("stylesheets/default.css");

        // overriding the sizes of special buttons buttons
        zero.setStyle("-fx-pref-width: " + Double.toString(200 + grid.getHgap()));
        equals.setStyle("-fx-pref-height: " + Double.toString(200 + grid.getVgap()));

        // Textfields
        txt.setTranslateY(-100 - grid.getVgap() * 3);
        txt.setMaxSize(400, 100);
        txt.setEditable(false);

        txt2.setMaxSize(400, 100);
        txt2.setFont(Font.font(30));
        txt2.setEditable(false);

        // style of nodes
        grid.setAlignment(Pos.CENTER);
        grid.getChildren().addAll(one, two, three, four, five, six, seven, eight, nine, zero, plus, min, keer, delen,
                comma, wortel, percent, equals, stack);

        primaryStage.sizeToScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public void generateButtons() {
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
    }

    public void generateConstraints() {
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
    }

    public void generateActionEvents(){
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
    }

    // Getters and setters
    public static TextField getTxt() {
        return txt;
    }

    public static TextField getTxt2() {
        return txt2;
    }
}
