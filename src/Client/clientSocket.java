package Client;

import util.NetworkUtil;

/**
 * Created by Sarathi on 5/25/2016.
 */
public class clientSocket {

    public static NetworkUtil nc;
    String serveradd="127.0.0.1";
    int serverport=33993;

    public clientSocket(){
        nc = new NetworkUtil(serveradd,serverport);
    }

    public clientSocket(String str, int num){
        serveradd = str;
        serverport = num;
        nc = new NetworkUtil(serveradd,serverport);
    }
}


