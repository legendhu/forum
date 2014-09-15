package com.xxcyjd.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xxcyjd.dao.factory.UserDaoFactory;
import com.xxcyjd.domain.User;

public class UpLoadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String _filepath = null;
		User user = null;
		if(username!=null){
			User _user = UserDaoFactory.getInstance().selectUser(username);
			user = new User();
			user.setUsername(username);
			_filepath = _user.getPhoto();
		}
		String path = this.getServletContext().getRealPath("/");
		if(_filepath!=null){
			new File(path+_filepath).delete();
		}
		String head = null;
		if(username!=null){
			User headUser = UserDaoFactory.getInstance().selectUser(username);
			head = headUser.getView_photo();
		}	
		File file = new File(path+head);
		if(file.exists()){
			String filename = file.getName();
			FileInputStream in = new FileInputStream(path+head);
			FileOutputStream out = new FileOutputStream(path+CreatDir(path,filename,user));
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
			user = UserDaoFactory.getInstance().selectUser(username);
			session.setAttribute("user",user);
			response.getWriter().write("恭喜您修改成功！");		
			in.close();
			out.close();
		}	
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	public String CreatDir(String path,String filename,User user){
		String num = UUID.randomUUID().toString();
		int dir01 = num.hashCode()&0xf;
		int dir02 = (num.hashCode()>>4)&0xf;
		String dir =dir01+"/"+dir02+"/";
		File file = new File(path+"images/"+dir);
		if(!file.exists()){
			file.mkdirs();
		}
		if(user!=null){
			user.setPhoto("images/"+dir+filename);
			UserDaoFactory.getInstance().updateSt(user);
		}
		return "images/"+dir+filename;
	}

}
