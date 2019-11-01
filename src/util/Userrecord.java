package util;

import java.io.Serializable;

/**
 * Created by Sarathi on 5/28/2016.
 */
public class Userrecord implements Serializable {
    public int score1,score2,score3,score4,score5;

    public Userrecord(int score1,int score2,int score3,int score4,int score5){

        this.score1 =score1;
        this.score3 = score3;
        this.score2 = score2;
        this.score4 = score4;
        this.score5 = score5;

    }

}
