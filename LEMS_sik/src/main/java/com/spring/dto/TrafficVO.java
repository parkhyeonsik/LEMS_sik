package com.spring.dto;

import java.util.Date;

public class TrafficVO {

	private String traffNum;	//교통번호
	private Date traffDate;	//교통량집계일시
	private String speedAvg;	//통행속도
	private String traff;		//교통량
	private String hwCode;		//구간코드
	private String occupancy; 	//점유율
	
	public String getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}
	public String getTraffNum() {
		return traffNum;
	}
	public void setTraffNum(String traffNum) {
		this.traffNum = traffNum;
	}
	public Date getTraffDate() {
		return traffDate;
	}
	public void setTraffDate(Date traffDate) {
		this.traffDate = traffDate;
	}
	public String getSpeedAvg() {
		return speedAvg;
	}
	public void setSpeedAvg(String speedAvg) {
		this.speedAvg = speedAvg;
	}
	public String getTraff() {
		return traff;
	}
	public void setTraff(String traff) {
		this.traff = traff;
	}
	public String getHwCode() {
		return hwCode;
	}
	public void setHwCode(String hwCode) {
		this.hwCode = hwCode;
	}

}
