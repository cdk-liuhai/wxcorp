package cn.com.czcb.wxcorp.pojo;

/**
 * Auto-generated: 2016-10-02 10:20:6
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class WxPushMsgTextMsgReq {

	private String touser;
	private String toparty;
	private String totag;
	private String msgtype;
	private int agentid;
	private Text text;
	private int safe;

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTouser() {
		return touser;
	}

	public void setToparty(String toparty) {
		this.toparty = toparty;
	}

	public String getToparty() {
		return toparty;
	}

	public void setTotag(String totag) {
		this.totag = totag;
	}

	public String getTotag() {
		return totag;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}

	public int getAgentid() {
		return agentid;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Text getText() {
		return text;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}

	public int getSafe() {
		return safe;
	}
}