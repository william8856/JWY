package com.jwy.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwy.domain.MessageVO;
import com.jwy.persistence.MessageDAO;
import com.jwy.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageDAO mdao;
	
	@Inject
	private PointDAO pdao;
	
	@Transactional
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		mdao.create(vo);
		pdao.updatePoint(vo.getSender(), 10);  // 보내는 사람에게 10포인트
	}

	@Override
	public MessageVO readMessage(String uid, int mid) throws Exception {
		mdao.updateState(mid);  // 메시지를 읽은 상태로
		pdao.updatePoint(uid, 5);  // 메시지 수신자에게 5포인트
		return mdao.readMessage(mid);  // 메시지 읽어서 반환
	}

}
