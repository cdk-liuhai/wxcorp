package cn.com.czcb.wxcorp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){
		int a = 0;
		a += 1;
		System.out.println("index call");
		return "index";
	}
}
