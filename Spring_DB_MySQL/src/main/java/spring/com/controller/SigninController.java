package spring.com.controller;

import java.util.ArrayList;
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

import spring.com.dto.ClothesVO;
import spring.com.dto.MemberVO;
import spring.com.service.MemberService;

@Controller
public class SigninController {
    
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Inject
    private MemberService service;
    
    //���̵� �ߺ� Ȯ�� �޼���
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
    
    //��й�ȣ Ȯ��
    @RequestMapping(value = "/signin/**", method = RequestMethod.POST)
    public String signin(
    		@RequestParam("checkid") String id,
    	    @RequestParam("pw") String pw,
    	    @RequestParam("pw") String pw2,
    	    @RequestParam("name") String name,
    	    @RequestParam("address") String address,
    		Locale locale, Model model, HttpServletRequest request) throws Exception{
 
        logger.info("signin");
        System.out.println("id:"+id);
        int record=0;
        if(pw==pw2) {
        	System.out.println(pw+"��"+pw2+"��ġ");
        	record=service.signup(id, pw, name, address);
        	return "signin";
        }else {
        	System.out.println(pw+"��"+pw2+"����ġ");
        }
        
        
        System.out.println("record:"+record);
        return "signin";
    }

    //���� ���� �� ����Ȯ��, ��й�ȣ �Է¹޾� Ȯ��...�Ķ���� �޴°� input ������ �ٸ��� ������..
    @RequestMapping(value = "/checkuser/**")
    public String checkUser(
    		@RequestParam("pw") String pw,
    		Locale locale, Model model, HttpServletRequest request) throws Exception{
 
        logger.info("checkUser");
        System.out.println("pw:"+pw);
        
        Boolean confrimUser = service.checkUser(pw);
        System.out.println("confrimUser:"+confrimUser);

        model.addAttribute("confrimUser", confrimUser);
     
        return "myinfo";
    }
}

