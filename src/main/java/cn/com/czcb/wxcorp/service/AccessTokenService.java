package cn.com.czcb.wxcorp.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.AccessToken;

@Service
public class AccessTokenService {
	private static Logger logger = LogManager.getLogger(AccessTokenService.class);

	@Autowired
	private ApiService apiService;
	
	@Autowired
	private AccessTokenDao accessTokenDao;

	public void updateAccessToken() throws ClientProtocolException, IOException {
		String url = String.format(URLConstant.ACCESSTOKEN_GET,
				URLConstant.BAOJING_CORPID, URLConstant.BAOJING_CORPSECRET);
		
		String str = apiService.doGet(url);
		ObjectMapper om = new ObjectMapper();
		AccessToken accessToken = om.readValue(str, AccessToken.class);
		if(accessToken.getAccessToken()==null){
			throw new IOException("更新token失败:"+str);
		}
		accessTokenDao.updateAccessToken(accessToken);
	}
}
