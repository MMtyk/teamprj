package service;

import vo.AccountVO;

public class Login {
	ILogin is;
	public Login() {
	is = new LoginImpl();
	}
	
	public String checkPass(AccountVO vo) {
		return is.checkPass(vo);
	}
}
