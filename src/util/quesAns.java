package util;

import java.io.Serializable;

/**
 * Created by Sarathi on 6/2/2016.
 */
public class quesAns implements Serializable{
    public String question;

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public String op1;
    public String op2;
    public String op3;
    public String op4;
    public String solution;
    int ans;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public quesAns(){}

    public quesAns(String q, String o1, String o2, String o3, String o4, int ans, String sol){

        question = q;
        op1 = o1;
        op2 = o2;
        op3 = o3;
        op4 = o4;
        solution = sol;

        this.ans = ans;
    }




}
