package cn.com.czcb.wxcorp.pojo;

public class MsgSignature {
	String msg_signature;
	String timestamp;
	String nonce;
	String echostr;
	public String getMsg_signature() {
		return msg_signature;
	}
	public void setMsg_signature(String msg_signature) {
		this.msg_signature = msg_signature;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getEchostr() {
		return echostr;
	}
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	@Override
	public String toString() {
		return "MsgSignature [msg_signature=" + msg_signature + ", timestamp="
				+ timestamp + ", nonce=" + nonce + ", echostr=" + echostr + "]";
	}
	
	
}
