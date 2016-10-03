package cn.com.czcb.wxcorp.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import cn.com.czcb.wxcorp.pojo.AccessToken;
import cn.com.czcb.wxcorp.service.AccessTokenService;

@Component
public class AccessTokenDao {
	private static Logger logger = LogManager.getLogger(AccessTokenService.class);

	public String getFromFile() {
		File file = new File("./accessToken.txt");
		BufferedReader bReader  = null;
		try {
			bReader = new BufferedReader(new FileReader(file));
			String token = bReader.readLine();
			logger.info("token getFromFile:" + token);
			bReader.close();
			return token;
		} catch (IOException e) {
			if(bReader != null){
				try {
					bReader.close();
				} catch (IOException e1) {
					logger.info("read accesstoken error");
				}
			}
		}
		return null;
	}

	public void updateAccessToken(AccessToken accessToken) {
		File file = new File("./accessToken.txt");
		FileWriter writer  = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			writer =  new FileWriter(file);
			writer.write(accessToken.getAccessToken());
			writer.close();
		} catch (IOException e) {
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e1) {
					logger.error("write accesstoken error" + e);
				}
			}
		}

	}

}
