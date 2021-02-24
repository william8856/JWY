package com.jwy.springProj;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jwy.domain.BoardVO;
import com.jwy.domain.PagingCriteria;
import com.jwy.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)  // 현재 클래스가 Spring-test(JUnit4)와 함께 동작
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}
)  // 위 경로에서 root-context.xml 파일을 찾아 로딩
public class DAOTest {
	
	@Inject
	private BoardDAO dao;
	
//	@Test
//	public void insertBoard() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("테스트3");
//		vo.setContent("하나둘 하나둘");
//		vo.setWriter("jwy");
//		int i = dao.insert(vo);
//		if (i == 1) {
//			System.out.println("글쓰기 성공");
//		}
//	}
//	
//	@Test
//	public void readBoard() throws Exception {
//		System.out.println(dao.readBoard(1).toString());
//	}
//	
//	@Test
//	public void update() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setNo(5);
//		vo.setTitle("수정하기");
//		vo.setContent("수정 중");
//		int i = dao.update(vo);
//		if (i == 1) {
//			System.out.println("수정 성공");
//		}
//	}
//
//	@Test
//	public void deleteBoard() throws Exception {
//		int i = dao.delete(2);
//		if (i == 1) {
//			System.out.println("삭제 성공");
//		}
//	}
//	
//	@Test
//	public void listBoard() throws Exception {
//		List<BoardVO> lst = dao.listBoard();
//		System.out.println(lst.toString());
//	}
//	
//	@Test
//	public void testListPaging() throws Exception {
//		int page = 1;
//		
//		System.out.println(dao.listBoardPaging(page));
//	}
	
	@Test
	public void testListCriteria() throws Exception {
		PagingCriteria cri = new PagingCriteria();
		cri.setPage(1);
		cri.setPerPageNum(20);
		
		System.out.println(dao.listBoardCriteria(cri).toString());
	}
	
	
}
