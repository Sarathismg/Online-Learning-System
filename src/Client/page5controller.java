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

public class page5controller implements Initializable {
    public Button lvl1;
    public Button lvl2;
    public Button lvl3;
    public Button stats;
    public Button Logout;
    public Label signin ;
    static int choice2;


    public void setLvl1() {
        choice2 = 1;
        //scene change
        try {
            Parent pp= FXMLLoader.load(getClass().getResource("page6.fxml"));
            Main.window.setScene(new Scene(pp, 800, 600));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogout() throws Exception{
        clientSocket.nc.write("**Logout//");
        Parent pp= FXMLLoader.load(getClass().getResource("page1.fxml"));
        Main.window.setScene(new Scene(pp, 600, 400));


    }

    public void setstats() throws IOException {

        Parent pp= FXMLLoader.load(getClass().getResource("page_Stats.fxml"));
        Main.window.setScene(new Scene(pp, 600, 400));
    }

    public void setLvl2() {
        choice2 = 2;
        //scene change
        try {
            Parent pp= FXMLLoader.load(getClass().getResource("page6.fxml"));
            Main.window.setScene(new Scene(pp, 800, 600));
        } catch (IOException e) {
            System.out.println("Problem changing tha scene");
        }
    }
    public void setLvl3() {
        choice2 = 3;
        //scene change
        try {
            Parent pp= FXMLLoader.load(getClass().getResource("page6.fxml"));
            Main.window.setScene(new Scene(pp, 800, 600));
        } catch (IOException e) {
            System.out.println("Problem changing tha scene");

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signin.setText("Signed in as: "+page1controller.Username);

    }
}
