package pkg;

import java.util.Scanner;

public class Control {
	Scanner sc = new Scanner(System.in);
	StudentDAO dao = new StudentDAO();
	public Control() {
		
		
	}
	
	public void printMenu() {
		System.out.println("系统菜单如下：（请键入命令关键字进行操作）");
		System.out.println("【1】查看学生成绩");
		System.out.println("【2】添加学生成绩");
		System.out.println("【3】修改学生成绩");
		System.out.println("【4】删除学生成绩");
		System.out.println("【5】成绩管理");
		System.out.println("【0】退出系统");
		System.out.println();
	}
	
	public void printStudentScoreMenu() {
		System.out.println("查看学生成绩子菜单如下：");
		System.out.println("【1】查看所有学生成绩");
		System.out.println("【2】查看指定学生成绩");
		System.out.println("【0】返回上一级");
		System.out.println();
	}
	
	public void printAddStudentMenu() {
		System.out.println("添加学生成 绩子菜单如下：");
		System.out.println("【1】添加单个学生成绩");
		System.out.println("【2】添加多个学生成绩");
		System.out.println("【0】返回上一级");
		System.out.println();
		
	}
	
	public void printModifyStudentMenu(){
		System.out.println("修改学生成绩信息成绩子菜单：");
		System.out.println("【1】修改姓名");
		System.out.println("【2】修改语文成绩");
		System.out.println("【3】修改数学成绩");
		System.out.println("【4】修改英语成绩");
		System.out.println("【5】修改姓名、语数英成绩");
		System.out.println("【0】返回上一级");
		System.out.println();
	}
	
	public void printDelStudentMenu() {
		System.out.println("删除学生成绩子菜单：");
		System.out.println("【1】删除单个学生成绩");
		System.out.println("【2】删除多个学生成绩");
		System.out.println("【0】返回上一级");
		System.out.println();
	}
	
	public void printScoreMenageMenu() {
		System.out.println("成绩管理子菜单如下：");
		System.out.println("【1】按总分排序并查看结果");
		System.out.println("【2】将不及格学成名单生成本地文件");
		System.out.println("【0】返回上一级");
		System.out.println();
		
	}
	
	public void mainMenu() {
		printMenu();
		printNext("系统主");

		switch(sc.nextInt()) {
			case 0:{
				dao.writeDataToFile();
				System.out.println("系统退出。");
				System.exit(0);
				break;
			}
			case 1:{
				printStudentScoreMenu();
				studentScoreMenu();
				break;
			}
			case 2:{
				printAddStudentMenu();
				addStudentMenu();
				break;
			}
			case 3:{
				printModifyStudentMenu();
				modifyStudentMenu();
				break;
			}
			case 4:{
				printDelStudentMenu();
				delStudentMenu();
				break;
			}
			case 5:{
				printScoreMenageMenu();
				scoreMenageMenu();
				break;
			}
			default:{
				mainMenu();
			}
		}
		System.out.println();
	}
	
	
	public void studentScoreMenu() {
		printNext("查看成绩子");

		switch(sc.nextInt()) {
			case 0:{
				mainMenu();
				break;
			}
			case 1:{
				dao.showAllStudentScore();
				break;
			}
			case 2:{
				System.out.println("请输入该学生的学号（id）：");
				String id = sc.next();
				dao.showStudentScore(id);
				break;
			}
			default:{
				System.out.print("你输入的指令错误，请重新");
				studentScoreMenu();
			}
		}
		studentScoreMenu();
	}
	
	
	
