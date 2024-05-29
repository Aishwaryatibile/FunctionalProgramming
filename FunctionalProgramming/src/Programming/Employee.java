package Programming;

public class Employee {

	private String empId;
	private String name;
	private String dept;
	private int age;

	public Employee(String empId, String name, String dept, int age) {
		super();
		this.empId = empId;
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}

}
