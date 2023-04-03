package com.vti.entity.Abstraction.Question1;

public class News implements INews {
	private int ID;
	private String Title;
	private String PublishDate;
	private String Author;
	private String Content;
	private float AverageRate;
	private float[] rate;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public float getAverageRate() {
		return AverageRate;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public float[] getRate() {
		return rate;
	}

	public void setRate(float[] rates) {
		this.rate = rates;
	}

	@Override
	public void Display() {
		System.out.println("Title : " + Title);
		System.out.println("PublishDate : " + PublishDate);
		System.out.println("Author : " + Author);
		System.out.println("Content : " + Content);
		System.out.println("AverageRate : " + AverageRate);
	}

	@Override
	public float Calculate() {
		AverageRate = (float) ((rate[0] + rate[1] + rate[2]) / 3);
		return AverageRate;
	}

}
