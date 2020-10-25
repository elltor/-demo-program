package tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {
	public static String[][] getData(File file){
		BufferedReader br = null;
		String[][] data = null;
		List<String[]> list = new ArrayList<String[]>();
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine())!=null) {
				String[] arr = line.split(",");
				list.add(arr);
			}
			data = new String[list.size()][];
			for(int i=0;i<list.size();i++)
				data[i] = list.get(i);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public static void writeData(String[][] data,File file){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file,Charset.forName("utf-8"),true));
			StringBuilder sb = new StringBuilder(200);
			for(int i=0;i<data.length;i++) {
				for(int j=0;j<data[i].length;j++) {
					sb.append(data[i][j]).append(',');
				}
				sb.deleteCharAt(sb.length()-1);
				bw.write(sb.toString()+"\n");
				sb.delete(0,sb.length());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 清除数据
	 * @param file
	 */
	public static void cleanAll(File file) {
		RandomAccessFile rf = null;
		try {
			rf = new RandomAccessFile(file, "rw");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		FileChannel fc = rf.getChannel();
		try {
			fc.truncate(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			rf.close();
			fc.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