	public void addStudentMenu() {
		printNext("添加学生成绩子");
		int flog;
		flog = sc.nextInt();
		switch(flog) {
			case 0:{
				mainMenu();
				break;
			}
			case 1:{
				System.out.println("请按照姓名、学号、语文、数学、英语的顺序输入学生信息：");
				Student stu = dao.getStudent(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
				if(dao.addStudent(stu)){
					Tool.printFormatMessage("添加成功");
				}else {
					Tool.printFormatMessage("添加失败，请重新尝试。");
				}
				break;
			}
			case 2:{
				System.out.println("请输入要添加学生的个数：");
				int count = sc.nextInt();
				System.out.println("请按照姓名、学号、语文、数学、英语的顺序输入学生信息：");
				for(int i=0;i<count;i++) {
					Student stu = dao.getStudent(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
					if(!dao.addStudent(stu)){
						i--;
						Tool.printFormatMessage("添加失败，请重新尝试。");
					}
				}
				System.out.println("操作执行完成。");
				break;
			}
			default:{
				System.out.print("你输入的指令错误，请重新");
			}		
		}
		addStudentMenu();
	}
	
	
	
	public void modifyStudentMenu() {
		printNext("修改成绩子");
		int flog;
		flog = sc.nextInt();
		switch(flog) {
			case 0:{
				mainMenu();
				break;
			}
			case 1:{//修改学生姓名
				System.out.println("请输入学生学号（id）");
				String id = sc.next();
				System.out.println("请输入要修改的名字：");
				String name = sc.next();
				if(dao.modifyName(id, name)) {
					Tool.printFormatMessage("修改成功");
				}else {
					Tool.printFormatMessage("修改添加失败，请重新尝试。");
				}
				break;
			}
			case 2:{//修改语文成绩
				System.out.println("请输入该学生的学号（id）：");
				String id = sc.next();
				System.out.println("请输入要修改的语文成绩：");
				int chinese = sc.nextInt();
				if(dao.modifyChinese(id, chinese)) {
					Tool.printFormatMessage("修改成功");
				}else {
					Tool.printFormatMessage("修改添加失败，请重新尝试。");
				}
				break;
			}
			case 3:{//math
				System.out.println("请输入该学生的学号（id）：");
				String id = sc.next();
				System.out.println("请输入要修改的数学成绩：");
				int math = sc.nextInt();
				if(dao.modifyMath(id, math)) {
					Tool.printFormatMessage("修改成功");
				}else {
					Tool.printFormatMessage("修改添加失败，请重新尝试。");
				}
				break;
			}
			
			case 4:{
				System.out.println("请输入该学生的学号（id）：");
				String id = sc.next();
				System.out.println("请输入要修改的英语成绩：");
				int english = sc.nextInt();
				if(dao.modifyEnglishi(id, english)) {
					Tool.printFormatMessage("修改成功");
				}else {
					Tool.printFormatMessage("修改添加失败，请重新尝试。");
				}
				break;
			}
			
			case 5:{
				System.out.println("请输入该学生的学号（id）：");
				String id = sc.next();
				System.out.println("请输入要修改的名字：");
				String name = sc.next();
				System.out.println("请输入要修改的语文成绩：");
				int chinese = sc.nextInt();
				System.out.println("请输入要修改的数学成绩：");
				int math = sc.nextInt();
				System.out.println("请输入要修改的英语成绩：");
				int english = sc.nextInt();
				
				if(dao.modifyAll(id, name, chinese, math, english)) {
					Tool.printFormatMessage("修改成功");
				}else {
					Tool.printFormatMessage("修改添加失败，请重新尝试。");
				}
				break;
			}
			default:{
				System.out.print("你输入的指令错误，请重新");
			}		
		}
		modifyStudentMenu();
	}
	
	
	public void delStudentMenu() {
		printNext("删除学生子");
		int flog;
		flog = sc.nextInt();
		switch(flog) {
			case 0:{
				mainMenu();
				break;
			}
			case 1:{
				System.out.println("请输入该学生的学号（id）：");
				String id = sc.next();
				dao.delStudent(id);
				System.out.println("执行完成");
				break;
			}
			case 2:{
				System.out.println("请输入要删除几个学生的成绩：");
				int cnt = sc.nextInt();
				String[] ids = new String[cnt];
				System.out.println("请输入这"+cnt+"个学生的学号（id）：");
				for(int i=0;i<cnt;i++) {
					ids[i] = sc.next();
				}
				dao.delStudents(ids);
				System.out.println("执行完成");
				break;
			}
			default:{
				System.out.print("你输入的指令错误，请重新");
			}		
		}
		delStudentMenu();
	}
	
	
	public void scoreMenageMenu() {
		printNext("成绩管理子");
		int flog;
		flog = sc.nextInt();
		switch(flog) {
			case 0:{
				mainMenu();
				break;
			}
			case 1:{
				System.out.println("你想按什么顺序排列（降序1，升序2）请输入：");
				int xu = sc.nextInt();
				if(xu == 1) {
					dao.printSortedByTotal(false);
				}else {
					dao.printSortedByTotal(true);
				}
				
				break;
			}
			case 2:{
				System.out.println("请输入导出文件的地址url(例 G:/ 路径字符为英文半角）：");
				String url = sc.next();
				System.out.println("请输入导出文件的名称：（最少3个字符）");
				String fileName = sc.next();
				if(dao.createExamFailStudent(url, fileName)) {
					Tool.printFormatMessage("不及格学生导出成功");
				}else {
					Tool.printFormatMessage("导出失败，请重新尝试尝试。");
				}
				break;
			}
			default:{
				System.out.print("你输入的指令错误，请重新");
			}
		}

		scoreMenageMenu();
	}
	
	public static void printNext(String str) {
		System.out.print("输入"+str+"菜单指令关键字：");
	}
	
}
