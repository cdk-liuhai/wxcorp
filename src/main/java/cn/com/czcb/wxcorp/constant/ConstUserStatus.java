package cn.com.czcb.wxcorp.constant;

public class ConstUserStatus {

	/*
	 * 0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加，未填写则默认为4 
	 */
	public static final String ALL = "0";
	public static final String FOLLOW = "1";
	public static final String FORBID = "2";
	public static final String UNFOLLOW = "4";
}
