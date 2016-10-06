package cn.com.czcb.wxcorp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.pojo.MsgSignature;
import cn.com.czcb.wxcorp.service.AccessTokenService;

@Controller
public class VerifyController {

	private static Logger logger = LogManager.getLogger(VerifyController.class);

	@Autowired
	private AccessTokenService accessTokenService;
	
	@RequestMapping("/verify")
	public void verify(MsgSignature signature, HttpServletResponse response)
			throws IOException, AesException {
		logger.info("signature:" + signature.toString());

		WXBizMsgCrypt bizMsgCrypt = new WXBizMsgCrypt(
				URLConstant.BAOJING_Token, URLConstant.BAOJING_EncodingAESKey,
				URLConstant.BAOJING_CORPID);
		String echostrDecryped = bizMsgCrypt.VerifyURL(signature.getMsg_signature(),
				signature.getTimestamp(), signature.getNonce(),
				signature.getEchostr());
		
		response.getWriter().write(echostrDecryped);
	}
	
	@RequestMapping("/accesstoken/update")
	public String getAccesstoken(HttpServletResponse response)
			throws IOException, AesException {

		accessTokenService.updateAccessToken();
		
		return "error/success";
	}
}
