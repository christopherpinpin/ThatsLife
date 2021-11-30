/**
 * Developers: Paolo Edni Andryn V. Espiritu
 *             Christopher Mari P. Pinpin
 * Section:    S13A
 * Professor:  Shirley Chu
 */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

/**
 * Runs the program "That's Life"
 */

public class Main extends Application {
    private static Board board;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        board = new Board();
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene menu = new Scene(root);
        stage.setTitle("That's Life");

        stage.setScene(menu);

        stage.show();

    }

    public static Stage getStage()
    {
        return stage;
    }

    public static Board getBoard()
    {
        return board;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
