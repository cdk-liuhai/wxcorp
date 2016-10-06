package cn.com.czcb.wxcorp.constant;

public class URLConstant {
	public static final String WECHAT_DOMAIN = "https://qyapi.weixin.qq.com/cgi-bin/";
	public static final String MSG_SEND = WECHAT_DOMAIN+"message/send?access_token=";
	public static final String ACCESSTOKEN_GET = WECHAT_DOMAIN + "gettoken?corpid=%s&corpsecret=%s";
	public static final String DEPARTMENT_LIST = WECHAT_DOMAIN + "department/list?access_token=%s&id=%s";
	public static final String USER_SIMPLE_LIST = WECHAT_DOMAIN + "user/simplelist?access_token=%s&department_id=%s&fetch_child=%s&status=%s";
	public static final String TAG_LIST = WECHAT_DOMAIN + "tag/list?access_token=%s";
	
	public static final String BAOJING_CORPID = "wx4ffd7354272f0103";
	public static final String BAOJING_CORPSECRET = "vbVxMsn3XBGF0c-72PAHwbiUTGcQU6yn6S4I6pcBEhkWEuXF0lSN6EgRGYi3ZHGk";
	public static final String BAOJING_EncodingAESKey="Jr2Jj2eDSaGkeURAQXR1UbdSNPQZW5pGDD67OF43d8w";
	public static final String BAOJING_Token= "nRcC7aosykrShHaUgDC";
	
}
