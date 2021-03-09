package com.jwy.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

	@Override
	public UserVO checkUserWithSesKey(String seskey) throws Exception {
		return ses.selectOne(namespace + ".checkUserWithSesKey", seskey);
	}

	@Override
	public void keepLogin(String uid, String sesId, Date cookieAge) throws Exception {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("uid", uid);
		paraMap.put("sesId", sesId);
		paraMap.put("cookieAge", cookieAge);
		
		ses.update(namespace + ".keepLogin", paraMap);
	}

}
