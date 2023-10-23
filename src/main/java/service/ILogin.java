package service;

import vo.AccountVO;

public interface ILogin {
	String checkPass(AccountVO vo);
}