package OLS_server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import util.*;

/**
 * Created by Sarathi on 5/24/2016.
 */
public class login_checker {

    private FileReader fr;
    private BufferedReader br;
    Userpass userpass;

    login_checker(Userpass data) throws FileNotFoundException {
        try {
            fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\Account_info.txt");
        }catch (Exception e)
        {
            System.out.println("File not found!");
        }
        br = new BufferedReader(fr);
        userpass = data;
    }

    public int Check() throws IOException {
        int count = 0;
        while (true) {
            count ++;
            String usernametemp = br.readLine();
            String passwordtemp = br.readLine();
            if (usernametemp == null) {
                br.close();
                fr.close();
                return -1;

            } else if (userpass.getUsername().equals(usernametemp)) {
                if (userpass.getPassword().equals(passwordtemp)) {
                    br.close();
                    fr.close();
                    return count;
                } else {
                    br.close();
                    fr.close();
                    return -1;
                }
            }
        }
    }

}
