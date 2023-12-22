package com.example.demo.pojo3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.util.HashMapBinder;

//인터페이스의 구현체 클래스이므로 추상메소드를 모두 오버라이딩 해야 한다
public class Board2Controller implements Controller3 {
	Logger logger = Logger.getLogger(Board2Controller.class);
	Map<String, Object> pMap = new HashMap<>();
	Board2Logic bLogic = new Board2Logic();
	String path = null;
	
	@Override
	public Object execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		return null;
	}

	//1-1,1-2에서는 할 수 없었던 req,res 사용할 수 있게 되었다 - 메소드 설계 - PL - 좋은점: 획일적인 구조(장애가 발생했을 때, 업무적인 지원시 장점)
	//리턴타입과 파라미터를 결정하는 것이다 - 메소드 설계
	@Override
	public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res) {
		//insert here - 요구사항정의서, 구현해야할 페이지 목록 - 업무 분장
		logger.info("jsonBoardList");
		List<Map<String ,Object>> nList = null;
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		nList = bLogic.boardList(pMap);
		Gson g = new Gson();
		String temp = g.toJson(nList);
		return temp;
	}

	@Override
	public Object boardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList");
		logger.info(req+","+res);
		List<Map<String ,Object>> bList = null;
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);  
		bList = bLogic.boardList(pMap);      
		req.setAttribute("bList", bList);
		path = "forward:board/boardList"; 
		return path;
	}

	@Override
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardDetail");
		List<Map<String ,Object>> bList = null;
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		bList = bLogic.boardDetail(pMap);
		logger.info(bList);
		ModelAndView mav = new ModelAndView(req); //WEB-INF/jsp/[[[board2/boardDetail]]].jsp
		mav.addObject("bList",bList);
		mav.setViewName("board2/boardDetail");
		return mav;
	}

	@Override
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res) {
		return null;
	}

	@Override
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) {
		return null;
	}

	@Override
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res) {
		return null;
	}

	@Override
	public Object imageDownload(HttpServletRequest req, HttpServletResponse res) {
		return null;
	}

	@Override
	public Object imageUpload(HttpServletRequest req, HttpServletResponse res) {
		return null;
	}

	@Override
	public Object imageGet(HttpServletRequest req, HttpServletResponse res) {
		return null;
	}
}
