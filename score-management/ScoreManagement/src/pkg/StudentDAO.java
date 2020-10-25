package pkg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;


public class StudentDAO {
	private static TreeSet<Student> stuSet;
	private File score = new File("data/score.txt");
	
	public StudentDAO() {
		stuSet = new TreeSet<>();
		String[][] data = Tool.getData(score);
		for(int i=0;i<data.length;i++) {
			addElementToSet(data[i], stuSet);
		}

	}
	
	
	private void addElementToSet(String[] data ,TreeSet<Student> set) {
		set.add(getStudent(data[0], data[1], data[2], data[3], data[4]));
	}
	
	
	public Student getStudent(String name,String id,String chinese,String math,String english) {
		return new Student(name,id,
				Integer.valueOf(chinese),
				Integer.valueOf(math),
				Integer.valueOf(english)
			);
	}
	
	public boolean addStudent(Student stu) {
		if(stuSet.add(stu)){
			Student[] stus = {stu};
			Tool.writeData(stus, score);
			return true;
		}
		return false;
	}
	
	
	/**
	 * @throws may throw null Pointer Exception
	 * @param id
	 * @return Student
	 */
	private Student searchStudent(String id) {
		Iterator<Student> it = stuSet.iterator();
		Student stu;
		while(it.hasNext()) {
			stu = it.next();
			if(stu.getId().equals(id)) {
				return stu;
			}
		}
		return null;
	}
	
	public boolean modifyName(String id,String name) {
		Student s = searchStudent(id);
		if(s!=null) {
			s.setName(name);
			return true;
		}
		return false;
	}
	
	public boolean modifyChinese(String id,int chinese) {
		Student s = searchStudent(id);
		if(s!=null) {
			s.setChinese(chinese);
			return true;
		}
		return false;
	}
	
	public boolean modifyMath(String id,int math) {
		Student s = searchStudent(id);
		if(s!=null) {
			s.setMath(math);
			return true;
		}
		return false;
	}
	
	public boolean modifyEnglishi(String id,int english) {
		Student s = searchStudent(id);
		if(s!=null) {
			s.setEnglish(english);
			return true;
		}
		return false;
	}
	
	public boolean modifyAll(String id,String name,int chinese,int math,int english) {
		Student s = searchStudent(id);
		if(s!=null) {
			s.setName(name);
			s.setChinese(chinese);
			s.setMath(math);
			s.setEnglish(english);
			return true;
		}
		return false;
	}
	
	public void delStudent(String id) {
			Student s = searchStudent(id);
			if(s!=null) {
				stuSet.remove(s);
			}
	}
	
	public void delStudents(String[] ids) {
		for(int i=0;i<ids.length;i++) {
			delStudent(ids[i]);
		}
	}
	

	
	public void printSortedByTotal(boolean isSheng) {
		Score.IS_SHENG_XU = isSheng;
		
		Score[] arr = new Score[stuSet.size()];
		int arr_idx = 0;
		Iterator<Student> it = stuSet.iterator();
		while(it.hasNext()) {
			Student stu = it.next();
			Score sc = new Score(stu.getId(), stu.getName(), stu.getTotail());
			arr[arr_idx++] = sc;
		}
		
		Arrays.sort(arr);
		System.out.println("序号：\t学号：\t姓名：\t总成绩：");
		for(int i=0;i<arr.length;i++) {
			System.out.println((i+1)+"\t"+arr[i].toString());
		}
	}
	
	
	public boolean createExamFailStudent(String url,String fileName) {
		ArrayList<Student> list = new ArrayList<>();
		
		Iterator<Student> it = stuSet.iterator();
		while(it.hasNext()) {
			Student stu = it.next();
			if(stu.getChinese()<60||stu.getMath()<60||stu.getEnglish()<60) {
				list.add(stu);
			}
		}

		File f;
		try {
			f = File.createTempFile(fileName, ".txt", new File(url));
			Tool.writeData(list.toArray(), f);
			f.renameTo(new File(url+fileName+".txt"));
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	void showStudentScore(String id) {
		Student s = this.searchStudent(id);
		if(s != null) {
			System.out.println("姓名：\t学号：\t语文：\t数学：\t英语：");
			s.showInfo();
		}
	}
	
	void showAllStudentScore() {
		Iterator<Student> it = stuSet.iterator();
		System.out.println("姓名：\t学号：\t语文：\t数学：\t英语：");
		while(it.hasNext()) {
			it.next().showInfo();
		}
	}
	
	void writeDataToFile() {
		Tool.cleanAll(score);
		Tool.writeData(stuSet.toArray(), score);
	}
	
}
