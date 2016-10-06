package cn.com.czcb.wxcorp.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.czcb.wxcorp.pojo.Taglist;
import cn.com.czcb.wxcorp.pojo.WxPushMsgTextMsgReq;
import cn.com.czcb.wxcorp.service.AccessTokenService;
import cn.com.czcb.wxcorp.service.MsgPushService;
import cn.com.czcb.wxcorp.service.TagService;

@Controller
public class TagController {
	private static Logger logger = LogManager.getLogger(TagController.class);

	@Autowired
	TagService tagService;
	
	@RequestMapping( value="/tag", method=RequestMethod.GET)
	public String inputTextMsg(Model model) throws IOException{
		List<Taglist> tags = tagService.getTags();
		model.addAttribute("tags", tags);
		return "tag/list";
	}
	
}
