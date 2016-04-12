package com.gd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gd.entity.User;
import com.gd.util.DBManager;

public class UserDao {
	private DBManager db = null;

	public UserDao() {
		db = new DBManager();
	}

	/**
	 * 
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean checkUser(String name, String password) {
		String sql = "select count(1) from userinfo where name='" + name
				+ "' and pwd='" + password + "'";
		ResultSet rs = db.getResultSet(sql);
		boolean flag = false;
		try {
			flag = db.isExist(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public User getUserByNP(String name, String password) {
		List<User> list = new ArrayList<User>();
		String sql = "select * from userinfo where name='" + name
				+ "' and pwd='" + password + "'";
		ResultSet rs = db.getResultSet(sql);
		try {
			list = db.getUserList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.get(0);
	}

	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from userinfo";
		ResultSet rs = db.getResultSet(sql);
		try {
			list = db.getUserList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertUser(User vo) {
		String sql = "insert into userinfo(pwd,name,phone,realname,address,role) values('"
				+ vo.getPwd()
				+ "','"
				+ vo.getName()
				+ "','"
				+ vo.getPhone()
				+ "','"
				+ vo.getRealname()
				+ "','"
				+ vo.getAddress()
				+ "','"
				+ vo.getRole() + "')";
		db.execute(sql);
	}

	public void deleteUserById(String id) {
		String sql = "delete from userinfo where id=" + id;
		db.execute(sql);
	}

	public void updateUser(User vo) {
		String sql = "update userinfo set pwd='" + vo.getPwd() + "',name='"
				+ vo.getName() + "',phone='" + vo.getPhone() + "',realname='"
				+ vo.getRealname() + "',address='" + vo.getAddress()
				+ "' where id=" + vo.getId() + "";
		db.executeUpdate(sql);
	}

	public User getAllUserById(String id) {
		List<User> list = new ArrayList<User>();
		String sql = "select * from userinfo where id=" + id;
		ResultSet rs = db.getResultSet(sql);
		try {
			list = db.getUserList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.get(0);
	}

	public void updatePwd(String name, String password) {
		String sql = "update userinfo set pwd='" + password + "' where name='"
				+ name + "'";
		db.executeUpdate(sql);
	}
}
