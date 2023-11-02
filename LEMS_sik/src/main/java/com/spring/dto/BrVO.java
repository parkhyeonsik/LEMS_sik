package com.spring.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BrVO {

	private String brNum;		//고장번호
	private String brContent;	//고장내용
	private Date brDate;		//고장날짜
	private int brState;		//처리여부
	private String hwCode;
	private String strDate;
	private String strState;
	
	public String getBrNum() {
		return brNum;
	}
	public void setBrNum(String brNum) {
		
		this.brNum = brNum;
	}
	public String getBrContent() {
		return brContent;
	}
	public void setBrContent(String brContent) {
		this.brContent = brContent;
	}
	public Date getBrDate() {
		return brDate;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public void setBrDate(Date brDate) {
		this.brDate = brDate;
	}
	public int getBrState() {
		return brState;
	}
	
	
	public void setBrState(int brState) {
		this.brState = brState;
		setStrState(brState);
	}

	public String getHwCode() {
		return hwCode;
	}
	public void setHwCode(String hwCode) {
		this.hwCode = hwCode;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getStrState() {
		return strState;
	}
	public void setStrState(int brState) {
		if(brState==0) {
			this.strState="고장";
		}else if(brState==1) {
			this.strState="수리중";
		}else {
			this.strState="수리완료";
		}
		
	}
	
	
	
}
