package model;

public class Borrow {
	private int bookId;
	private int stuId;
	private String name;
	private String date;
	
	public Borrow(int bookId,int stuId,String name,String date) {
		this.bookId = bookId;
		this.stuId = stuId;
		this.name = name;
		this.date = date;
	}
	
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
}
