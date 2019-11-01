package OLS_server;

import util.quesAns;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;

/**
 * Created by Sarathi on 6/3/2016.
 */
public class qArray implements Serializable{
    quesAns arr[];
    FileReader fr;
    BufferedReader br;
    int size;

    qArray(String str) {
        arr = new quesAns[30];
        if (str.equals("**Send11//")) {
            try {
                fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\ques11.txt");
                br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.out.println("Fr open error!");
            }
        } else if (str.equals("**Send12//")) {
            try {
                fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\ques12.txt");
                br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.out.println("Fr open error!");
            }
        } else if (str.equals("**Send13//")) {
            try {
                fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\ques13.txt");
                br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.out.println("Fr open error!");
            }
        } else if (str.equals("**Send21//")) {
            try {
                fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\ques21.txt");
                br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.out.println("Fr open error!");
            }
        } else if (str.equals("**Send22//")) {
            try {
                fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\ques22.txt");
                br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.out.println("Fr open error!");
            }
        } else if (str.equals("**Send23//")) {
            try {
                fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\ques23.txt");
                br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.out.println("Fr open error!");
            }
        } else if (str.equals("**Send31//")) {
            try {
                fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\ques31.txt");
                br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.out.println("Fr open error!");
            }
        } else if (str.equals("**Send32//")) {
            try {
                fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\ques32.txt");
                br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.out.println("Fr open error!");
            }
        } else if (str.equals("**Send33//")) {
            try {
                fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\ques33.txt");
                br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.out.println("Fr open error!");
            }
        }

        int i;

        for (i = 0;i<2; i++) {
            try {
                arr[i]= new quesAns();
                arr[i].question = br.readLine();
                if (arr[i].question.equals(null))
                    break;
                arr[i].op1 = br.readLine();
                arr[i].op2 = br.readLine();
                arr[i].op3 = br.readLine();
                arr[i].op4 = br.readLine();
                int k = Integer.parseInt(br.readLine());
                arr[i].setAns(k);
                arr[i].setSolution(br.readLine());
            } catch (Exception e) {
                System.out.println("Error while opening questions");
            }
        }

        size = i;
        try {
            br.close();
            fr.close();
        }catch (Exception e){
            System.out.println("Problem closing the file");
        }

    }
}
