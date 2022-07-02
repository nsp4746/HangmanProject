import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HangmanGUI extends Application {

    public static Label makeLabel() {
        Label label = new Label("Hello World!");
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label label = makeLabel();
        Scene scene = new Scene(label);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Hello World!");

    }

    public static void main(String[] args) {
        launch(args);
    }

}
