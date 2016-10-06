package cn.com.czcb.wxcorp.service;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.HttpResult;
import cn.com.czcb.wxcorp.pojo.WxPushMsgResp;
import cn.com.czcb.wxcorp.pojo.WxPushMsgTextMsgReq;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MsgPushService {
	private static Logger logger = LogManager.getLogger(MsgPushService.class);

	@Autowired
	private AccessTokenDao accessTokenDao;

	@Autowired
	private ApiService apiService;

	public WxPushMsgResp pushMsg(WxPushMsgTextMsgReq txtMsg) throws ClientProtocolException, IOException{
		
		String accessToken = accessTokenDao.getFromFile();
		String url = URLConstant.MSG_SEND + accessToken;
		ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(txtMsg);
        
        HttpResult result = apiService.doPostJson(url, json);
        
//      HttpEntity entity = new StringEntity(json,ContentType.create("text/plain", "UTF-8"));
//      post.setEntity( entity);
        WxPushMsgResp resp = new WxPushMsgResp();
        if( result.getCode() == HttpStatus.SC_OK){
        	ObjectMapper ob = new ObjectMapper();
        	ob.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        	resp =ob.readValue(result.getData(), WxPushMsgResp.class);
        	if( resp.getErrcode() != 0){
            	throw new IOException("推送消息失败"+resp.toString());
            }
        }else{
        	throw new IOException("推送消息失败"+ result.toString());
        }
        return resp;
	}
}
