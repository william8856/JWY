package com.jwy.persistence;

import com.jwy.domain.UserVO;
import com.jwy.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
}
