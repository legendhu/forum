package com.xxcyjd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxcyjd.dao.factory.UserDaoFactory;
import com.xxcyjd.domain.User;

public class ChangeInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = (String)request.getSession().getAttribute("username");
		if(username!=null){
			User u = UserDaoFactory.getInstance().selectUser(username);
			User user = new User();
			user.setUsername(u.getUsername());
			user.setTruename(request.getParameter("truename"));
			user.setEmail(request.getParameter("zhuce_email"));
			user.setTel(request.getParameter("tel-num"));
			UserDaoFactory.getInstance().updateUser(user);
			request.getRequestDispatcher("/userCenter.jsp").forward(request, response);
		}
		    request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
