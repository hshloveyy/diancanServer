package com.gd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gd.entity.Comment;
import com.gd.util.DBManager;

public class ComentDao {

	private DBManager db;

	public ComentDao() {
		db = new DBManager();
	}

	public List<Comment> getCommentList() {
		String sql = "select * from Comment order by id desc";
		List<Comment> list = new ArrayList<Comment>();
		ResultSet rs = db.getResultSet(sql);
		try {
			list = db.getCommentList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addComment(Comment vo) {
		String sql = "insert into Comment(content,username,foodid,foodname,memo) values('"
				+ vo.getContent()
				+ "','"
				+ vo.getUsername()
				+ "','"
				+ vo.getFoodid()
				+ "','"
				+ vo.getFoodname()
				+ "','"
				+ vo.getMemo() + "')";
		db.execute(sql);
	}

	public void deleteCommentById(String id) {
		String sql = "delete from Comment where id=" + id;
		db.execute(sql);
	}

	public void updateComment(Comment vo) {
		String sql = "update Comment set id=" + vo.getId() + ",content="
				+ vo.getContent() + ",username=" + vo.getUsername()
				+ ",foodid=" + vo.getFoodid() + ",foodname=" + vo.getFoodname()
				+ ",memo=" + vo.getMemo() + ", where id=" + vo.getId() + "";
		db.executeUpdate(sql);
	}

}
