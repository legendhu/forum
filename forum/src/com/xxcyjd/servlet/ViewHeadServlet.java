package com.xxcyjd.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xxcyjd.dao.factory.UserDaoFactory;
import com.xxcyjd.domain.User;



public class ViewHeadServlet extends HttpServlet {

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
			_filepath = _user.getView_photo();
		}
		String path = this.getServletContext().getRealPath("/");
		if(_filepath!=null){
			new File(path+_filepath).delete();
		}
		
		DiskFileItemFactory factory	= new DiskFileItemFactory();
		factory.setSizeThreshold(1024*10);
		factory.setRepository(new File(path+"\\WEB-INF\\temp"));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");

		if(!upload.isMultipartContent(request)){
			response.sendRedirect(request.getHeader("referer"));
		}else{
			 String str;
			 FileItem item = null;
			 InputStream	in = null;
			 FileOutputStream out = null;
			try {
				List list = upload.parseRequest(request);
				Iterator it = list.iterator();
				while(it.hasNext()){
					item = (FileItem) it.next();
					if(!item.isFormField()){
						String name = item.getName();
						int code = name.lastIndexOf(".");
						str ="."+name.substring(code+1);
						
						if(check(item)){
								out = new FileOutputStream(path+"view/"+CreatDir(path,str,user)); 
								in = item.getInputStream();
								byte[] buffer = new byte[1024];
								int len = 0;
								while((len=in.read(buffer))>0){
									out.write(buffer,0,len);
								}
								String head = null;
								if(username!=null){
									User headUser = UserDaoFactory.getInstance().selectUser(username);
									head = headUser.getView_photo();
								}
								request.setAttribute("head",head);
								request.getRequestDispatcher("/head.jsp").forward(request, response);
						}else{
							response.getWriter().write("<script>alert('File format or size is incorrect, please re-select!')</script>");
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}finally{
				release(out, in, item);
			}	
			
		}
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request,response);	
}

public String CreatDir(String path,String str,User user){
	String num = UUID.randomUUID().toString();
	int dir01 = num.hashCode()&0xf;
	int dir02 = (num.hashCode()>>4)&0xf;
	String dir =dir01+"/"+dir02+"/";
	File file = new File(path+"view/"+dir);
	if(!file.exists()){
		file.mkdirs();
	}
	String filename = num+str;
	if(user!=null){
		user.setView_photo("view/"+dir+filename);
		UserDaoFactory.getInstance().updateStView(user);
	}
	return dir+filename;
}


public boolean check(FileItem item){
	if(item!=null&&!item.getName().equals("")){
		if(item.getSize()<1000*500&&item.getSize()>0){
			if(item.getContentType().startsWith("image/")){
				return true;
			}
		}
	}
	return false;
}



public  void release(FileOutputStream out,InputStream in,FileItem item){
	try{
		if(out!=null){
		out.close();
		}
	}catch (Exception e) {
		e.printStackTrace();
		out=null;
	}
	try{
		if(in!=null){
		in.close();
		}
	}catch (Exception e) {
		e.printStackTrace();
		in=null;
	}
	try{
		if(item!=null){
		item.delete();
		}
	}catch (Exception e) {
		e.printStackTrace();
		item=null;
	}
}
}