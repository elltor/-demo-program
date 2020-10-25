package pkg;

public class Student implements Comparable<Student>{
	private String id;
	private String name;
	private int chinese;
	private int math;
	private int english;
	private int totail;
	
	public Student(String name,String id,int chinese,int math,int english) {
		this.name = name;
		this.id = id;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		this.totail = chinese+math+english;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student && obj != null) {
			Student stud = (Student)obj;
			return this.id.equals(stud.id);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return name+','+id+','+chinese+','+math+','+english;
	}
	
	public void showInfo() {
		System.out.println( name+"\t"+id+"\t"+chinese+"\t"+math+"\t"+english);
	}

	@Override
	public int compareTo(Student stu) {
		return Integer.valueOf(this.id)-Integer.valueOf(stu.id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChinese() {
		return chinese;
	}

	public void setChinese(int chinese) {
		this.chinese = chinese;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getTotail() {
		return totail;
	}

	public void setTotail(int totail) {
		this.totail = totail;
	}
	
}
