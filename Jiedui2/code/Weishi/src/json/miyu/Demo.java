package json.miyu;

import java.io.File;
import java.util.Scanner;

public class Demo {
	
	public static void main(String[] args) {
		Shurulei pf=Duxie.du(new File(".\\import.txt"));
		Xuesheng []stu=pf.getStudents();//学生数组
		Bumen []dep=pf.getDepartments();//部门数组
		System.out.println("请输入优先原则：（1.活动时间、2.绩点、3.兴趣）");
		Scanner input = new Scanner(System.in);
		int fangfa;
		fangfa = 3;//输入排序原则
		int s=stu.length;//学生个数
		int d=dep.length;//部门个数
		switch(fangfa){
		case 1:time(s,d,stu,dep);break;
		case 2:rate(s,d,stu,dep);break;
		case 3:hobby(s,d,stu,dep);break;
		}
		input.close();
		//Shuchulei out = null;
		//Duxie.xie(out, new File(".\\output_condition.txt"));
	}
	
	private static void hobby(int s,int d,Xuesheng []stu,Bumen []dep) {
		// TODO Auto-generated method stub
		int i,j,h[][]=new int [d][s];
		Shuchulei out = new Shuchulei();//输出对象
		Pipei []studep = new Pipei [s*5];//匹配对象
		for (i=0;i<s*5;i++) {
			studep[i] = new Pipei();
		}
		String []ustu = new String[s];//没被选中的学生数组
		String []udep = new String[d];//没有选中学生的部门数组
		int cstu[]=new int[s];//学生选中情况（被选中为1，未被选中为0）
		int cdep[]=new int[d];//部门选人情况（有人为1没人为0）
		int count=0,ust=0,ude=0;
		int stunum;//最大匹配的学生
		for(i=0;i<d;i++){
			int max=dep[i].getShangxian();
			for(j=0;j<s;j++){//学生兴趣与部门匹配程度
				if(dep[i].want(stu[j].getYiyuan())){//判断学生是否报名该部门
					h[i][j]=dep[i].cmph(stu[j].getXingqu())*2;
					if(stu[j].getChengji()>=80)h[i][j]+=1;
					//System.out.println(h[i][j]);
				}
				else{
					h[i][j]=-2;
				}
			}
			for(int k=0;k<max;k++){
				stunum=maxstu(h[i],stu);
				System.out.println(stunum);
				if(stunum>=0){
					studep[count].setXuehao(stu[stunum].getXuehao());
					studep[count].setBumen(dep[i].getNum());
					count++;
					cdep[i]=1;
					cstu[stunum]=1;
				}
				else break;
			}
			if(cdep[i]==0){
				udep[ude]=dep[i].getNum();
				ude++;
			}
		}
		for(j=0;j<s;j++){
			//System.out.println(cstu[i]);
			if(cstu[j]==0){
				ustu[ust]=stu[j].getXuehao();
				ust++;
			}
		}
		Pipei []sd = new Pipei [count];
		String []us = new String[ust];
		String []ud = new String[ude];
		for(i=0;i<count;i++){
			sd[i]=studep[i];
		}
		for(i=0;i<ust;i++){
			us[i]=ustu[i];
		}
		for(i=0;i<ude;i++){
			ud[i]=udep[i];
		}
		out.setYipipei(sd);
		out.setMeipipei_bumen(ud);
		out.setMeipipei_xuesheng(us);
		Duxie.xie(out, new File(".\\output_condition.txt"));
	}
	
	private static int maxstu(int[] h,Xuesheng []stu) {
		// 选出最大下标学生
		int max=-2;
		int num=0;
		int i;
		for(i=0;i<h.length;i++){
			if(h[i]>max){
				max=h[i];
				num=i;
			}
		}
		System.out.println(max+"max");
		if(max>=0){
			h[num]=-2;
			return num;
		}
		else return -1;
	}

