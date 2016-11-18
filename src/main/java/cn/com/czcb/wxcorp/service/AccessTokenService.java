package cn.com.czcb.wxcorp.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.AccessToken;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	
	public void getAccessToken() throws ClientProtocolException, IOException  {
		/*这里偷个懒，不写定时任务，也不搞错误重试了。
		 * 每次调用api之前，都去取一次token。 
		 * 报警应用，应该到不了微信调用的上限
		 * */
		updateAccessToken();
		
	}
}
