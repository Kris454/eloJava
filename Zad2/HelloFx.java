import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
 
public class HelloFx extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
   @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Okienko");

        Text text = new Text(20, 100, "Tekst w okienku");
        
        StackPane root = new StackPane();
        root.getChildren().add(text);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}