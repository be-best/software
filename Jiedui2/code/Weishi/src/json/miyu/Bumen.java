package json.miyu;

import java.util.Arrays;

public class Bumen {
	private String name;
	private String num;
	private int shangxian;//0-15
	private String []tedian;
	private String []huodong;
	public Bumen (){
		
	}
	@Override
	public String toString() {
		return "Bumen [name=" + name + ", num=" + num + ", shangxian=" + shangxian + ", tedian="
				+ Arrays.toString(tedian) + ", huodong=" + Arrays.toString(huodong) + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int cmph(String[] xingqu) {
		// 比较兴趣
		int s=tedian.length;
		int l=xingqu.length;
		int a=0;
		for(int i=0;i<s;i++){
			for(int j=0;j<l;j++){
				if(tedian[i].equals(xingqu[j]))a++;
			}
		}
		return a;
	}
	public boolean want(String[] yiyuan) {
		// 判断该学生是否有报该部门
		int s=yiyuan.length;
		for(int i=0;i<s;i++){
			//System.out.println(yiyuan[i]+num);
			if(yiyuan[i].equals(num)){
				//System.out.println(yiyuan[i]+num);
				return true;
			}
		}
		return false;
	}
	public int cmpt(String[] kongxian) {
		// 比较空闲时间
		int s=huodong.length;
		int l=kongxian.length;
		int a=0;
		for(int i=0;i<s;i++){
			for(int j=0;j<l;j++){
				if(huodong[i].equals(kongxian[j])){
					kongxian[j]+="busy";
					a++;
				}
			}
		}
		return a;
	}
	

}
