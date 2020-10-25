package model;

import java.io.File;
import java.util.Iterator;
import java.util.TreeSet;

import tool.IOUtil;


public class BookDao {
	private static TreeSet<Book> bookSet;
	
	public BookDao(){
		bookSet = new TreeSet<>();
		init();
	}
	
	public void init() {
		String[][] data = IOUtil.getData(new File("files/data.dat"));
		for(int i=0;i<data.length;i++) {
			addBook(data[i]);
		}
	}
	
	public boolean addBook(String[] data) {
		try {
			Book bk = new Book(Integer.valueOf(data[0]), data[1], data[2], data[3],
														Integer.valueOf(data[4]), data[5]);
			if(!bookSet.add(bk))return false;
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean delBook(int id) {
		Iterator<Book> it = bookSet.iterator();
		Book b;
		while(it.hasNext()) {
			b = it.next();
			if(b.getId()==id) {
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	public boolean modify(int id,int col,String val) {
		Iterator<Book> it = bookSet.iterator();
		Book b;
		while(it.hasNext()) {
			b = it.next();
			if(b.getId()==id) {
				switch(col) {
				case 1:
					b.setName(val);
					break;
				case 2:
					b.setSort(val);
					break;
				case 3:
					b.setPublisher(val);
					break;
				case 4:
					b.setCount(Integer.valueOf(val));
					break;
				case 5:
					b.setIsbn(val);
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean minusBook(int id) {
		Iterator<Book> it = bookSet.iterator();
		Book b;
		while(it.hasNext()) {
			b = it.next();
			if(b.getId()==id) {
				int cnt = b.getCount();
				if(cnt-1>0) {
					b.setCount(cnt-1);
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	public boolean riseBook(int id) {
		Iterator<Book> it = bookSet.iterator();
		Book b;
		while(it.hasNext()) {
			b = it.next();
			if(b.getId()==id) {
				int cnt = b.getCount();
				b.setCount(cnt+1);
				return true;
			}
		}
		return false;
	}
	
	public TreeSet<Book> getBookSet(){
		return bookSet;
	}
	
	public String[][] getData(){
		String[][] data = new String[bookSet.size()][6];
		Iterator<Book> it = bookSet.iterator();
		int idx = 0;
		Book bk;
		while(it.hasNext()) {
			bk = it.next();
			data[idx][0] = bk.getId()+"";
			data[idx][1] = bk.getName();
			data[idx][2] = bk.getSort();
			data[idx][3] = bk.getPublisher();
			data[idx][4] = bk.getCount()+"";
			data[idx][5] = bk.getIsbn();
			idx++;
		}
		return data;
	}
	
}
