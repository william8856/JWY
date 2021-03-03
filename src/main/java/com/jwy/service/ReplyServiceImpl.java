package com.jwy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwy.domain.ReplyVO;
import com.jwy.persistence.BoardDAO;
import com.jwy.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO rdao;
	
	@Inject
	private BoardDAO bdao;

	@Transactional
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		rdao.create(vo);  // 댓글 insert
		bdao.updateReply(vo.getBno(), 1);  // 댓글이 달린 부모글에 댓글수 1 증가
	}

	@Override
	public List<ReplyVO> listReply(int bno) throws Exception {
		return rdao.read(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		rdao.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(int no) throws Exception {
		int bno = rdao.getBno(no);  // 삭제되는 댓글의 부모글 알아오기
		rdao.delete(no);  // 댓글 삭제
		bdao.updateReply(bno, -1);  // 삭제된 부모글의 댓글수 1 감소
	}

}
