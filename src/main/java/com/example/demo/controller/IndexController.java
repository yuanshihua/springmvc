package com.example.demo.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class IndexController {

	@RequestMapping("/user")
	@ResponseBody
	public List user() {
		return Arrays.asList(new User("qiu", 33, 69), new User("liu", 45, 80), new User("chi", 22, 87));
	}
	
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/json")
	public String json() {
		return "json";
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	@ResponseBody
	//@RequestBody可以将请求中的json字符串绑定到相应的bean或字符串上
	public String getBean(/*@RequestBody User user ,*/ @RequestParam String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper om = new ObjectMapper();
		System.out.println(om);
		User user = om.readValue(json, User.class);
		System.out.println(user);
		return "111";
	}
}
