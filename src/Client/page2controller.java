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

public class page2controller implements Initializable {
    public Button registernow;

    public TextField username;
    public TextField password;
    public TextField confirmpassword;
    Integer isvalid;
    public Label error;
    public static TextArea StextArea;



    public void RegisternowButtonAction() {
        Userpass a;
            String tempname = username.getText();
            username.clear();
            String temppass = password.getText();
            password.clear();
            String temppassrep = confirmpassword.getText();
            confirmpassword.clear();
            if (temppass.equals(temppassrep)) {
                a = new Userpass(tempname, temppass);
                //this.tcp = page1controller.tcp;

                clientSocket.nc.write("**Register//");
                clientSocket.nc.write(a);
                //page 3 code here
                try {
                    Parent pp= FXMLLoader.load(getClass().getResource("page3.fxml"));
                    Main.window.setScene(new Scene(pp, 600, 400));
                }
                 catch (IOException e) {
                    e.printStackTrace();
                }

                //Object o = clientSocket.nc.read();

            }
        else
            error.setVisible(true);

       // }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
