package wxcorp;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cn.com.czcb.wxcorp.pojo.WxPushMsgTextMsgReq;
import cn.com.czcb.wxcorp.pojo.Text;
import cn.com.czcb.wxcorp.pojo.Userlist;
import cn.com.czcb.wxcorp.service.AccessTokenService;
import cn.com.czcb.wxcorp.service.MsgPushService;
import cn.com.czcb.wxcorp.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMsgPushService {
	private static Logger logger = LogManager.getLogger(TestMsgPushService.class);

	@Autowired
	MsgPushService pushService;
	@Autowired
	AccessTokenService tokenService;
	
	@Test
	public void updateAccessToken() throws ClientProtocolException, IOException {
		tokenService.updateAccessToken();
		
		
	}
	
	@Test
	public void pushService() throws JsonParseException, JsonMappingException, IOException{
		WxPushMsgTextMsgReq txtMsg = new WxPushMsgTextMsgReq();
        txtMsg.setAgentid(1);
        txtMsg.setMsgtype("text");
        Text txt = new Text();
        txt.setContent("推送测试textaaaaa");
        txtMsg.setText(txt);
        txtMsg.setTouser("@all");
		pushService.pushMsg(txtMsg);
	}
}
