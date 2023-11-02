package com.spring.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecommandVO {

	private String recNum;	//예측번호
	private Date recDate;		//예측날짜
	private int recState;	//점등여부
	private String predUse;	//예측 전력 소비량
	private String hwCode;		//구간코드
	private String statNum;		//추천근거번호
	private String strState;
	public String getRecNum() {
		return recNum;
	}
	public void setRecNum(String recNum) {
		this.recNum = recNum;
	}
	public Date getRecDate() {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		long tmpTime = recDate.getTime();
		return new Date(tmpTime+(10*60*1000));
	}
	public void setRecDate(Date recDate) {
		 this.recDate = recDate;
	}
	public String getPredUse() {
		return predUse;
	}
	public void setPredUse(String predUse) {
		this.predUse = predUse;
	}
	public String getHwCode() {
		return hwCode;
	}
	public void setHwCode(String hwCode) {
		this.hwCode = hwCode;
	}
	public String getStatNum() {
		return statNum;
	}
	public void setStatNum(String statNum) {
		this.statNum = statNum;
	}
	public String getStrState() {
		return strState;
	}
	
	public void setStrState(String StrState) {
		this.strState= StrState;
	}
	public int getRecState() {
		return recState;
	}
	public void setRecState(int recState) {
		this.recState = recState;
	}
	
}
