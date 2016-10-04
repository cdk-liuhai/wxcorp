package cn.com.czcb.wxcorp.pojo;

import java.util.List;

public class UserSimpleList {

	private int errcode;
	private String errmsg;
	private List<Userlist> userlist;

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setUserlist(List<Userlist> userlist) {
		this.userlist = userlist;
	}

	public List<Userlist> getUserlist() {
		return userlist;
	}


}