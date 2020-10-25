package frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BorrowFrame extends JFrame{
	public BorrowFrame(String[][] data) {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
					BorrowFrame.this.dispose();
			}
		});
		
		this.setLayout(null);
		this.setTitle("借阅信息");
		this.setSize(400, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		String[] head = {
				"借阅图书编号",
				"学号",
				"姓名",
				"日期",
		};
		JScrollPane sc = new JScrollPane(new JTable(data,head));
		this.add(sc);
		sc.setBounds(0, 0, 400, 700);
		this.setVisible(true);
	}
}
