package cn.com.czcb.wxcorp.pojo;

import java.util.List;

public class TagListResp {
	private int errcode;
	private String errmsg;
	private List<Taglist> taglist;

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

	public void setTaglist(List<Taglist> taglist) {
		this.taglist = taglist;
	}

	public List<Taglist> getTaglist() {
		return taglist;
	}
}
