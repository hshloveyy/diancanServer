package com.gd.control;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.gd.dao.ComentDao;
import com.gd.dao.OrderDao;
import com.gd.dao.UserDao;
import com.gd.entity.Comment;
import com.gd.entity.Order;
import com.gd.entity.User;

public class CuserAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		OutputStream ps = response.getOutputStream();
		// PrintWriter out = response.getWriter();
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if ("update".equals(method)) {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String id = request.getParameter("id");
			String realname = request.getParameter("realname");
			User vo = new User();
			vo.setPwd(password);
			vo.setName(name);
			vo.setPhone(phone);
			vo.setRealname(realname);
			vo.setId(Integer.parseInt(id));
			try {
				new UserDao().updateUser(vo);
				// out.print("ok");
			} catch (Exception e) {
				// out.print("error");
			}

		}

		if ("updatepwd".equals(method)) {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				new UserDao().updatePwd(name, password);
				// out.print("ok");
			} catch (Exception e) {
				// out.print("error");
			}

		}
		if ("order".equals(method)) {
			String username = request.getParameter("username");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String content = request.getParameter("content");
            String price=request.getParameter("price");
			Order vo = new Order();
			vo.setAddress(address);
			vo.setPrice(price);
			vo.setContent(content);
			vo.setName(username);
			vo.setPhone(phone);
			vo.setFlag("已提交");

			OrderDao dao = new OrderDao();
			try {
				dao.addOrder(vo);
				ps.write("ok".getBytes("utf-8"));
			} catch (Exception e) {
				ps.write("error".getBytes("utf-8"));
			}

		}
		if ("comment".equals(method)) {
			String username = request.getParameter("username");
			String foodname = request.getParameter("foodname");
			String foodid = request.getParameter("id");
			String content = request.getParameter("name");

			Comment vo = new Comment();
			vo.setContent(content);
			vo.setFoodid(foodid);
			vo.setFoodname(foodname);
			vo.setUsername(username);
			vo.setMemo("dsf");

			ComentDao dao = new ComentDao();
			try {
				dao.addComment(vo);
				ps.write("ok".getBytes("utf-8"));
			} catch (Exception e) {
				ps.write("error".getBytes("utf-8"));
			}
		}
		if ("reg".equals(method)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String realname = request.getParameter("realname");
			String role = request.getParameter("role");

			User vo = new User();
			vo.setAddress(address);
			vo.setName(username);
			vo.setPhone(phone);
			vo.setPwd(password);
			vo.setRealname(realname);
			vo.setRole(role);

			UserDao dao = new UserDao();
			try {
				dao.insertUser(vo);
				ps.write("ok".getBytes("utf-8"));
			} catch (Exception e) {
				ps.write("error".getBytes("utf-8"));
			}

		}
		if ("find".equals(method)) {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			UserDao dao = new UserDao();
			User vo = dao.getUserByNP(name, password);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", "0");
			map.put("data", vo);
			// out.print(JSON.toJSONString(map));
			System.out.println(JSON.toJSONString(map));

		}
		if ("myorder".equals(method)) {
			String name = request.getParameter("username");
			OrderDao dao = new OrderDao();
			List<Order> vo = dao.getOrderListByName(name);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", "0");
			map.put("data", vo);
			ps.write(JSON.toJSONString(map).getBytes("utf-8"));
			// out.print(JSON.toJSONString(map));
			System.out.println(JSON.toJSONString(map));
		}
		if ("allorder".equals(method)) {
			OrderDao dao = new OrderDao();
			List<Order> vo = dao.getOrderList();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", "0");
			map.put("data", vo);
			ps.write(JSON.toJSONString(map).getBytes("utf-8"));
			// out.print(JSON.toJSONString(map));
			System.out.println(JSON.toJSONString(map));
		}
		if ("ping".equals(method)) {
			String id = request.getParameter("id");
			OrderDao dao = new OrderDao();
			try {
				dao.ping(id);
				ps.write("ok".getBytes("utf-8"));
			} catch (Exception e) {
				ps.write("error".getBytes("utf-8"));
			}

		}
		if ("jie".equals(method)) {
			String id = request.getParameter("id");
			String flag = request.getParameter("flag");
			if ("jiedan".equals(flag)) {
				flag = "已接单";

			} else {
				flag = "已配送";
			}

			OrderDao dao = new OrderDao();
			try {
				dao.updateOrderflag(id, flag);
				ps.write("ok".getBytes("utf-8"));
			} catch (Exception e) {
				ps.write("error".getBytes("utf-8"));
			}

		}
		if ("clogin".equals(method)) {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			UserDao dao = new UserDao();
			User vo = new User();

			vo = dao.getUserByNP(name, password);

			if ("user".equals(vo.getRole())) {
				ps.write("user".getBytes("utf-8"));
			} else {
				ps.write("admin".getBytes("utf-8"));
			}
		}

	}

}
