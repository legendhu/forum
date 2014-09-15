package com.xxcyjd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xxcyjd.dao.factory.AdminDaoFactory;
import com.xxcyjd.domain.Admin;

public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Admin admin = new Admin();
		admin.setUsername(request.getParameter("username"));
		admin.setPassword(request.getParameter("password"));
		boolean flag = AdminDaoFactory.getInstance().select(admin);
		if(flag){
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
		}else{
			response.getWriter().write("用户名或密码错误！");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
