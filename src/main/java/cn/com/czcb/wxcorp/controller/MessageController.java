package cn.com.czcb.wxcorp.controller;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.czcb.wxcorp.pojo.WxPushMsgTextMsgReq;
import cn.com.czcb.wxcorp.service.AccessTokenService;
import cn.com.czcb.wxcorp.service.MsgPushService;

@Controller
public class MessageController {
	private static Logger logger = LogManager.getLogger(MessageController.class);

	@Autowired
	MsgPushService pushService;
	
	@RequestMapping("/msg/push")
	public void pushTextMsg(){
		try {
			pushService.pushMsg(new WxPushMsgTextMsgReq());
		} catch (ClientProtocolException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
