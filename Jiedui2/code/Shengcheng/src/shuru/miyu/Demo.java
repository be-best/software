package shuru.miyu;

import java.io.File;
import java.util.Random;

import org.junit.Test;

public class Demo {
	public static void main(String[] args) {
		String []free_time={ 
				"Mon.8:00~10:00",
		  		"Mon.22:00~24:00",
				"Mon.18:00~20:00",
				"Tues.12:00~14:00",
				"Tues.18:00~20:00",
				"Tues.20:00~21:00",
				"Wed.16:00~18:00",
		        "Wed.20:00~22:00",
		        "Thur.18:00~20:00",
		        "Thur.14:00~16:00",
		        "Thur.20:00~22:00",
		        "Fri.12:00~14:00",
		        "Fri.8:00~10:00",
		        "Fri.22:00~24:00",
		        "Sat.14:00~16:00",
		        "Sat.20:00~22:00",
		        "Sun.16:00~18:00",
				"Sun.20:00~22:00",
		        "Sun.14:00~16:00",
		        "Sun.8:00~10:00"
				};
		String []tags={
				"basktball",
				"football",
				"programming",
				"reading", 
				"study", 
	            "film",
	            "gameing", 
	            "chess",
	            "dance",
	            "sing"
	            };
		String []depart_no={
				"D01",
				"D02",
				"D03",
				"D04",
				"D05",
				"D06",
				"D07",
				"D08",
				"D09",
				"D10",
				"D11",
				"D12",
				"D13",
				"D14",
				"D15",
				"D16",
				"D17",
				"D18",
				"D19",
				"D20"
				};
		boolean []judge=new boolean[20];
		Random r=new Random(); 
		int i=0;
		Shuchulei out=new Shuchulei();
		Xuesheng []stu=new Xuesheng [300];
		for(i=0;i<300;i++){
			stu[i]=new Xuesheng();
		}
		Bumen []dep=new Bumen[20];
		for(i=0;i<20;i++){
			dep[i]=new Bumen();
		}
		//部门 
		for(i=0;i<20;i++) 
		{
			int j,bm;
			for(j=0;j<20;j++) //生成编号 
			{
				bm=r.nextInt(20);
				if(!judge[bm])
				{
					dep[i].setNum(depart_no[bm]);
					judge[bm]=true;
					break; 
				}
			}
			//
			
			dep[i].setShangxian(10+r.nextInt(6));//学生数【10,15】 
			
			int tag1,tag2,k=0;
			tag1=2+r.nextInt(3);//随机生成2-4个标签数 
			boolean []judge2=new boolean[20];
			String []tag=new String[tag1];
			for(j=0;j<tag1;j++)//部门标签 (重复？)
			{
				while(k==0){
					tag2=r.nextInt(10);
					if(!judge2[tag2]){
						tag[j]=tags[tag2];
						judge2[tag2]=true;
						k=1;
					}
				}
				k=0;	
			}
			dep[i].setTedian(tag);
			int event1,event2;
			event1=2+r.nextInt(3);//随机生成2-5个活动时间段 
			String []event=new String[event1];
			boolean []judge3=new boolean[20];
			for(j=0;j<event1;j++)
			{
				while(k==0){
					event2=r.nextInt(20);
					if(!judge3[event2]){
						event[j]=free_time[event2];
						judge3[event2]=true;
						k=1;
					}
				}
				k=0;
			}
			dep[i].setHuodong(event);
		}
		//学生 
		int m=0,j=0,c=0;
		int num;
		String numb="031502";
		for(m=0;m<300;m++)
		{
			num=(1+m/50)*100+m%50+1;
			String nume = String.valueOf(num);
			//System.out.println(numb+nume);
			stu[m].setXuehao(numb+nume);
			stu[m].setChengji(30+r.nextInt(70));//随机生成绩点 
	    //    cout<<gpa<<endl;
	        //
	        int event1,event2;
			event1=2+r.nextInt(4);//随机生成2-5个活动时间段 
			String []events=new String[event1];
			boolean []judge4=new boolean[20];
			for(j=0;j<event1;j++)
			{
				while(c==0){
					event2=r.nextInt(20);
					if(!judge4[event2]){
						events[j]=free_time[event2];
						judge4[event2]=true;
						c=1;
					}
				}
				c=0;
			}
			stu[m].setKongxian(events);
		//	 cout<<endl;
			//
			int depart1,depart2;//生成活动意愿			
			depart1=1+r.nextInt(5); //
			String []depart3=new String[depart1];
			boolean []judge5=new boolean[20];
			for(j=0;j<depart1;j++)
			{
				while(c==0){
					depart2=r.nextInt(20);
					if(!judge5[depart2]){
						depart3[j]=depart_no[depart2];
						judge5[depart2]=true;
						c=1;
					}
				}
				c=0;
//				cout<<depart3<<" ";
			}
			stu[m].setYiyuan(depart3);
		//	cout<<endl;
			//
			int tag1,tag2;
			tag1=2+r.nextInt(3);//随机生成2-4个兴趣标签 
			String []tag=new String[tag1];
			boolean []judge6=new boolean[10];
			for(j=0;j<tag1;j++)//兴趣标签  (重复？)
			{
				while(c==0){
					tag2=r.nextInt(10);
					if(!judge6[tag2]){
						tag[j]=tags[tag2];
						judge6[tag2]=true;
						c=1;
					}
				}
				c=0;
		//		cout<<tag<<" ";
			}
			stu[m].setXingqu(tag);
		//	cout<<endl;
		//	cout<<endl;
			//  
			
		}
		out.setDepartments(dep);
		out.setStudents(stu);
		Duxie.xie(out, new File(".\\import.txt"));
	}
	
}
