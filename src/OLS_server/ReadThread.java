
package OLS_server;
import util.*;

import java.io.*;

public class ReadThread implements Runnable {
	private Thread thr;
	NetworkUtil nc;
	int status=0;
	int userId;
	static int off = 0;
	int localoff = 0;
	int q1=0,q2=0,q3=0,q4=0,q5=0,q6=0,q7=0,q8=0,q9=0;


	/*
	status_value    action
	0 none
	1 login_request
	2 register
	3 second_page(page_after_login)
	4 question_ans


	*/

	public ReadThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this);
		thr.start();


	}
	
	public void run() {
		int uservalue;

		try {
			while(off == 0 && localoff == 0) {
				Object o = nc.read();

				//Debugging the high cpu usage issue





				//

				if (o != null) {
					if (o instanceof String && status == 0) {
						String strobj = (String) o;
						if (strobj.equals("**Login//")) {
							Controller.StextArea.appendText("Guest wants login access.\n");
							status = 1;
						} else if (strobj.equals("**Register//")) {
							Controller.StextArea.appendText("Guest wants to register .\n");
							status = 2;
						}


					}

					//o = nc.read();
					//full login accessing code

					if (status == 1 && o instanceof Userpass) {
						Userpass usable = (Userpass) o;
						uservalue = new login_checker(usable).Check();
						Integer i = uservalue;
						if (uservalue < 0) {

							nc.write(i);
							Server.c.textArea.appendText("Invalid login attempt\n");
							status = 0;
						} else {
							nc.write(i);
							userId = i;
							Server.c.textArea.appendText("User " + uservalue + " Successfully logged in\n");
							status = 3;
							q1=q2=q3=q4=q5=q6=q7=q8=q9=0;
							String s = "user";

							s += Integer.toString(i);
							s += ".txt";


							try {
								FileReader fr = new FileReader("D:\\Users\\Sarathi\\IdeaProjects\\OLS\\Datas\\" + s);
								BufferedReader br = new BufferedReader(fr);
								Userrecord a = new Userrecord(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
								nc.write(a);
								br.close();
								fr.close();
							} catch (FileNotFoundException e) {
								//e.printStackTrace();
								System.out.println("File error!");
							}


						}
					} else if (status == 2 && o instanceof Userpass) {
						Userpass usable = (Userpass) o;
						new RegisterProcess(usable);
						Server.c.textArea.appendText("New user joined in the network\n");
						status = 0;

					} else if (o instanceof String) {
						String strobj = (String) o;
						if (strobj.equals("**Afterlogin//")) {
							status = 3;
							ShowClientInfo a = new ShowClientInfo();
							Userrecord temp = a.showInfo(userId);
							nc.write(temp);
						}

						else if(strobj.equals("**Logout//")){
							status = 0;
						}

						else if(strobj.equals("**Shutdown//")){

							Controller.StextArea.appendText("Disconnected from one client\n");
							localoff =1;
						}

						/*else if(strobj.equals("**Send11//")||strobj.equals("**Send12//")||strobj.equals("**Send13//")||strobj.equals("**Send21//")||strobj.equals("**Send22//")||strobj.equals("**Send23//")||strobj.equals("**Send31//")||strobj.equals("**Send32//")||strobj.equals("**Send33//")){
							qArray qa=new qArray(strobj);
						}*/

						else if(strobj.equals("**send11//")){
							nc.write(Controller.a1.arr[q1]);
							q1++;
						}

						else if(strobj.equals("**send12//")){
							nc.write(Controller.a2.arr[q2]);
							q2++;
						}

						else if(strobj.equals("**send13//")){
							nc.write(Controller.a3.arr[q3]);
							q3++;
						}

						else if(strobj.equals("**send21//")){
							nc.write(Controller.b1.arr[q4]);
							q4++;
						}

						else if(strobj.equals("**send22//")){
							nc.write(Controller.b2.arr[q5]);
							q5++;
						}

						else if(strobj.equals("**send23//")){
							nc.write(Controller.b3.arr[q6]);
							q6++;
						}

						else if(strobj.equals("**send31//")){
							nc.write(Controller.c1.arr[q7]);
							q7++;
						}
						else if(strobj.equals("**send32//")){
							nc.write(Controller.c2.arr[q8]);
							q8++;
						}
						else if(strobj.equals("**send33//")){
							nc.write(Controller.c3.arr[q9]);
							q9++;
						}

						else if(strobj.equals("**updateScore//")){
							Userrecord a;
							Object o1 = nc.read();
							ShowClientInfo ab=new ShowClientInfo();
							if(o1 instanceof  Userrecord){
								a = (Userrecord)o1;
								ab.updateInfo(userId,a);

							}
						}

					}
				}
			}
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
		System.out.println("out of the loop");
	}
}



