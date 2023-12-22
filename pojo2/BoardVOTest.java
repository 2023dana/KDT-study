package com.example.demo.pojo2;

import com.vo.BoardVO;
import com.vo.EmpVO;

//VO(Value Object or DTO:Data Transfer Object - 레거시시스템사용하는 이름)패턴은 객체와 테이블 사이의 매핑을 위해 시작된 클래스 설계 이었다
//자바에서는 String인데 오라클에서는 Char, Varchar2 - 타입이 다르다, 실제 값은 동일한 타입이다

public class BoardVOTest {

	public static void main(String[] args) {
		EmpVO evo = new EmpVO("나잘난");//public EmpVO(int empno)
		System.out.println("ename:"+evo.getEname());//나잘난
		//BoardVO bvo = new BoardVO(5);
		BoardVO bvo3 = new BoardVO();
		bvo3.setB_title("제목333");
		String title =  bvo3.getB_title();
		System.out.println(title);//제목333
		BoardVO bvo = BoardVO.builder().b_no(3).build();
		System.out.println(bvo.getB_no());//3
		System.out.println(bvo.getB_title());//null or ""
		BoardVO bvo2 = BoardVO.builder().b_no(30).b_title("제목1").build();
		System.out.println(bvo.getB_no());//30
		System.out.println(bvo.getB_title());//제목1

	}

}
