package extraClass;


import javax.swing.JTable;

public class MyTable extends JTable{
	
	{
		this.setRowHeight(28);
	}
	
	public MyTable(Object[][] data,Object[] head) {
		super(data, head);
		
	}
	public MyTable(MyTableModel myTableModel) {
		super(myTableModel);
	}
 	
}
