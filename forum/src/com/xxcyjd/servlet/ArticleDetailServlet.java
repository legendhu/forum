package com.xxcyjd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xxcyjd.dao.ArticleDetailDao;
import com.xxcyjd.dao.factory.ArticleDetailDaoFactory;
import com.xxcyjd.dao.factory.UserDaoFactory;
import com.xxcyjd.domain.Article;
import com.xxcyjd.domain.User;

public class ArticleDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String strId = request.getParameter("id");
		if(strId==null || strId.trim().equals("")) {
			return;
		}
		int  id = 0;
		try{
			id = Integer.parseInt(strId);
		}catch(NumberFormatException e ){
			return;
		}
		 
		ArticleDetailDao dao = ArticleDetailDaoFactory.getInstance();
		Article a = dao.selectArticleDetail(id);
		
		String username = a.getAuthor();
		User user = UserDaoFactory.getInstance().selectUser(username);
		
		session.setAttribute("user", user);
		request.setAttribute("a", a);
		request.getRequestDispatcher("/articleDetail.jsp").forward(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
