package cn.com.czcb.wxcorp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.czcb.wxcorp.constant.URLConstant;
import cn.com.czcb.wxcorp.pojo.Department;
import cn.com.czcb.wxcorp.pojo.DepartmentQryResp;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DepartmentService {
	private static Logger logger = LogManager
			.getLogger(DepartmentService.class);


	@Autowired
	private AccessTokenService accessTokenService;

	@Autowired
	private ApiService apiService;

	public List<Department> getDepartments(String departmentID)
			throws IOException {
		String accessToken = accessTokenService.getAccessToken();
		String url = String.format(URLConstant.DEPARTMENT_LIST, accessToken,
				departmentID);
		List<Department> deps = new ArrayList<Department>();
			
		String resp = apiService.doGet(url);
		logger.info(resp.toString());
		
		ObjectMapper om = new ObjectMapper();
		DepartmentQryResp departs = om.readValue(resp,
				DepartmentQryResp.class);
		if( departs.getErrcode() != 0){
        	throw new IOException("推送消息失败"+departs.toString());
        }
		deps = departs.getDepartment();
		return deps;
	}
}
