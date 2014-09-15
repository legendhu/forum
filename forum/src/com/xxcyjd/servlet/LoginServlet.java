package com.xxcyjd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xxcyjd.dao.factory.UserDaoFactory;
import com.xxcyjd.domain.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String un = request.getParameter("login_user");
		String pw = request.getParameter("login_pass");
//		System.out.println(un);
//		System.out.println(pw);
		PrintWriter out = response.getWriter();
		User user01 = new User();
		user01.setUsername(un);
		user01.setPassword(pw);
		int code = UserDaoFactory.getInstance().select(user01);
		
		switch(code){
			case 1:
			out.print("用户名错误！");
			break;
			
			case 2:
			out.print("密码错误！");
			break;
			
			case 3:
			User user = UserDaoFactory.getInstance().selectUser(user01.getUsername());
			session.setAttribute("user",user);
			session.setAttribute("username",user.getUsername());
			out.print(request.getContextPath()+"/userCenter.jsp");
			break;
		
		
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
