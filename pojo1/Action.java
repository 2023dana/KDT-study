package com.example.demo.pojo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Action 인터페이스 선언
public interface Action {
    // execute 메서드 선언
    // HttpServletRequest와 HttpServletResponse를 매개변수로 받아와서 서블릿 요청을 처리하는 메서드
    // ServletException 및 IOException 예외를 처리해야 함
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException;
}
