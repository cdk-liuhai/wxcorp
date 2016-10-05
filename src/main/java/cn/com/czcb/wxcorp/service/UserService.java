package cn.com.czcb.wxcorp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.czcb.wxcorp.constant.ConstFetchChild;
import cn.com.czcb.wxcorp.constant.ConstUserStatus;
import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.controller.MessageController;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.Department;
import cn.com.czcb.wxcorp.pojo.DepartmentQryResp;
import cn.com.czcb.wxcorp.pojo.UserSimpleList;
import cn.com.czcb.wxcorp.pojo.Userlist;

@Service
public class UserService {
	private static Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private ApiService apiService;
	@Autowired
	private AccessTokenDao accessTokenDao;

	public List<Userlist> getSimpleList(String deptID) throws JsonParseException, JsonMappingException, IOException {
		String accessToken = accessTokenDao.getFromFile();
		String url = String.format(URLConstant.USER_SIMPLE_LIST, accessToken,
				deptID, ConstFetchChild.GetRecursiveYes, ConstUserStatus.ALL);
		;

		String response = apiService.doGet(url);
		

		logger.info(response.toString());
		List<Userlist> users = new ArrayList<Userlist>();
		ObjectMapper om = new ObjectMapper();
		UserSimpleList simpleUsers = om.readValue(response,
				UserSimpleList.class);
		users =  simpleUsers.getUserlist();
		
		return users;
	}
}
