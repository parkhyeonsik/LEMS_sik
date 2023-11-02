package com.spring.dto;

public class StatVO {

	private String statNum;			//추천근거번호
	private String precision;		//정밀도
	private String recall;			//재현율
	private String specificity;		//민감도
	private String accuracy;		//정확도
	private String f1score;			//F1점수
	private String mae;				//MAE
	private String mse;				//MSE
	
	public String getStatNum() {
		return statNum;
	}
	public void setStatNum(String statNum) {
		this.statNum = statNum;
	}
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	public String getRecall() {
		return recall;
	}
	public void setRecall(String recall) {
		this.recall = recall;
	}
	public String getSpecificity() {
		return specificity;
	}
	public void setSpecificity(String specificity) {
		this.specificity = specificity;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getF1score() {
		return f1score;
	}
	public void setF1score(String f1score) {
		this.f1score = f1score;
	}
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public String getMse() {
		return mse;
	}
	public void setMse(String mse) {
		this.mse = mse;
	}
	
	
}
