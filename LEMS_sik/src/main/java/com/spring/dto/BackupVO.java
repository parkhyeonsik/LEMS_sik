package com.spring.dto;

import java.util.Date;

public class BackupVO {

	private String backupNum;	//백업번호
	private String backupPath;	//백업경로
	private Date backupDate;	//백업날짜
	private String backupCate;	//카테고리
	private String fileNum;		//파일번호
	
	public String getBackupNum() {
		return backupNum;
	}
	public void setBackupNum(String backupNum) {
		this.backupNum = backupNum;
	}
	public String getBackupPath() {
		return backupPath;
	}
	public void setBackupPath(String backupPath) {
		this.backupPath = backupPath;
	}
	public Date getBackupDate() {
		return backupDate;
	}
	public void setBackupDate(Date backupDate) {
		this.backupDate = backupDate;
	}
	public String getBackupCate() {
		return backupCate;
	}
	public void setBackupCate(String backupCate) {
		this.backupCate = backupCate;
	}
	public String getFileNum() {
		return fileNum;
	}
	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}
	
	
}
