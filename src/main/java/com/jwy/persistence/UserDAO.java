package com.jwy.persistence;

import java.util.Date;

import com.jwy.domain.UserVO;
import com.jwy.dto.LoginDTO;

public interface UserDAO {
	// 로그인 처리
	public UserVO login(LoginDTO dto) throws Exception;
	
	// 유저의 세션ID를 체크
	public UserVO checkUserWithSesKey(String seskey) throws Exception;
	
	// 로그인 유지하기 위해
	public void keepLogin(String uid, String sesId, Date cookieAge) throws Exception;
}
