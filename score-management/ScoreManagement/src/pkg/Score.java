package pkg;

public class Score implements Comparable<Score>{
	private String id;
	private String name;
	private int totail;
	
	public static boolean IS_SHENG_XU = false;
	
	public Score(String id,String name,int totail) {
		this.id = id;
		this.name = name;
		this.totail = totail;
		
	}
	
	
	@Override
	public int compareTo(Score o) {
		if(IS_SHENG_XU) {
			return this.totail - o.totail;
		}else {
			return -(this.totail - o.totail);
		}
	}

	@Override
	public String toString() {
		return id+"\t"+name+"\t"+totail;
	}
	
	
	
}
