package model;

import java.io.File;
import java.util.ArrayList;

import tool.IOUtil;

public class BorrowDao {
	static File file;
	static ArrayList<Borrow> borrowList;
	public BorrowDao(){
		file = new File("files/borrowInfo.dat");
		borrowList = new ArrayList<>();
		init();
	}
	
	public void init() {
		String[][] data = IOUtil.getData(file);
		for(int i=0;i<data.length;i++) {
			add(data[i]);
		}
		
	}
	
	public boolean add(String[] data) {
		try {
			Borrow br = new Borrow(Integer.valueOf(data[0]),
					Integer.valueOf(data[1]), data[2],data[3]);
			if(borrowList.add(br))
				return true;
		}catch(Exception e) {
			return false;
		}
		return false;
	}
	
	public boolean del(int bookId,int stuId) {
		Borrow br;
		for(int i=0;i<borrowList.size();i++) {
			br = borrowList.get(i);
			if(br.getBookId()==bookId && br.getStuId()==stuId) {
				borrowList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public String[][] getData(){
			String[][] data = new String[borrowList.size()][4];
			Borrow bor;
			for(int i=0;i<borrowList.size();i++) {
				bor = borrowList.get(i);
				data[i][0] = bor.getBookId()+"";
				data[i][1] = bor.getStuId()+"";
				data[i][2] = bor.getName();
				data[i][3] = bor.getDate();
			}
			return data;
	}
}
