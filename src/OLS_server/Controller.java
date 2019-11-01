package OLS_server;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import util.*;

public class Controller implements Initializable {
    public Button startButton;
    public Button endButton;
    public TextArea textArea;
    public Server tcp;
    public static TextArea StextArea;
    static qArray a1,a2,a3,b1,b2,b3,c1,c2,c3;

    public void startButtonAction() throws IOException {
        tcp = new Server(this);
        startButton.setDisable(true);
        a1 = new qArray("**Send11//");
        a2 = new qArray("**Send12//");
        a3 = new qArray("**Send13//");
        b1 = new qArray("**Send21//");
        b2 = new qArray("**Send22//");
        b3 = new qArray("**Send23//");
        c1 = new qArray("**Send31//");
        c2 = new qArray("**Send32//");
        c3 = new qArray("**Send33//");

    }

    public void stopButtonAction() {
        try {
            Server.ServSock.close();
        } catch (IOException e) {
            System.out.println("server closing error");
        }
        startButton.setDisable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StextArea = textArea;
    }
}
