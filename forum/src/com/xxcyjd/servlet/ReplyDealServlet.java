package com.xxcyjd.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxcyjd.dao.ReplyDealDao;
import com.xxcyjd.dao.factory.ReplyDealDaoFactory;
import com.xxcyjd.domain.Article;

public class ReplyDealServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int pid = Integer.parseInt(request.getParameter("pid"));
		int rootId = Integer.parseInt(request.getParameter("rootId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Article a = new Article();
		a.setPid(pid);
		a.setRootId(rootId);
		a.setCount(0);
		a.setAuthor("legendhu");//这里以后可以从session中取值
		//a.setDate(new Date());
		a.setTitle(title);
		a.setContent(content);
		a.setLeaf(true);
		ReplyDealDao dao = ReplyDealDaoFactory.getInstance();
		dao.insert(a);
		request.getRequestDispatcher("/servlet/ArticleServlet").forward(request, response);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
