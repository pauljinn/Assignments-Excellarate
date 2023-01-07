package stream;

import java.util.List;

public class Company {
	private int companyId;
	private String companyName;
	private List<Integer> departmentIds;
	
	public Company() {
		super();
	}

	public Company(int companyId, String companyName, List<Integer> departmentIds) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.departmentIds = departmentIds;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Integer> getDepartmentIds() {
		return departmentIds;
	}

	public void setDepartmentIds(List<Integer> departmentIds) {
		this.departmentIds = departmentIds;
	}	
}
