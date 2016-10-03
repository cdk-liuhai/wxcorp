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

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.AccessToken;
import cn.com.czcb.wxcorp.pojo.PushMsgTextMsg;
import cn.com.czcb.wxcorp.pojo.Text;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PushMsgService {
	
	private AccessTokenDao  accessTokenDao;
	
	public void pushMsg(PushMsgTextMsg txtMsg) throws ClientProtocolException, IOException{
		
		AccessToken accessToken = accessTokenDao.getFromFile();
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String url = URLConstant.MSG_SEND + accessToken.getAccessToken();
        HttpPost post = new HttpPost(url);
        
//        PushMsgTextMsg txtMsg = new PushMsgTextMsg();
        txtMsg.setAgentid(1);
        txtMsg.setMsgtype("text");
        Text txt = new Text();
        txt.setContent("推送测试text");
        txtMsg.setText(txt);
        txtMsg.setTouser("@all");
        
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(txtMsg);
        System.out.println(json);
        HttpEntity entity = new StringEntity(json,ContentType.create("text/plain", "UTF-8"));
        post.setEntity( entity);
        
        CloseableHttpResponse response = httpClient.execute(post);
        System.out.println(response.toString());
        System.out.println(EntityUtils.toString(response.getEntity()));
	}

}
