package Client;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import util.Userpass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class page3controller {
    public Button loginbutton;


    public void setLoginbutton(){
        try {
            Parent pp= FXMLLoader.load(getClass().getResource("page1.fxml"));
            Main.window.setScene(new Scene(pp, 600, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
