package com.xxcyjd.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxcyjd.dao.ArticleDao;
import com.xxcyjd.dao.factory.ArticleDaoFactory;
import com.xxcyjd.domain.Article;

public class ArticleFlatServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ArticleDao dao = ArticleDaoFactory.getInstance();
		List<Article> roots = new ArrayList<Article>();
		roots = dao.selectRoots();
		request.getSession(true).setAttribute("roots", roots);
		request.getRequestDispatcher("/articleFlat.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
