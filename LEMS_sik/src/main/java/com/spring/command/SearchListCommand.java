
package com.spring.command;

public class SearchListCommand {
	private int page = 1;
	private int perPageNum = 14;
	private String keyword = "";
	private String searchType = "";
	private int startRowNum = 0;
	private String fromDate;
	private String toDate;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
		setStartRowNum();
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
		setStartRowNum();
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public int getStartRowNum() {
		return this.startRowNum;
	}
	public void setStartRowNum() {
		this.startRowNum = (this.page - 1) * this.perPageNum;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
}