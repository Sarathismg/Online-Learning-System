package OLS_server;

import OLS_server.Server;
import util.Userrecord;

import java.io.*;

/**
 * Created by Sarathi on 6/1/2016.
 */
public class ShowClientInfo {
    Userrecord abc;

    public Userrecord showInfo(int i) {
        String s = "user";

        s += Integer.toString(i);
        s += ".txt";


        try {
            FileReader fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\" + s);
            BufferedReader br = new BufferedReader(fr);
            try {
                abc = new Userrecord(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            // nc.write(a);
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("closing error!");
            }

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("File error!");
        }

        return abc;
    }

    public void updateInfo(int i,Userrecord a){
        String s = "user";

        s += Integer.toString(i);
        s += ".txt";
        try {
            FileWriter fw = new FileWriter("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\" + s);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Integer.toString(a.score1) + "\r\n");
            bw.write(Integer.toString(a.score2) + "\r\n");
            bw.write(Integer.toString(a.score3) + "\r\n");
            bw.write(Integer.toString(a.score4) + "\r\n");
            bw.write(Integer.toString(a.score5) + "\r\n");
            bw.close();
            fw.close();
        }
        catch(IOException e){
            System.out.println("Updating info error!");
        }




    }


}

