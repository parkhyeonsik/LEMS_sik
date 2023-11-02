package com.spring.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DaydataVO {

	private String dayNum;
	private String hwCode;
	private Date dayDate;
	private String dayEle;
	private String dayTrf;
	private String daySpd;
	private String dayOcc;
	private String dayPre;
	private String dayDlu;
	private String strDate;
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");

	
	public String getDayNum() {
		return dayNum;
	}
	public void setDayNum(String dayNum) {
		this.dayNum = dayNum;
	}
	public String getHwCode() {
		return hwCode;
	}
	public void setHwCode(String hwCode) {
		this.hwCode = hwCode;
	}
	public Date getDayDate() {
		return dayDate;
	}
	public void setDayDate(Date dayDate) {
		this.dayDate = dayDate;
	}
	public String getDayEle() {
		return dayEle;
	}
	public void setDayEle(String dayEle) {
		this.dayEle = dayEle;
	}
	public String getDayTrf() {
		return dayTrf;
	}
	public void setDayTrf(String dayTrf) {
		this.dayTrf = dayTrf;
	}
	public String getDaySpd() {
		return daySpd;
	}
	public void setDaySpd(String daySpd) {
		this.daySpd = daySpd;
	}
	public String getDayOcc() {
		return dayOcc;
	}
	public void setDayOcc(String dayOcc) {
		this.dayOcc = dayOcc;
	}
	public String getStrDate() {
		if(this.strDate==null) {
			return formatter.format(this.dayDate);}
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getDayDlu() {
		return dayDlu;
	}
	public void setDayDlu(String dayDlu) {
		this.dayDlu = dayDlu;
	}
	public String getDayPre() {
		return dayPre;
	}
	public void setDayPre(String dayPre) {
		this.dayPre = dayPre;
	}
	
}
