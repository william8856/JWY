package com.jwy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.jwy.domain.BoardVO;
import com.jwy.domain.PagingCriteria;
import com.jwy.domain.SearchCriteria;
import com.jwy.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;

	@Override
	public boolean insert(BoardVO vo) throws Exception {
		boolean result = false;
		int i = dao.insert(vo);
		if (i == 1) {
			result = true;
		}
		
		return result;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)  // 조회수 update 처리된 데이터에 한해서 select 되게끔 격리 레벨을 올림
	@Override
	public BoardVO read(int no) throws Exception {
		// 이후에 조회수 증가하는 것을 AOP의 트랜잭션 처리로 마감
		dao.updateViewCnt(no);
		BoardVO vo = dao.readBoard(no); 
		return vo;
	}

	@Override
	public boolean modify(BoardVO vo) throws Exception {
		boolean result = false;
		int i = dao.update(vo);
		if (i == 1) {
			result = true;
		}
		
		return result;
	}

	@Override
	public boolean remove(int no) throws Exception {
		boolean result = false;
		int i = dao.delete(no);
		if (i == 1) {
			result = true;
		}
		
		return result;
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listBoard();
	}

	@Override
	public List<BoardVO> listCriteria(PagingCriteria cri) throws Exception {
		return dao.listBoardCriteria(cri);
	}

	@Override
	public int getTotalBoardCnt() throws Exception {
		return dao.getTotalBoardCnt();
	}

	@Override
	public List<BoardVO> goSearch(SearchCriteria scri, PagingCriteria cri) throws Exception {
		return dao.goSearch(scri, cri);
	}

}
