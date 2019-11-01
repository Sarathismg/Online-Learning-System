
package util;

import java.io.Serializable;

public class Userpass implements Serializable {
	private String username;
	private String password;

	public Userpass(String name, String pass){
		username = name;
		password = pass;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
