package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

import extraClass.MyTable;
import extraClass.MyTableModel;
import model.BookDao;
import model.BorrowDao;
import tool.IOUtil;


public class MainFrame extends JFrame {
	JPanel  jp = new JPanel();
	MyTable table;
	JScrollPane scroPane;
	ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	JPanel tablePanel;
	JPanel underPart;
	
	JRadioButton[] opt_arr = {
			new JRadioButton("添加图书"),
			new JRadioButton("借阅图书"),
			new JRadioButton("删除图书"),
	};
	JTextField[] add_jt = {
			new JTextField(),
			new JTextField(),
			new JTextField(),
			new JTextField(),
			new JTextField(),
			new JTextField(),
	};
	
	JTextField[] bor_jt = {
			new JTextField(),
			new JTextField(),
			new JTextField(),
	};
	
	JTextField del_jt;
	
	//按钮
	JButton del_jbt;
	JButton add_jbt;
	JButton bor_jbt1;
	JButton bor_jbt2;
	

	BookDao bookDao = new BookDao();
	BorrowDao borrowDao = new BorrowDao();
	
	Object[][] data = bookDao.getData();
	String[] head = {"编号","书名","类别","出版社","剩余数量","ISBN编号"};

	//已借阅信息按钮
	JButton bor_log;
	public void init() {
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrame.this, "您确定退出吗?", "温馨提示!",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					//写入数据
					writeFile();
					MainFrame.this.dispose();
				}
			}
		});
		
		
		//frame info
		this.setTitle("图书信息管理系统");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.add(jp);
		this.setResizable(false); 
		jp.setBounds(0, 0, 1000, 700); 
		jp.setLayout(null);
		
		//title
		JLabel jl = new JLabel("图书信息管理系统");
		jp.add(jl);
		jl.setFont(new Font("宋体", Font.BOLD, 29));
		jl.setBounds(360,10,300, 80);
		
		//初始化表格
		initTable(data);

		underPart = new JPanel(null);
		jp.add(underPart);
		underPart.setBounds(45, 390, 900, 260);
		
		JPanel optionPanel = new JPanel(null);
		underPart.add(optionPanel);
		
		optionPanel.setBounds(170, 10, 550, 50);
		
		MyListener listener = new MyListener();
		
		ButtonGroup group = new ButtonGroup();
		
		for(int i=0;i<opt_arr.length;i++) {
			optionPanel.add(opt_arr[i]);
			group.add(opt_arr[i]);
			opt_arr[i].setBounds(20+180*i, 5, 130, 35);
			opt_arr[i].addActionListener(listener);
		}
		
		opt_arr[0].setSelected(true);
		bor_log = new JButton("已借阅信息");
		underPart.add(bor_log);
		bor_log.setBounds(785, 225, 110, 30);
		bor_log.addActionListener(listener);
		
		initUnderPart(0);
		this.setVisible(true);
	}
	

	
	//dis_idx 0:add    1:bor    2:del
	public void initUnderPart(int dis_idx) {
		JPanel addPanel = new JPanel(null);
		underPart.add(addPanel);
		addPanel.setBounds(170, 75, 600, 150);
		panelList.add(addPanel);
		
		
		JPanel borrowPanel = new JPanel(null);
		underPart.add(borrowPanel);
		borrowPanel.setBounds(255, 70, 400, 150);
		panelList.add(borrowPanel);
		
		JPanel delPanel = new JPanel(null);
		underPart.add(delPanel);
		delPanel.setBounds(250, 85, 400, 80);
		panelList.add(delPanel);
		
		
		JLabel[] add_jl = {
				new JLabel("图书编号:"),
				new JLabel("书名:"),
				new JLabel("类别:"),
				new JLabel("出版社:"),
				new JLabel("数量:"),
				new JLabel("ISBN:"),
		};
		
		for(int i=0;i<3;i++) {
			addPanel.add(add_jl[i]);
			add_jl[i].setBounds(0, 35*i, 80, 28);
			add_jl[i].setHorizontalAlignment(JLabel.RIGHT);
			addPanel.add(add_jt[i]);
			add_jt[i].setBounds(100, 35*i, 120, 28);
		}

		for(int i=3,j=0;i<add_jl.length;i++,j++) {
			addPanel.add(add_jl[i]);
			add_jl[i].setBounds(210, 35*j, 80, 28);
			add_jl[i].setHorizontalAlignment(JLabel.RIGHT);
			addPanel.add(add_jt[i]);
			add_jt[i].setBounds(300, 35*j, 130, 28);
		}
		
		
		add_jbt = new JButton("添加");
		addPanel.add(add_jbt);
		add_jbt.setBounds(450, 20, 80, 60);
		add_jbt.addActionListener(listener);
		
		//借阅
		JLabel[] bor_jl = {
				new JLabel("*图书编号:"),
				new JLabel("*学生学号:"),
				new JLabel("学生姓名:"),
		};
		
		for(int i=0;i<bor_jl.length;i++) {
			borrowPanel.add(bor_jl[i]);
			bor_jl[i].setBounds(0, 35*i, 80, 28);
			bor_jl[i].setHorizontalAlignment(JLabel.RIGHT);
			borrowPanel.add(bor_jt[i]);
			bor_jt[i].setBounds(100, 35*i, 120, 28);
		}
		
		bor_jbt1 = new JButton("借阅");
		bor_jbt2 = new JButton("归还");
		borrowPanel.add(bor_jbt1);
		borrowPanel.add(bor_jbt2);
		
		bor_jbt1.setBounds(250, 10, 80, 30);
		bor_jbt2.setBounds(250, 50, 80, 30);
		
		bor_jbt1.addActionListener(listener);
		bor_jbt2.addActionListener(listener);
		
		JLabel tip = new JLabel("提示:借阅时信息均要填;归还时仅填[图书编号][学生学号]即可.");
		borrowPanel.add(tip);
		tip.setBounds(10, 110, 360, 20);
		//删除图书
		JLabel del_jl = new JLabel("所删除图书编号:");
		del_jt = new JTextField();
		del_jbt = new JButton(" 删除");
		del_jbt.addActionListener(listener);
		
		delPanel.add(del_jl);
		delPanel.add(del_jt);
		delPanel.add(del_jbt);
		
		del_jl.setHorizontalAlignment(JLabel.RIGHT);
		del_jl.setBounds(0, 5, 100, 25);
		del_jt.setBounds(110, 5, 100, 25);
		del_jbt.setBounds(230,5,80,25);
		
		
		if(dis_idx==0) {
			disPlay(addPanel); 
		}else if(dis_idx==1) {
			disPlay(borrowPanel); 
		}else if(dis_idx ==2) {
			disPlay(delPanel); 
		}
	}
	
	public void disPlay(JPanel jp) {
		jp.setVisible(true);
		for(int i=0;i<panelList.size();i++) {
			if(panelList.get(i)!=jp) {
				panelList.get(i).removeAll();
				panelList.get(i).setVisible(false);
			}
		}
	}
	

	//初始表格
	public void initTable(Object[][] data) {
		
		if(tablePanel!=null)tablePanel.removeAll(); 
		tablePanel = new JPanel(null);
		tablePanel.setBounds(45, 80, 900, 300); 
		if(scroPane!=null)scroPane.removeAll();
		table=new MyTable(new MyTableModel(data,head));
		table.setRowSelectionAllowed(false);
		table.addFocusListener(tableCellEditorListener);
		scroPane = new JScrollPane(table);
		tablePanel.add(scroPane);
		jp.add(tablePanel); 
		scroPane.setBounds(0, 0, 900, 300); 
	}

	//启动主方法
	public static void main(String[] args) {
		new MainFrame().init();
	}
	
	//关闭窗体写入数据
	public void writeFile() {
		//data
		File f = new File("files/data.dat");
		IOUtil.cleanAll(f);
		initTable(bookDao.getData());//更新表格
		IOUtil.writeData(bookDao.getData(), f);
		
		//borrow
		File f2 = new File("files/borrowInfo.dat");
		IOUtil.cleanAll(f2);
		IOUtil.writeData(borrowDao.getData(), f2);
		
	}
	
	
	class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()instanceof JRadioButton) {
				JRadioButton jrb = (JRadioButton)e.getSource();
				if(jrb == opt_arr[0]) {
					initUnderPart(0);
				}else if(jrb == opt_arr[1]) {
					initUnderPart(1);
				}else if(jrb == opt_arr[2]) {
					initUnderPart(2);
				}
			}else if(e.getSource() instanceof JButton) {
				JButton jbt = (JButton)e.getSource();
				if(jbt == add_jbt) {
					try {
						String[] arr = new String[6];
						for(int i=0;i<add_jt.length;i++) {
							arr[i] = add_jt[i].getText();
						}
						if(bookDao.addBook(arr)) {
							JOptionPane.showMessageDialog(MainFrame.this, "添加成功!");
							initTable(bookDao.getData());//更新表格
							for(int i=0;i<add_jt.length;i++)add_jt[i].setText("");
						}else {
							JOptionPane.showMessageDialog(MainFrame.this, "图书已存在(编号相同)或你输入的参数有误!请重试!");
						}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(MainFrame.this, "你输入的参数有误!请重试!");
					}
				}else if(jbt == bor_jbt1) {
					String[] arr = new String[4];
					for(int i=0;i<bor_jt.length;i++) {
						arr[i] = bor_jt[i].getText();
					}
					arr[3]=LocalDate.now().toString();
					boolean bool = bookDao.minusBook(Integer.valueOf(bor_jt[0].getText()));
					if(bool) {
						borrowDao.add(arr);
						JOptionPane.showMessageDialog(MainFrame.this, "借阅成功!");
						initTable(bookDao.getData());//更新表格
						for(int i=0;i<bor_jt.length;i++)bor_jt[i].setText("");
					}else {
						JOptionPane.showMessageDialog(MainFrame.this, "图书不足或参数输入错误!借阅失败");
					}
				}else if(jbt == bor_jbt2) {
					boolean bool=false;
					try {
						bool =borrowDao.del(Integer.valueOf(bor_jt[0].getText()), 
								Integer.valueOf(bor_jt[1].getText()));
						if((!bor_jt[0].getText().isBlank())&&(!bor_jt[1].getText().isBlank())&&bool) {
							JOptionPane.showMessageDialog(MainFrame.this, "还书成功!");
							bookDao.riseBook(Integer.valueOf(bor_jt[0].getText()));
							initTable(bookDao.getData());//更新表格
							for(int i=0;i<bor_jt.length;i++)bor_jt[i].setText("");
						}else {
							JOptionPane.showMessageDialog(MainFrame.this, "借阅记录不存在或参数输入错误!");
						}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(MainFrame.this, "你输入的参数有误!");
					}
				}else if(jbt == del_jbt) {
					if(!del_jt.getText().isBlank() &&bookDao.delBook(Integer.valueOf(del_jt.getText()))) {
						JOptionPane.showMessageDialog(MainFrame.this, "图书删除成功!");
						initTable(bookDao.getData());//更新表格
					}else {
						JOptionPane.showMessageDialog(MainFrame.this, "图书不存在或你的参数输入错误!");
					}
				}else if(jbt == bor_log) {
					new BorrowFrame(borrowDao.getData());
				}
			}
		}
	}
	//监听
	MyListener listener = new MyListener();
	
	
	class TableFocusListener implements FocusListener,CellEditorListener{
		int row = -1;
		int col = -1;
		TableCellEditor ed;
		@Override
		public void focusGained(FocusEvent e) {
			row = table.getSelectedRow();
			col = table.getSelectedColumn();
			if(row!=-1&&col!=-1) {
				ed = table.getCellEditor(row, col);
				ed.addCellEditorListener(this);
				ed.stopCellEditing();
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			
		}
		
		@Override
		public void editingStopped(ChangeEvent e) {
			if(col!=-1&&row!=-1) {
				bookDao.modify(Integer.valueOf(""+table.getValueAt(row, 0)), col,table.getValueAt(row, col).toString());
				ed.removeCellEditorListener(tableCellEditorListener);
			}
		}
		
		@Override
		public void editingCanceled(ChangeEvent e) {
			
		}
	}
	//焦点监听
	TableFocusListener tableCellEditorListener = new TableFocusListener();
	
}
