package com.jwy.springProj;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jwy.domain.BoardVO;
import com.jwy.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)  // 현재 클래스가 Spring-test(JUnit4)와 함께 동작
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}
)  // 위 경로에서 root-context.xml 파일을 찾아 로딩
public class ServiceTest {
	@Inject
	private BoardService service;
	
//	@Test
//	public void insert() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("서비스 테스트");
//		vo.setContent("서비스 테스트중");
//		vo.setWriter("tester");
//		if (service.insert(vo)) {
//			System.out.println("글쓰기 성공");
//		} else {
//			System.out.println("글쓰기 실패");
//		}
//	}
//	
//	@Test
//	public void read() throws Exception {
//		System.out.println(service.read(2).toString());
//	}
//	
//	@Test
//	public void modify() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setNo(4);
//		vo.setTitle("서비스 테스트");
//		vo.setContent("서비스 테스트 중");
//		if (service.modify(vo)) {
//			System.out.println("수정 성공");
//		} else {
//			System.out.println("수정 실패");
//		}
//	}
	
	@Test
	public void remove() throws Exception {
		if(service.remove(6)) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	@Test
	public List<BoardVO> listAll() throws Exception {
		List<BoardVO> lst = service.listAll();
		System.out.println(lst.toString());
	}
}
