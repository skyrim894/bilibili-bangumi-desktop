package com.zzq.entity;

public class Anime {
	
	private String time;//更新时间
	private String name;//动漫名称
	private String link;//动漫链接
	private String image;//动漫图片
	private String count;//最新集数
	private boolean isChecked = false;//是否被鼠标点击
	private boolean isArrive = false;//是否鼠标到达
	
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	public boolean isArrive() {
		return isArrive;
	}
	public void setArrive(boolean isArrive) {
		this.isArrive = isArrive;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public Anime(String time, String name, String link, String image, String count) {
		super();
		this.time = time;
		this.name = name;
		this.link = link;
		this.image = image;
		this.count = count;
	}
	
	
}
