package OLS_server;

import util.Userpass;

import java.io.*;

/**
 * Created by Sarathi on 5/26/2016.
 */
public class RegisterProcess {

    FileReader fr;
    FileWriter fw;
    BufferedReader br;
    BufferedWriter bw;
    Userpass a;
    int no_of_users;


    public RegisterProcess(Userpass ab) throws IOException {
        a = ab;
        try {
            fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\OLS_info.txt");
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
           //e.printStackTrace();
            System.out.println("File error!");
        }
        try {


            no_of_users= Integer.parseInt(br.readLine());
            fr.close();
        } catch (IOException e) {
            //e.printStackTrace();

        }

        fw = new FileWriter("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\OLS_info.txt");
        fw.write(Integer.toString(no_of_users+1));
        fw.close();

        //creation of new file for new user

        String s =  "user";
        no_of_users++;
        s+=Integer.toString(no_of_users);
        s+=".txt";

        File file = new File("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\"+s);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("file creation error!");
        }

        //newly created file filled with initial value
        try {
            fw=new FileWriter("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\"+s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        bw = new BufferedWriter(fw);

        //current format -----totScore------sub1ch1--sub2ch2--sub3ch3

        bw.write("0\r\n0\r\n0\r\n0\r\n0");
        bw.close();
        fw.close();

        fw= new FileWriter("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\Account_info.txt",true);

        s=a.getUsername()+"\r\n"+a.getPassword()+"\r\n";
        fw.append(s);
        fw.close();



    }
}
