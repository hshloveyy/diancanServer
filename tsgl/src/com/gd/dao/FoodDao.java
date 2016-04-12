package com.gd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gd.entity.Food;
import com.gd.util.DBManager;

public class FoodDao {
	private DBManager db = null;

	public FoodDao() {
		db = new DBManager();
	}

	public List<Food> getFoodList() {
		String sql = "select * from Food order by id desc";
		List<Food> list = new ArrayList<Food>();
		ResultSet rs = db.getResultSet(sql);
		try {
			list = db.getFoodList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addFood(Food vo) {
		String sql = "insert into Food(name,url,price,monthcount,minutes,memo) values('"
				+ vo.getName()
				+ "','"
				+ vo.getUrl()
				+ "','"
				+ vo.getPrice()
				+ "','"
				+ vo.getMonthcount()
				+ "','"
				+ vo.getMinutes()
				+ "','"
				+ vo.getMemo() + "')";
		db.execute(sql);
	}

	public void deleteFoodById(String id) {
		String sql = "delete from Food where id=" + id;
		db.execute(sql);
	}

	public void updateFood(Food vo) {
		String sql = "update Food set name='" + vo.getName() + "',url='"
				+ vo.getUrl() + "',price='" + vo.getPrice() + "',monthcount='"
				+ vo.getMonthcount() + "',minutes='" + vo.getMinutes()
				+ "',memo='" + vo.getMemo() + "' where id=" + vo.getId() + "";
		db.executeUpdate(sql);
	}
}
