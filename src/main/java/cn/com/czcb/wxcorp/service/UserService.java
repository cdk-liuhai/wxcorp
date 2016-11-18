package cn.com.czcb.wxcorp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.czcb.wxcorp.constant.ConstFetchChild;
import cn.com.czcb.wxcorp.constant.ConstUserStatus;
import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.pojo.UserSimpleList;
import cn.com.czcb.wxcorp.pojo.Userlist;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
	private static Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private ApiService apiService;

	@Autowired
	private AccessTokenService accessTokenService;

	public List<Userlist> getSimpleList(String deptID) throws JsonParseException, JsonMappingException, IOException {
		String accessToken = accessTokenService.getAccessToken();
		String url = String.format(URLConstant.USER_SIMPLE_LIST, accessToken,
				deptID, ConstFetchChild.GetRecursiveYes, ConstUserStatus.ALL);
		;

		String response = apiService.doGet(url);
		

		logger.info(response.toString());
		List<Userlist> users = new ArrayList<Userlist>();
		ObjectMapper om = new ObjectMapper();
		UserSimpleList simpleUsers = om.readValue(response,
				UserSimpleList.class);
		if( simpleUsers.getErrcode() != 0){
        	throw new IOException("推送消息失败"+simpleUsers
        			.toString());
        }
		users =  simpleUsers.getUserlist();
		
		return users;
	}
}
