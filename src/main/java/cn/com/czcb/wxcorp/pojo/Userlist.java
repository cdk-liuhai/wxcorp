package cn.com.czcb.wxcorp.pojo;

import java.util.List;

public class Userlist {

	private String userid;
	private String name;
	private List<Integer> department;

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDepartment(List<Integer> department) {
		this.department = department;
	}

	public List<Integer> getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return "Userlist [userid=" + userid + ", name=" + name
				+ ", department=" + department + "]";
	}
}
