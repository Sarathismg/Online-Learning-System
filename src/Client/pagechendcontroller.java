package Client;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import util.Userrecord;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class pagechendcontroller implements Initializable {

    public Button stats;
    public Button Logout;
    public Label signin ;
    public Label score;
    public Label time;
    public Button back;



    public void setLogout() throws Exception{
        clientSocket.nc.write("**Logout//");
        Parent pp= FXMLLoader.load(getClass().getResource("page1.fxml"));
        Main.window.setScene(new Scene(pp, 600, 400));


    }

    public void setstats() throws IOException {

        Parent pp= FXMLLoader.load(getClass().getResource("page_Stats.fxml"));
        Main.window.setScene(new Scene(pp, 600, 400));
    }

    public void setBack(){

        try {
            clientSocket.nc.write("**Afterlogin//");
            Parent pp= FXMLLoader.load(getClass().getResource("page4.fxml"));

            Main.window.setScene(new Scene(pp, 600, 400));
        } catch (IOException e) {
            System.out.println("Problem changing tha scene");
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signin.setText("Signed in as: "+page1controller.Username);
        score.setText(Integer.toString(page6controller.scoring));

    }
}
