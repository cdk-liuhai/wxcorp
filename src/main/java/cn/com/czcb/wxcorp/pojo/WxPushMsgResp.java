package cn.com.czcb.wxcorp.pojo;

public class WxPushMsgResp {
	private int errcode;
	private String errmsg;
	private String invaliduser;
	private String invalidparty;
	private String invalidtag;

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

	public void setInvaliduser(String invaliduser) {
		this.invaliduser = invaliduser;
	}

	public String getInvaliduser() {
		return invaliduser;
	}

	public void setInvalidparty(String invalidparty) {
		this.invalidparty = invalidparty;
	}

	public String getInvalidparty() {
		return invalidparty;
	}

	public void setInvalidtag(String invalidtag) {
		this.invalidtag = invalidtag;
	}

	public String getInvalidtag() {
		return invalidtag;
	}

	@Override
	public String toString() {
		return "WxPushMsgResp [errcode=" + errcode + ", errmsg=" + errmsg
				+ ", invaliduser=" + invaliduser + ", invalidparty="
				+ invalidparty + ", invalidtag=" + invalidtag + "]";
	}
}
