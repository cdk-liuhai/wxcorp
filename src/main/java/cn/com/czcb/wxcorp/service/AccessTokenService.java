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

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.AccessToken;

public class AccessTokenService {
	private AccessTokenDao accessTokenDao;

	public void updateAccessToken() throws ClientProtocolException, IOException {
		String url = String.format(URLConstant.ACCESSTOKEN_GET,
				URLConstant.BAOJING_CORPID, URLConstant.BAOJING_CORPSECRET);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);

		HttpResponse response = httpClient.execute(get);

		System.out.println(response.toString());
		AccessToken accessToken = null;
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity);
			System.out.println(str);

			ObjectMapper om = new ObjectMapper();
			accessToken = om.readValue(str, AccessToken.class);
			if (accessToken.getAccessToken() == null) {
				throw new RuntimeException("获取AccessToken失败");
			}
			get.abort();
		} else {
			get.abort();
			throw new RuntimeException("获取AccessToken失败");
		}
	}
}
