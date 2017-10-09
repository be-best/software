package json.miyu;

import java.util.Arrays;

public class Shurulei {
	private Xuesheng []students;
	private Bumen []departments;
	public Shurulei (){
		
	}
	public Xuesheng[] getStudents() {
		return students;
	}
	public void setStudents(Xuesheng[] students) {
		this.students = students;
	}
	public Bumen[] getDepartments() {
		return departments;
	}
	public void setDepartments(Bumen[] departments) {
		this.departments = departments;
	}
	@Override
	public String toString() {
		return "Shurulei [students=" + Arrays.toString(students) + ", departments=" + Arrays.toString(departments)
				+ "]";
	}
}
