package wxcorp;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cn.com.czcb.wxcorp.pojo.Userlist;
import cn.com.czcb.wxcorp.service.AccessTokenService;
import cn.com.czcb.wxcorp.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserService {

	@Autowired
	UserService userService;
	@Autowired
	AccessTokenService tokenService;
	
	@Test
	public void updateAccessToken() throws ClientProtocolException, IOException {
		tokenService.updateAccessToken();
		
		
	}
	
	@Test
	public void getSimpleList() throws JsonParseException, JsonMappingException, IOException{
		List<Userlist> users = userService.getSimpleList("1");
		
		for (Userlist userlist : users) {
			System.out.println(userlist.toString());
		}
	}
}
