package com.jwy.persistence;

import java.util.List;

import com.jwy.domain.ReplyVO;

public interface ReplyDAO {
	public void create(ReplyVO vo) throws Exception;
	public List<ReplyVO> read(int bno) throws Exception;
	public void update(ReplyVO vo) throws Exception;
	public void delete(int no) throws Exception;
}
