
public class Student {
	private int studentId;
	private String studentName;
	private String email;
	private int age;
	
	public void acceptData(int id, String name, String em, int age) {
		studentId = id;
		studentName = name;
		email = em;
		this.age = age;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Student() {
		
	}
	
	public Student(int id, String name, String em, int g) {
		this.studentId = id;
		this.studentName = name;
		this.email = em;
		this.age = g;
	}
	
	void showdata() {
		
	}
}
