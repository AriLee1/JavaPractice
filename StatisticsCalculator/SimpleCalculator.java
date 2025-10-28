import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 여기 안에서 GUI를 만든다!

        primaryStage.setTitle("Simple Calculator");

        VBox root = new VBox(); // VBox 레이아웃을 사용할 거야
        Scene scene = new Scene(root, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
