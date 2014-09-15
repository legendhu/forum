package com.xxcyjd.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xxcyjd.dao.ArticleDao;
import com.xxcyjd.dao.factory.ArticleDaoFactory;
import com.xxcyjd.domain.Article;
import com.xxcyjd.domain.Page;
import com.xxcyjd.util.JdbcUtil;

public class ArticleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		List<Article> articles = new ArrayList<Article>();
	    ArticleDaoFactory.getInstance().tree(articles,0,0);
	    session.setAttribute("articles", articles);
	    /*
		int totalrecord = ArticleDaoFactory.getInstance().getTotalRecord();
		String pagenum = request.getParameter("pagenum");
		Page page = null;
		if(pagenum==null){
			page = new Page(1,totalrecord);
		}else{
			page =  new Page(Integer.parseInt(pagenum),totalrecord);
		}
		
		
		List list = ArticleDaoFactory.getInstance().getPageArticle(page.getStartindex(),page.getPagesize());
	    page.setList(list);
		session.setAttribute("page",page);*/
		request.getRequestDispatcher("/article.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
