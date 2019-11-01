package Client;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Sarathi on 5/28/2016.
 */

/*
every time after user finishes a challenge you must update the score ..that's why static
here

 */
public class pagestatscntrl implements Initializable {

    public Label ch1score;
    public Label  ch2score;
    public Label  ch3score;
    public Label chtscore;
    public static Label setch1score;
    public static Label  setch2score;
    public static Label  setch3score;
    public static Label setchtscore;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String s =((Integer) page4controller.record.score1).toString();
        chtscore.setText(s);
        s =((Integer) page4controller.record.score2).toString();

        ch1score.setText(s);
        s =((Integer) page4controller.record.score3).toString();
        ch2score.setText(s);
        s =((Integer) page4controller.record.score4).toString();
        ch3score.setText(s);

        setch1score = ch1score;
        setch2score = ch2score;
        setch3score = ch3score;
        setchtscore = chtscore;

    }

    public void backAction(){
        try {
            clientSocket.nc.write("**Afterlogin//");
            Parent pp= FXMLLoader.load(getClass().getResource("page4.fxml"));

            Main.window.setScene(new Scene(pp, 600, 400));
        } catch (IOException e) {
            System.out.println("Problem changing tha scene");
        }

    }
}
