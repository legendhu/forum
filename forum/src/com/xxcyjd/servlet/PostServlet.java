package com.xxcyjd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxcyjd.dao.PostDao;
import com.xxcyjd.dao.factory.PostDaoFactory;
import com.xxcyjd.domain.Article;

public class PostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Article a = new Article();
		a.setAuthor("legendhu");//这里以后可以从session中取值
		a.setTitle(title);
		a.setContent(content);
		PostDao dao = PostDaoFactory.getInstance();
		dao.post(a);
		request.getRequestDispatcher("/servlet/ArticleServlet").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
