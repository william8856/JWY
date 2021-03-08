package com.jwy.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jwy.domain.UserVO;
import com.jwy.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession ses;
	
	private static String namespace = "com.jwy.mapper.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return ses.selectOne(namespace + ".login", dto);
	}

}
