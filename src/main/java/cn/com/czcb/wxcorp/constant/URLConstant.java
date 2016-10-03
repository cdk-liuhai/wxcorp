package cn.com.czcb.wxcorp.constant;

public class URLConstant {
	public static final String WECHAT_DOMAIN = "https://qyapi.weixin.qq.com/cgi-bin/";
	public static final String MSG_SEND = WECHAT_DOMAIN+"message/send?access_token=";
	public static final String ACCESSTOKEN_GET = WECHAT_DOMAIN + "gettoken?corpid=%s&corpsecret=%s";
	
	public static final String BAOJING_CORPID = "wx4ffd7354272f0103";
	public static final String BAOJING_CORPSECRET = "vbVxMsn3XBGF0c-72PAHwbiUTGcQU6yn6S4I6pcBEhkWEuXF0lSN6EgRGYi3ZHGk";
}
