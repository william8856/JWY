package com.jwy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jwy.domain.ReplyVO;
import com.jwy.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO dao;

	@Override
	public void addReply(ReplyVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public List<ReplyVO> listReply(int bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void removeReply(int no) throws Exception {
		dao.delete(no);
	}

}
