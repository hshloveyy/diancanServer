package com.gd.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gd.dao.UserDao;
import com.gd.entity.User;

public class CRegAction extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

            this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String method=request.getParameter("method");
		 PrintWriter out = response.getWriter();
		 if("creg".equals(method))
         {
        	 String name=request.getParameter("username");
        	 String password=request.getParameter("password");
        	 String phone=request.getParameter("phone");
        	 String realname=request.getParameter("realname");
        	 
        	 System.out.println(name+password+phone+realname);
        		 User vo=new User();
        		 vo.setName(name);
        		 vo.setPwd(password);
        		 vo.setPhone(phone);
        		 vo.setRealname(realname);
        		 UserDao dao=new UserDao();
        		 try {
        			 dao.insertUser(vo);
        			 out.print("ok");
				} catch (Exception e) {
					out.print("error");
				}
        	 }
         }

}
