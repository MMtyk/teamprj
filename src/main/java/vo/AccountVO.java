
package vo;

public class AccountVO {
	private String id;
	private String passwd;
	private String nick;
	
	public AccountVO() {
	}
	
	public AccountVO(String id, String passwd) {
		this.setId(id);
		this.setPasswd(passwd);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
}

