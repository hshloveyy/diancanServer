package com.gd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gd.entity.Order;
import com.gd.util.DBManager;

public class OrderDao {

	private DBManager db = null;

	public OrderDao() {
		db = new DBManager();
	}

	public List<Order> getOrderList() {
		String sql = "select * from Orders order by id desc";
		List<Order> list = new ArrayList<Order>();
		ResultSet rs = db.getResultSet(sql);
		try {
			list = db.getOrderList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addOrder(Order vo) {
		String sql = "insert into Orders(name,address,price,phone,flag,content,memo) values('"
				+ vo.getName()
				+ "','"
				+ vo.getAddress()
				+ "','"
				+ vo.getPrice()
				+ "','"
				+ vo.getPhone()
				+ "','"
				+ vo.getFlag()
				+ "','" + vo.getContent() + "','" + vo.getMemo() + "')";
		db.execute(sql);
	}

	public void deleteOrderById(String id) {
		String sql = "delete from Orders where id=" + id;
		db.execute(sql);
	}

	public void updateOrder(Order vo) {
		String sql = "update Order set id=" + vo.getId() + ",name="
				+ vo.getName() + ",address=" + vo.getAddress() + ",price="
				+ vo.getPrice() + ",phone=" + vo.getPhone() + ",flag="
				+ vo.getFlag() + ",content=" + vo.getContent() + ",memo="
				+ vo.getMemo() + ", where id=" + vo.getId() + "";
		db.executeUpdate(sql);
	}

	public List<Order> getOrderListByName(String name) {
		String sql = "select * from Orders where name='" + name + "'";
		List<Order> list = new ArrayList<Order>();
		ResultSet rs = db.getResultSet(sql);
		try {
			list = db.getOrderList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void updateOrderflag(String id, String flag) {
		String sql = "update Orders set flag='" + flag + "' where id=" + id
				+ "";
		db.executeUpdate(sql);

	}

	public void ping(String id) {
		String sql = "update Orders set memo='บรฦภ' where id=" +id + "";
		db.executeUpdate(sql);

	}

}
