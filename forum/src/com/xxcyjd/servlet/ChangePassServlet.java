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


public class ChangePassServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String password = request.getParameter("pass1");
		String pass = request.getParameter("pass2");
		PrintWriter out = response.getWriter();
		if(username!=null){
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			int code = UserDaoFactory.getInstance().select(user);
			switch(code){
			case 2:
				out.write("error");
				break;
			case 3:
				User user01 = new User();
				user01.setPassword(pass);
				user01.setUsername(username);
				UserDaoFactory.getInstance().changePass(user01);
				out.write("success");
				break;
			}
			
		}else{
			out.write("no user!");		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
