package com.jwy.service;

import java.util.Date;

import com.jwy.domain.UserVO;
import com.jwy.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sesId, Date cookieAge) throws Exception;
	
	public UserVO checkUserWithSesKey(String sesKey) throws Exception;
}
