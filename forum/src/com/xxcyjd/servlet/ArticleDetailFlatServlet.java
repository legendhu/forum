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
import com.xxcyjd.domain.Article;

public class ArticleDetailFlatServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String strId = request.getParameter("id");
		if(strId==null || strId.trim().equals("")) {
			System.out.println("Error ID");
			return;
		}
			
		int  id = 0;
		try{
			id = Integer.parseInt(strId);
		}catch(NumberFormatException e ){
			System.out.println("Error ID Again");
			return;
		}
		
		ArticleDetailDao dao = ArticleDetailDaoFactory.getInstance();
		List<Article> kids = dao.selectKids(id);
		//System.out.println(kids.size());
		session.setAttribute("kids", kids);
		request.getRequestDispatcher("/articleDetailFlat.jsp").forward(request, response);
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
