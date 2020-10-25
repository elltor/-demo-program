package model;

public class Book implements Comparable<Book>{
	private int id;
	private String name;
	private String sort;
	private String publisher;
	private int count;
	private String isbn;
	
	public Book() {
		id = 0;
		name = "";
		sort = "";
		publisher = "";
		count = 0;
		isbn = "";
	}
	
	public Book(int id,String name,String sort,String publisher,int cnt,String isbn) {
		this.id = id;
		this.name = name;
		this.sort = sort;
		this.publisher = publisher;
		this.count = cnt;
		this.isbn = isbn;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj instanceof Book) {
			Book bk = (Book)obj;
			if(this.id == bk.id)
				return true;
			else
				return false;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		sb.append(id).append("  ").append(name).append("  [").append(publisher)
		.append("]  ").append(isbn);
		
		return sb.toString();
	}

	@Override
	public int compareTo(Book o) {
		return id-o.id;
	}
	
}
