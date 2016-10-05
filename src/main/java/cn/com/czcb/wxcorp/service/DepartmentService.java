package cn.com.czcb.wxcorp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.controller.DepartmentController;
import cn.com.czcb.wxcorp.dao.AccessTokenDao;
import cn.com.czcb.wxcorp.pojo.Department;
import cn.com.czcb.wxcorp.pojo.DepartmentQryResp;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DepartmentService {
	private static Logger logger = LogManager
			.getLogger(DepartmentService.class);

	@Autowired
	private HttpClient httpClient;
	@Autowired
	private AccessTokenDao accessTokenDao;
	@Autowired
	private ApiService apiService;

	public List<Department> getDepartments(String departmentID)
			throws IOException {
		String accessToken = accessTokenDao.getFromFile();
		String url = String.format(URLConstant.DEPARTMENT_LIST, accessToken,
				departmentID);
		List<Department> deps = new ArrayList<Department>();
			
		String resp = apiService.doGet(url);
		logger.info(resp.toString());
		
		ObjectMapper om = new ObjectMapper();
		DepartmentQryResp departs = om.readValue(resp,
				DepartmentQryResp.class);
		deps = departs.getDepartment();
		return deps;
	}
}
