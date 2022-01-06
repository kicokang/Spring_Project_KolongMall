package spring.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser;

import spring.com.dto.MemberVO;
import spring.com.service.MemberService;

@Controller
public class SigninController {
    
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Inject
    private MemberService service;
    

    @RequestMapping(value= "/idcheck.do", method = {RequestMethod.POST})
    public @ResponseBody Map<Object, Object> checkid(String checkID)
    		 throws Exception{
    	
    	logger.info("checkid");
    	int cnt=0;
    	Map<Object,Object> map = new HashMap<>();
    	cnt = service.checkid(checkID);
    	System.out.println(checkID);
    	map.put("cnt",cnt);
    	
    	return map;
    }

}

