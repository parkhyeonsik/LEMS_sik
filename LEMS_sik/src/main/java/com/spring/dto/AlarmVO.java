package com.spring.dto;

import java.util.Date;

public class AlarmVO {

	private String alarmNum;	//알림번호
	private Date alarmDate;		//알림날짜
	private String elecError;	//전력오차
	private String hwCode;		//구간코드
	private String alarmStrDate; 
	
	public String getAlarmNum() {
		return alarmNum;
	}
	public void setAlarmNum(String alarmNum) {
		this.alarmNum = alarmNum;
	}
	
	public Date getAlarmDate() {
		return alarmDate;
	}
	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}
	public String getAlarmStrDate() {
		return alarmStrDate;
	}
	public void setAlarmStrDate(String alarmStrDate) {
		this.alarmStrDate = alarmStrDate;
	}
	public String getElecError() {
		return elecError;
	}
	public void setElecError(String elecError) {
		this.elecError = elecError;
	}
	public String getHwCode() {
		return hwCode;
	}
	public void setHwCode(String hwCode) {
		this.hwCode = hwCode;
	}
	
}
