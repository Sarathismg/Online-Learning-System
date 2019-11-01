package Client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import util.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class page1controller implements Initializable {
    public Button login;
    public Button signup;
    public TextField username;
    public TextField password;
    public static String Username;
    String tempname;
    String temppass;
    Integer isvalid;
    public Label error;

    public static clientSocket tcp;
    public static TextArea StextArea;


    public void signupbuttonaction(){
        try {
            Parent pp= FXMLLoader.load(getClass().getResource("page2.fxml"));
            Main.window.setScene(new Scene(pp, 600, 400));
        } catch (IOException e) {
            System.out.println("Problem changing tha scene");
        }


    }

    public void loginButtonAction() {
        Userpass a;
        tempname = username.getText();
        username.clear();
        temppass = password.getText();
        password.clear();
        a = new Userpass(tempname,temppass);

        clientSocket.nc.write("**Login//");
        clientSocket.nc.write(a);
        Object o = clientSocket.nc.read();
        if(o instanceof  Integer)
            isvalid = (Integer)o;
        if(isvalid.intValue()<0){
            error.setVisible(true);

        }
        else {
            Username = tempname;
            System.out.println(isvalid);
            try {
                Parent pp= FXMLLoader.load(getClass().getResource("page4.fxml"));
                Main.window.setScene(new Scene(pp, 600, 400));
            } catch (IOException e) {
                System.out.println("Problem changing tha scene");
            }
            error.setVisible(false);
        }




    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
