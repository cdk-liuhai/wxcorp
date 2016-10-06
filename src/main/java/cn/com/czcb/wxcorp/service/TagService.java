package cn.com.czcb.wxcorp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.controller.DepartmentController;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.Department;
import cn.com.czcb.wxcorp.pojo.DepartmentQryResp;
import cn.com.czcb.wxcorp.pojo.TagListResp;
import cn.com.czcb.wxcorp.pojo.Taglist;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TagService {
	private static Logger logger = LogManager
			.getLogger(TagService.class);

	@Autowired
	private AccessTokenDao accessTokenDao;
	@Autowired
	private ApiService apiService;

	public List<Taglist> getTags()
			throws IOException {
		String accessToken = accessTokenDao.getFromFile();
		String url = String.format(URLConstant.TAG_LIST, accessToken);
		List<Taglist> tags = new ArrayList<Taglist>();
			
		String resp = apiService.doGet(url);
		
		ObjectMapper om = new ObjectMapper();
		TagListResp tagListResp = om.readValue(resp,
				TagListResp.class);
		if( tagListResp.getErrcode() != 0){
        	throw new IOException("推送消息失败"+tagListResp.toString());
        }
		tags = tagListResp.getTaglist();
		return tags;
	}
}
