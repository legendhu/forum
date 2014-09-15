package com.xxcyjd.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Article {
	private int id;
	private int pid;//主帖的pid=0
	private int rootId;//回复主帖的id
	private int count;//回帖数量
	private String title;//帖子标题
	private String content;//帖子内容
	private String author;//发帖人
	private Date date;//发帖时间
	private boolean isLeaf;//是否是叶子帖 1不是，0是
	private int grade;
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getRootId() {
		return rootId;
	}
	public void setRootId(int rootId) {
		this.rootId = rootId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public void initFromRs(ResultSet rs){
		try {
			setId(rs.getInt("id"));
			setPid(rs.getInt("pid"));
			setRootId(rs.getInt("rootId"));
			setCount(rs.getInt("count"));
			setTitle(rs.getString("title"));
			setDate(rs.getTimestamp("date"));
			setLeaf(rs.getInt("isleaf")==0 ? true:false);
			setContent(rs.getString("content"));
			setAuthor(rs.getString("author"));
			setGrade(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
