package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage window;
    public static Parent p;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        new clientSocket();
        Parent root = FXMLLoader.load(getClass().getResource("page1.fxml"));
        p = root;
        window.setTitle("OLS");
        window.setScene(new Scene(p, 600, 400));
        window.show();
        window.setOnCloseRequest(e->{
            clientSocket.nc.write("**Shutdown//");
            clientSocket.nc.closeConnection();
            window.close();

        }

        );
    }


    public static void main(String[] args) {
        launch(args);
    }
}
