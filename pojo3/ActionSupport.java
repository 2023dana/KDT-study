package com.example.demo.pojo3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.demo.pojo2.ActionServlet;

//url을 통해서 요청을 받으므로 그 값을 이용하여 메소드 이름을 결정한다 - upmu.length = 2(workname/
@SuppressWarnings("serial")
@WebServlet("*.gd3")
public class ActionSupport extends HttpServlet {
	Logger logger = Logger.getLogger(ActionServlet.class);

	private void doService(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException
	{
		String  uri = req.getRequestURI(); 
		logger.info(uri);
		String context = req.getContextPath();
		logger.info(context);
		String command = uri.substring(context.length()+1);
		logger.info(command);
		int end = command.lastIndexOf(".");
		logger.info(""+end);
		command =  command.substring(0,end);
		logger.info(command);
		String upmu[] = null;
		String result = null;
		upmu = command.split("/");
		for(String name:upmu) {
			// 단, 반드시 추상메소드를 먼저 설계할 것 - 이 약속이 지켜져야 컴파일 에러가 없다
			logger.info(name); //upmu[0]=board2, upmu[1]=boardList.jsp or boardList(Insert/Update/Delete).gd3
		}		
		// 여기서 getController() 호출 할 거야
		Object obj = null;
		try {
			// 이 요청을 어떤 컨트롤러 클래스가 담당하나요?
			obj = HandlerMapping.getController(upmu, req, res);
		} catch (Exception e) {
			
		}
		
		//ViewResolver와 관련된 코드 시작됨
		//getController가 호출된 다음에 반드시
		//리턴타입을 받아서 타입체크를 하고 String일 때 ModelAndView일 때를 나누어 처리해야 하니까
		//NullPointerException이 발동할 가능성이 있는 섹션이다
		//아래 블록이 ViewResolver 안에 들어가게 됨
		if(obj != null) {
			logger.info(obj);
			String pageMove[] = null;
			ModelAndView mav = null;
			// path라면 콜론(:)이 포함되어 있음 -> redirect나 forward 중 하나임
			// 콜론(:)이 없는 경우는 WEB-INF/jsp/XXXXX.jsp니까 슬래시/로 잘라야 함
			if(obj instanceof String) { // String 타입이라면 json이거나 path
				if(((String) obj).contains(":")){
					pageMove = obj.toString().split(":");
				}
				else if(((String) obj).contains("/")) {
					pageMove = obj.toString().split("/");
				}
				// 콜론도 없고 슬래쉬도 없는 경우라면 - 단순한 문자열을 반환하는 경우 - String path = "avatar.png","JSON 형식 문자열"
				// Test - http://localhost:8000/board2/jsonBoardList.gd3
				else {
					logger.info(obj.toString()); // JSON
					pageMove = new String[1];
					pageMove[0] = obj.toString();//파일 이름같은 경우가 저장됨 -> 화면에서 후처리하는 용도로 사용할 수 있다
				}
			}	
			else if(obj instanceof ModelAndView) {
				mav = (ModelAndView) obj;
				pageMove = new String[2];
				pageMove[0] = "";
				pageMove[1] = mav.getViewName();
				logger.info("pageMove ==>" + pageMove[0] + ","+pageMove[1]);
			}
			else if(obj instanceof byte[]) { // 응답이 png일 때 - Quill Editor
				res.setContentType("image/png:utf-8");
				PrintWriter out = res.getWriter();
				out.print(obj);
				return;
			}
			//
			if(pageMove != null && pageMove.length == 2) {
				logger.info("pageMove 원소의 개수가 2개일 때");
				String path = pageMove[1];
				if("redirect".equals(pageMove[0])) {
					res.sendRedirect(path);
				} else if("forward".equals(pageMove[0])) {
					RequestDispatcher view = req.getRequestDispatcher(path);
					view.forward(req, res);
				} else {
					RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/jsp/"+path+".jsp");
					view.forward(req, res);					
				}
			} ////// end of if
			else if(pageMove != null && pageMove.length == 1) { // quill editor에서 이미지를 선택했을 때 파일 이름을 반환
				res.setContentType("text/plain:charset=utf-8");
				PrintWriter out = res.getWriter();
				out.print(obj);
				return;
			}
			//JSON 포맷으로 반환되는 값을 출력하기 - @ResponseBody, @RestController 역할 재현
			else {
				res.setContentType("text/plain:charset=utf-8");
				PrintWriter out = res.getWriter();
				out.print(obj);
				return;
			}
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req,res);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req,res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req,res);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req,res);
	}
}
