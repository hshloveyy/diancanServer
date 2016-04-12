package com.gd.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gd.dao.UserDao;
import com.gd.entity.User;

public class UserAction extends HttpServlet {

	private static final long serialVersionUID = 7367183077449950089L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String method=request.getParameter("method");
         PrintWriter out=response.getWriter();
         String path="";
         if("clogin".equals(method))
         {
        	 String name=request.getParameter("username");
        	 String password=request.getParameter("password");
        	 UserDao dao=new UserDao();
        	 if(dao.checkUser(name, password)==true)
        	 {
        		 out.print("ok");
        		 
        	 }else
        	 {
        		 out.print("error");
        	 }
         }
         if("login".equals(method))
         {
        	 String name=request.getParameter("name");
        	 String password=request.getParameter("pwd");
        	 UserDao dao=new UserDao();
        	 
        	 if(dao.checkUser(name, password)==true)
        	 {
        		 User vo=dao.getUserByNP(name, password);
        		 request.getSession().setAttribute("user", vo);
        		 path="/admin/page/main/main.jsp";
        	 }else
        	 {
        		 path="/admin/page/user/login.jsp";
        	 }
         }
         if("list".equals(method))
         {
        	 UserDao dao=new UserDao();
        	 List<User> userList=dao.getAllUser();
        	 request.setAttribute("userList", userList);
        	 path="/admin/page/main/index.jsp";
         }
         if("doadd".equals(method))
         {
        	 String pwd=request.getParameter("pwd");
        	 String name=request.getParameter("name");
        	 String phone=request.getParameter("phone");
        	 
        	 User vo=new User();
        	 vo.setName(new String(name.getBytes("iso8859-1"),"utf-8"));
        	 vo.setPhone(phone);
        	 vo.setPwd(pwd);
        	 
        	 UserDao dao=new UserDao();
        	 dao.insertUser(vo);
        	 
        	 path="user?method=list";
        	 
         }
         if("toupdate".equals(method))
         {
        	 UserDao dao=new UserDao();
        	 String id=request.getParameter("id");
        	 User vo=dao.getAllUserById(id);
        	 request.setAttribute("users", vo);
        	 path="/admin/page/user/update.jsp";
         }
         if("delete".equals(method))
         {
        	 UserDao dao=new UserDao();
        	 String id=request.getParameter("id");
        	 dao.deleteUserById(id);
        	 path="user?method=list";
         }
         if("doupdate".equals(method))
         {
        	 String id=request.getParameter("id");
        	 String pwd=request.getParameter("pwd");
        	 String name=request.getParameter("name");
        	 String phone=request.getParameter("phone");
        	 
        	 User vo=new User();
        	 vo.setName(new String(name.getBytes("iso8859-1"),"utf-8"));
        	 vo.setPhone(phone);
        	 vo.setPwd(pwd);
        	 vo.setId(Integer.parseInt(id));
        	 
        	 UserDao dao=new UserDao();
        	 dao.updateUser(vo);
        	 
        	 path="user?method=list";
         }
         request.getRequestDispatcher(path).forward(request, response);
	}

}
