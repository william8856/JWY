package com.jwy.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jwy.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Inject
	private SqlSession ses;
	private static String namespace = "com.jwy.mapper.messagMapper";
	
	@Override
	public void create(MessageVO vo) throws Exception {
		ses.insert(namespace + ".create", vo);

	}

	@Override
	public MessageVO readMessage(int mid) throws Exception {
		return ses.selectOne(namespace + ".readMessage", mid);
	}

	@Override
	public void updateState(int mid) throws Exception {
		ses.update(namespace + ".updateState", mid);

	}

}
