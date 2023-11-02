package com.spring.dto;

public class LightVO {

	private String lNum;	//가로등번호
	private int lState;		//가로등상태
	private String hwCode;
	

	public int getlState() {
		return lState;
	}
	public void setlState(int lState) {
		this.lState = lState;
	}
	public String getlNum() {
		return lNum;
	}
	public void setlNum(String lNum) {
		this.lNum = lNum;
	}
	public String getHwCode() {
		return hwCode;
	}
	public void setHwCode(String hwCode) {
		this.hwCode = hwCode;
	}
	
	
}
