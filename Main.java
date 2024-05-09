package mvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
        @Override
        public void start(Stage primaryStage) {
            CalculatorModel model = new CalculatorModel();
            CalculatorView view = new CalculatorView();
            CalculatorController controller = new CalculatorController(model, view);

            Scene scene = new Scene(view, 200, 200);
            Image icon = new Image("calc.png");

            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("Simple Calculator");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }

    }
