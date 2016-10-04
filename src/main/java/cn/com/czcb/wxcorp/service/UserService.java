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
	private AccessTokenDao accessTokenDao;

	public List<Userlist> getSimpleList() throws JsonParseException, JsonMappingException, IOException {
		String accessToken = accessTokenDao.getFromFile();
		String url = String.format(URLConstant.USER_SIMPLE_LIST, accessToken,
				1, ConstFetchChild.GetRecursiveNo, ConstUserStatus.ALL);
		;

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);

		HttpResponse response = httpClient.execute(get);

		logger.info(response.toString());
		List<Userlist> users = new ArrayList<Userlist>();
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity);
			logger.info(str);

			ObjectMapper om = new ObjectMapper();
			UserSimpleList simpleUsers = om.readValue(str,
					UserSimpleList.class);
			users =  simpleUsers.getUserlist();
			
			get.abort();
		} else {
			get.abort();
			throw new RuntimeException("获取AccessToken失败");
		}
		return users;
	}
}
