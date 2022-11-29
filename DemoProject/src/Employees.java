
public class Employees {
	private int empId;
	private String empName;
	static String organization = "Hexaware";
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Employees(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}
	
	public void show() {
		System.out.println("ID: " + empId + ", name: " + empName + ", Organisation: " + organization);
	}
	public final void demo1(){
		
	}
	
}
