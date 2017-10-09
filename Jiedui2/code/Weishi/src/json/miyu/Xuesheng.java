package json.miyu;

import java.util.Arrays;

public class Xuesheng {
	private String mingzi;
	private String xuehao;
	private int chengji;
	private String xingbie;
	private String []xingqu;
	private String []yiyuan;
	private String []kongxian;
	@Override
	public String toString() {
		return "Xuesheng [mingzi=" + mingzi + ", xuehao=" + xuehao + ", chengji=" + chengji + ", xingbie=" + xingbie
				+ ", xingqu=" + Arrays.toString(xingqu) + ", yiyuan=" + Arrays.toString(yiyuan) + ", kongxian="
				+ Arrays.toString(kongxian) + "]";
	}

	public Xuesheng (){
		
	}

	public String getMingzi() {
		return mingzi;
	}

	public void setMingzi(String mingzi) {
		this.mingzi = mingzi;
	}

	public String getXuehao() {
		return xuehao;
	}

	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}

	public int getChengji() {
		return chengji;
	}

	public void setChengji(int chengji) {
		this.chengji = chengji;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String[] getXingqu() {
		return xingqu;
	}

	public void setXingqu(String[] xingqu) {
		this.xingqu = xingqu;
	}

	public String[] getYiyuan() {
		return yiyuan;
	}

	public void setYiyuan(String[] yiyuan) {
		this.yiyuan = yiyuan;
	}

	public String[] getKongxian() {
		return kongxian;
	}

	public void setKongxian(String[] kongxian) {
		this.kongxian = kongxian;
	}
}
