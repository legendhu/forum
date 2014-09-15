package com.xxcyjd.domain;

import java.util.List;

public class Page {
	private int totalrecord;//总记录
	private int pagesize=10;//每页显示的记录数
	private int totalpage;//总页数
	private int startindex;//开始页
	private List list;//
	private int pagenum;//当前页码编号
	private int forEachBegin;//
	private int forEachEnd;//
	private int forEachlength = 10;//
	
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	
	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getForEachBegin() {
		return forEachBegin;
	}

	public void setForEachBegin(int forEachBegin) {
		this.forEachBegin = forEachBegin;
	}

	public int getForEachEnd() {
		return forEachEnd;
	}

	public void setForEachEnd(int forEachEnd) {
		this.forEachEnd = forEachEnd;
	}

	public int getForEachlength() {
		return forEachlength;
	}

	public void setForEachlength(int forEachlength) {
		this.forEachlength = forEachlength;
	}

	public Page(){};
	
	public Page(int pagenum,int totalrecord){
		this.pagenum = pagenum;
		this.totalrecord = totalrecord;
		if(this.totalrecord%pagesize==0){
			totalpage = this.totalrecord/pagesize;
		}else{
			totalpage = this.totalrecord/pagesize+1;
		}
		
		startindex = (pagenum-1)*pagesize;
		if(totalpage<=10){
			forEachBegin = 1;
			forEachEnd = totalpage;
		}else{
			if(totalpage>10){
		
				forEachBegin = pagenum-4;
				forEachEnd = pagenum+5;
				if(forEachBegin<1){
					forEachBegin = 1;
					forEachEnd = 10;
				}
				if(forEachEnd>totalpage){
					forEachEnd = totalpage;
					forEachBegin = totalpage-10+1;
				}
			}
		}
		
	}

}