package com.xxcyjd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xxcyjd.dao.UserDao;
import com.xxcyjd.dao.factory.UserDaoFactory;
import com.xxcyjd.domain.User;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("zhuce_user");
		String password = request.getParameter("zhuce_mima");
		String sex = request.getParameter("sex");
		String major = request.getParameter("education_bg");
		String email = request.getParameter("zhuce_email");
		String tel = request.getParameter("tel-num");
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setSex(sex);
		u.setMajor(major);
		u.setEmail(email);
		u.setTel(tel);
		boolean flag = false;
		UserDao dao = UserDaoFactory.getInstance();
		flag = dao.insert(u);
		if(flag==true){
			//response.getWriter().write("insert ok!");
			session.setAttribute("user",u);
			request.getRequestDispatcher("/replyDeal.jsp").forward(request, response);
			
		}else{
			response.getWriter().write("insert fail");
			return;
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
