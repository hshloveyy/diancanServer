package com.gd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gd.entity.Comment;
import com.gd.entity.Food;
import com.gd.entity.Order;
import com.gd.entity.User;

public class DBManager {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private ResultSetMetaData stmd = null;

	public DBManager() {

		String dri = "com.mysql.jdbc.Driver";
//		String user = "root";
//		String pass = "123456";
		String user = "hshloveyy";
		String pass = "hshloveyy";
		String url = "jdbc:mysql://localhost:3306/crm?characterEncoding=utf-8";

		try {
			Class.forName(dri);
		} catch (Exception e) {
			System.out.println("Load Driver Error");
		}
		try {
			conn = DriverManager.getConnection(url, user, pass);
			if (conn != null) {
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
			}
		} catch (Exception e) {
			System.out.println("Connect DB Error");
		}
	}

	public ResultSet getResultSet(String sql) {
		try {
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				return rs;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Get RecordSet Error!");
		}
		return rs;
	}

	public void execute(String sql) {
		try {
			stmt.execute(sql);
		} catch (Exception e) {
			System.out.println("Execute DB Sql Error!" + e);
		}
	}

	public boolean isExist(ResultSet rs) throws SQLException {

		int result = 0;

		rs.next();
		result = rs.getInt(1);

		System.out.println(result);

		rs.close();

		if (result == 0)
			return false;
		else
			return true;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Close DB Connection Error!");
		}
	}

	public boolean executeUpdate(String sql) {
		try {
			int count = stmt.executeUpdate(sql);
			if (count != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Update DB Error!" + e);
			return false;
		}
	}

	public List<User> getUserList(ResultSet rs) throws SQLException {
		List<User> list = new ArrayList<User>();
		if (rs != null) {
			while (rs.next()) {
				User vo = new User();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setPhone(rs.getString("phone"));
				vo.setRealname(rs.getString("realname"));
				vo.setAddress(rs.getString("address"));
				vo.setRole(rs.getString("role"));
				list.add(vo);
			}
		}
		return list;
	}

	public List<Food> getFoodList(ResultSet rs) throws SQLException {
		List<Food> list = new ArrayList<Food>();
		if (rs != null) {
			while (rs.next()) {
				Food vo = new Food();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setUrl(rs.getString("url"));
				vo.setPrice(rs.getString("price"));
				vo.setMonthcount(rs.getString("monthcount"));
				vo.setMinutes(rs.getString("minutes"));
				vo.setMemo(rs.getString("memo"));
				list.add(vo);
			}
		}
		return list;
	}

	public List<Order> getOrderList(ResultSet rs) throws SQLException {
		List<Order> list = new ArrayList<Order>();
		if (rs != null) {
			while (rs.next()) {
				Order vo = new Order();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setPrice(rs.getString("price"));
				vo.setPhone(rs.getString("phone"));
				vo.setFlag(rs.getString("flag"));
				vo.setContent(rs.getString("content"));
				vo.setMemo(rs.getString("memo"));
				list.add(vo);
			}
		}
		return list;
	}

	public List<Comment> getCommentList(ResultSet rs) throws SQLException {
		List<Comment> list = new ArrayList<Comment>();
		if (rs != null) {
			while (rs.next()) {
				Comment vo = new Comment();
				vo.setId(rs.getString("id"));
				vo.setContent(rs.getString("content"));
				vo.setUsername(rs.getString("username"));
				vo.setFoodid(rs.getString("foodid"));
				vo.setFoodname(rs.getString("foodname"));
				vo.setMemo(rs.getString("memo"));
				list.add(vo);
			}
		}
		return list;
	}

}