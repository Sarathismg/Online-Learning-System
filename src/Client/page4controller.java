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

public class page4controller implements Initializable {
    public Button challenge1;
    public Button challenge2;
    public Button challenge3;
    public Button stats;
    public Button Logout;
    public Label signin ;
    public static Userrecord record;
    static int choice1;


    public void setChallenge1() {
        choice1 = 1;
        //scene change
        try {
            Parent pp= FXMLLoader.load(getClass().getResource("page5.fxml"));
            Main.window.setScene(new Scene(pp, 600, 400));
        } catch (IOException e) {
            System.out.println("Problem changing tha scene");
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

    public void setChallenge2() {
        choice1 = 2;
        //scene change
        try {
            Parent pp= FXMLLoader.load(getClass().getResource("page5.fxml"));
            Main.window.setScene(new Scene(pp, 600, 400));
        } catch (IOException e) {
            System.out.println("Problem changing tha scene");
        }
    }
    public void setChallenge3() {
        choice1 = 3;
        //scene change
        try {
            Parent pp= FXMLLoader.load(getClass().getResource("page5.fxml"));
            Main.window.setScene(new Scene(pp, 600, 400));
        } catch (IOException e) {
            System.out.println("Problem changing tha scene");

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signin.setText("Signed in as: "+page1controller.Username);
        Object o = clientSocket.nc.read();
        if(o instanceof  Userrecord){
            record = (Userrecord)o;
        }
    }
}
