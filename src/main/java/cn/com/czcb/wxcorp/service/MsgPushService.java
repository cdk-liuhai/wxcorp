package cn.com.czcb.wxcorp.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wxcorp.TestMsgPushService;
import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.WxPushMsgResp;
import cn.com.czcb.wxcorp.pojo.WxPushMsgTextMsgReq;
import cn.com.czcb.wxcorp.pojo.Text;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MsgPushService {
	private static Logger logger = LogManager.getLogger(MsgPushService.class);

	@Autowired
	private AccessTokenDao  accessTokenDao;
	
	public WxPushMsgResp pushMsg(WxPushMsgTextMsgReq txtMsg) throws ClientProtocolException, IOException{
		
		String accessToken = accessTokenDao.getFromFile();
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String url = URLConstant.MSG_SEND + accessToken;
        HttpPost post = new HttpPost(url);
        
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(txtMsg);
        logger.info("推送发送请求：" +json);
        HttpEntity entity = new StringEntity(json,ContentType.create("text/plain", "UTF-8"));
        post.setEntity( entity);
        
        CloseableHttpResponse response = httpClient.execute(post);
        String respStr = EntityUtils.toString(response.getEntity());
        ObjectMapper ob = new ObjectMapper();
        WxPushMsgResp resp = ob.readValue(respStr, WxPushMsgResp.class);
        return resp;
	}

}
