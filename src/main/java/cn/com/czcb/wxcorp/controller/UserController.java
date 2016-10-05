package cn.com.czcb.wxcorp.controller;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.Department;
import cn.com.czcb.wxcorp.pojo.DepartmentQryResp;
import cn.com.czcb.wxcorp.pojo.Userlist;
import cn.com.czcb.wxcorp.service.DepartmentService;
import cn.com.czcb.wxcorp.service.UserService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserController {

	private static Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/user/qry")
	public String qryDepartment( String deptID, Model model) throws IOException {
		
		List<Userlist> users = userService.getSimpleList(deptID);
		model.addAttribute("users", users);
		return "user/qry";
	}
}
