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
import com.gd.dao.FoodDao;
import com.gd.dao.UserDao;
import com.gd.entity.Food;
import com.gd.entity.User;

public class FoodAction extends HttpServlet {

	/**
	 * 
	 */
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
		if ("find".equals(method)) {
			FoodDao dao = new FoodDao();
			List<Food> vo = dao.getFoodList();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", "0");
			map.put("data", vo);
			ps.write(JSON.toJSONString(map).getBytes("utf-8"));
			// out.print();
			System.out.println(JSON.toJSONString(map));

		}

	}

}
