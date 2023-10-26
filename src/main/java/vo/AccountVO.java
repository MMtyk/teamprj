
package vo;

public class AccountVO {
	private String idNum;
	private String id;
	private String passwd;
	private String nick;
	private String idChk;
	private String nickChk;
	
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

	public String getIdChk() {
		return idChk;
	}

	public void setIdChk(String idChk) {
		this.idChk = idChk;
	}

	public String getNickChk() {
		return nickChk;
	}

	public void setNickChk(String nickChk) {
		this.nickChk = nickChk;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
}

