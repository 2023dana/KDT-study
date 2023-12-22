package com.example.demo.pojo3;

import java.io.IOException;
//1-1, 1-2와는 다르게 컨트롤클래스부터 메소드를 쪼갠다
//메소드마다 req와 res를 주입받을 수 있어야 한다
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller3 {
	public Object execute(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException;
	
	// 게시판 구현 메소드를 추가
	public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res);
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res);
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res);
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res);
	public Object imageDownload(HttpServletRequest req, HttpServletResponse res);
	public Object imageUpload(HttpServletRequest req, HttpServletResponse res);
	public Object imageGet(HttpServletRequest req, HttpServletResponse res);
}

// ActionForward - path:String 변수, isRedirect:boolean - true이면 sendRedirect, false: forward
// -> 어노테이션 나오기 spring 2.5 이전 버전 -> spring 3.0, 4.0 -> spring 5.0, 6.0 -> spring boot 
// -> 공통된 생각 - IoC{Inversion of Control}, DI(Dependency Injection}, 객체관리(Context-> Application Context- 스프링 컨테이너의 종류 중 한 가지)
// -> String -> "redirect:/board/boardList.gd3", "forward:/board/boardList.gd3", ":/board/boardList.gd3"
// -> Object: String에서 Object로 변경한 이유가 뭐지? -> ModelAndView 또는 스프링의 상위버전(2020년부터 최근까지 Model(스프링에서 UI지원하기 위해 제공되는 클래스)을 담당하고 있음)
// ModelAndView는 select의 경우 -> 유지 -> forward -> 유효범위: request
