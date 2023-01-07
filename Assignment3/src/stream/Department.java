package stream;

import java.util.List;

public class Department {
	private int departmentId;
	private String departmentName;
	private int employeeId;
	
	public Department() {
		super();
	}

	public Department(int departmentId, String departmentName, int employeeId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employeeId = employeeId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employeeId="
				+ employeeId + "]";
	}
	
}
