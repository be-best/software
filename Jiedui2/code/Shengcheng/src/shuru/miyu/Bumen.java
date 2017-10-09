package shuru.miyu;

public class Bumen {
	private String num;
	private int shangxian;//0-15
	private String []tedian;
	private String []huodong;
	public Bumen (){
		
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getShangxian() {
		return shangxian;
	}
	public void setShangxian(int shangxian) {
		this.shangxian = shangxian;
	}
	public String[] getTedian() {
		return tedian;
	}
	public void setTedian(String[] tedian) {
		this.tedian = tedian;
	}
	public String[] getHuodong() {
		return huodong;
	}
	public void setHuodong(String[] huodong) {
		this.huodong = huodong;
	}
}