	private static void rate(int s,int d,Xuesheng []stu,Bumen []dep) {
		// 绩点
		int i,j,h[][]=new int [d][s];
		Shuchulei out = new Shuchulei();//输出对象
		Pipei []studep = new Pipei [s*5];//匹配对象
		for (i=0;i<s*5;i++) {
			studep[i] = new Pipei();
		}
		String []ustu = new String[s];//没被选中的学生数组
		String []udep = new String[d];//没有选中学生的部门数组
		int cstu[]=new int[s];//学生选中情况（被选中为1，未被选中为0）
		int cdep[]=new int[d];//部门选人情况（有人为1没人为0）
		int count=0,ust=0,ude=0;
		int stunum;//最大匹配的学生
		int max;//部门最大人数
		
		for(i=0;i<d;i++){
			max=dep[i].getShangxian();
			for(j=0;j<s;j++){
				if(dep[i].want(stu[j].getYiyuan())){
					h[i][j]=stu[j].getChengji();
				}
				else{
					h[i][j]=-2;
				}
			}
			for(int k=0;k<max;k++){
				stunum=maxstu(h[i],stu);
				System.out.println(stunum);
				if(stunum>=0){
					studep[count].setXuehao(stu[stunum].getXuehao());
					studep[count].setBumen(dep[i].getNum());
					count++;
					cdep[i]=1;
					cstu[stunum]=1;
				}
				else break;
			}
		}
		
		for(j=0;j<d;j++){
			if(cdep[j]==0){
				udep[ude]=dep[j].getNum();
				ude++;
			}
		}
		for(j=0;j<s;j++){
			//System.out.println(cstu[i]);
			if(cstu[j]==0){
				ustu[ust]=stu[j].getXuehao();
				ust++;
			}
		}
		Pipei []sd = new Pipei [count];
		String []us = new String[ust];
		String []ud = new String[ude];
		for(i=0;i<count;i++){
			sd[i]=studep[i];
		}
		for(i=0;i<ust;i++){
			us[i]=ustu[i];
		}
		for(i=0;i<ude;i++){
			ud[i]=udep[i];
		}
		out.setYipipei(sd);
		out.setMeipipei_bumen(ud);
		out.setMeipipei_xuesheng(us);
		Duxie.xie(out, new File(".\\output_condition.txt"));
	}

	private static void time(int s,int d,Xuesheng []stu,Bumen []dep) {
		// TODO Auto-generated method stub
		int i,j,h[][]=new int [d][s];
		Shuchulei out = new Shuchulei();//输出对象
		Pipei []studep = new Pipei [s*5];//匹配对象
		for (i=0;i<s*5;i++) {
			studep[i] = new Pipei();
		}
		String []ustu = new String[s];//没被选中的学生数组
		String []udep = new String[d];//没有选中学生的部门数组
		int cstu[]=new int[s];//学生选中情况（被选中为1，未被选中为0）
		int cdep[]=new int[d];//部门选人情况（有人为1没人为0）
		int count=0,ust=0,ude=0;
		int stunum;//最大匹配的学生
		int max;//部门最大人数
		
		for(i=0;i<d;i++){
			max=dep[i].getShangxian();
			for(j=0;j<s;j++){
				if(dep[i].want(stu[j].getYiyuan())){//判断学生是否报名该部门
					h[i][j]=dep[i].cmpt(stu[j].getKongxian())*2;
					if(stu[j].getChengji()>=80)h[i][j]+=1;
				}
				else{
					h[i][j]=-2;
				}
			}
			for(int k=0;k<max;k++){
				stunum=maxstu(h[i],stu);
				System.out.println(stunum);
				if(stunum>=0){
					studep[count].setXuehao(stu[stunum].getXuehao());
					studep[count].setBumen(dep[i].getNum());
					count++;
					cdep[i]=1;
					cstu[stunum]=1;
				}
				else break;
			}
		}
		
		for(j=0;j<d;j++){
			if(cdep[j]==0){
				udep[ude]=dep[j].getNum();
				ude++;
			}
		}
		for(j=0;j<s;j++){
			//System.out.println(cstu[i]);
			if(cstu[j]==0){
				ustu[ust]=stu[j].getXuehao();
				ust++;
			}
		}
		Pipei []sd = new Pipei [count];
		String []us = new String[ust];
		String []ud = new String[ude];
		for(i=0;i<count;i++){
			sd[i]=studep[i];
		}
		for(i=0;i<ust;i++){
			us[i]=ustu[i];
		}
		for(i=0;i<ude;i++){
			ud[i]=udep[i];
		}
		out.setYipipei(sd);
		out.setMeipipei_bumen(ud);
		out.setMeipipei_xuesheng(us);
		Duxie.xie(out, new File(".\\output_condition.txt"));
	}
	
}
