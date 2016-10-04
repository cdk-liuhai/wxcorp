package cn.com.czcb.wxcorp.controller;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.Department;
import cn.com.czcb.wxcorp.pojo.DepartmentQryResp;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DepartmentController {

	private static Logger logger = LogManager.getLogger(DepartmentController.class);
	@Autowired
	private AccessTokenDao accessTokenDao;

	@RequestMapping("/department/qry")
	public String qryDepartment() throws JsonParseException, JsonMappingException, IOException{
		String accessToken = accessTokenDao.getFromFile();
		String url = String.format(URLConstant.DEPARTMENT_LIST, accessToken, "1");

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);

		HttpResponse response = httpClient.execute(get);

		logger.info(response.toString());
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity);
			logger.info( str);
			
			ObjectMapper om = new ObjectMapper();
			DepartmentQryResp departs = om.readValue(str, DepartmentQryResp.class);
			List<Department> deps = departs.getDepartment();
			for (Department department : deps) {
				logger.info(department.toString());
			}
			get.abort();
		} else {
			get.abort();
			throw new RuntimeException("获取AccessToken失败");
		}
		return "index";
	}
}
