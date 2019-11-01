package Client;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import util.quesAns;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class page6controller implements Initializable {

    public Label score;
    quesAns presentques;
    String str;
    int ans;
    int add;
    int subtract;
    public static int scoring;
    public int count;
    public TextArea question;
    public Button ch1;
    public Button ch2;
    public Button ch3;
    public Button ch4;
    public Button nextt;
    public TextArea solution;
    public Button stats;
    public Button Logout;
    public Label signin ;
    public Label correct;
    public Label incorrect;
    static int choice2;


    public void setCh1() {
        if(ans == 1) {
            scoring += add;
            add--;
            subtract++;
            score.setText(Integer.toString(scoring));
            correct.setVisible(true);
            nextt.setVisible(true);
        }

        else{
            scoring-=subtract;
            score.setText(Integer.toString(scoring));
            incorrect.setVisible(true);
            solution.setVisible(true);
            nextt.setVisible(true);

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

    public void setCh2() {
        if(ans == 2) {
            scoring += add;
            add--;
            subtract++;
            score.setText(Integer.toString(scoring));
            correct.setVisible(true);
            nextt.setVisible(true);
        }

        else{
            scoring-=subtract;
            score.setText(Integer.toString(scoring));
            incorrect.setVisible(true);
            solution.setVisible(true);
            nextt.setVisible(true);

        }
    }
    public void setCh3() {
        if(ans == 3) {
            scoring += add;
            add--;
            subtract++;
            score.setText(Integer.toString(scoring));
            correct.setVisible(true);
            nextt.setVisible(true);
        }

        else{
            scoring-=subtract;
            score.setText(Integer.toString(scoring));
            incorrect.setVisible(true);
            solution.setVisible(true);
            nextt.setVisible(true);

        }
    }

    public void setCh4(){
        if(ans == 4) {
            scoring += add;
            add--;
            subtract++;
            score.setText(Integer.toString(scoring));
            correct.setVisible(true);
            nextt.setVisible(true);
        }

        else{
            scoring-=subtract;
            score.setText(Integer.toString(scoring));
            incorrect.setVisible(true);
            solution.setVisible(true);
            nextt.setVisible(true);

        }


    }

    public void setNextt(){
        //set if challenge finished

        //
        count--;
        if(count == 0){
            System.out.println("over!!"+ scoring);
            if(page4controller.choice1==1){
                page4controller.record.score2+=scoring;
            }
            else if(page4controller.choice1==2){
                page4controller.record.score3+=scoring;
            }
            else if(page4controller.choice1==3){
                page4controller.record.score4+=scoring;
            }

            page4controller.record.score1+=scoring;

            clientSocket.nc.write("**updateScore//");
            clientSocket.nc.write(page4controller.record);

            Parent pp= null;
            try {
                pp = FXMLLoader.load(getClass().getResource("pagechallengeend.fxml"));
                Main.window.setScene(new Scene(pp, 600, 400));
            } catch (IOException e) {
                System.out.println("Error while changing skin");
            }



        }
        else {
            clientSocket.nc.write(str);
            Object o = clientSocket.nc.read();
            presentques = (quesAns) o;
            question.setText(presentques.getQuestion());
            solution.setText(presentques.getSolution());
            ch1.setText(presentques.getOp1());
            ch2.setText(presentques.getOp2());
            ch3.setText(presentques.getOp3());
            ch4.setText(presentques.getOp4());
            ans = presentques.getAns();
            correct.setVisible(false);
            incorrect.setVisible(false);
            nextt.setVisible(false);
            solution.setVisible(false);
        }



    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signin.setText("Signed in as: "+page1controller.Username);
        str = "**send";
        str+=page4controller.choice1;
        str+=page5controller.choice2;
        str+="//";
        clientSocket.nc.write(str);
        Object o = clientSocket.nc.read();
        presentques = (quesAns)o;
        score.setText("0");
        question.setText(presentques.getQuestion());
        solution.setText(presentques.getSolution());
        ch1.setText(presentques.getOp1());
        ch2.setText(presentques.getOp2());
        ch3.setText(presentques.getOp3());
        ch4.setText(presentques.getOp4());
        ans = presentques.getAns();
        correct.setVisible(false);
        incorrect.setVisible(false);
        nextt.setVisible(false);
        solution.setVisible(false);
        add = 10;
        subtract = 0;
        scoring = 0;
        count = 1;



    }
}
