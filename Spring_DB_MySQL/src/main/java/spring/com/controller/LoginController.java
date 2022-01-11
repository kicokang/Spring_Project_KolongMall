package spring.com.controller;

import java.util.List;
import java.util.Locale;
 
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.com.dto.MemberVO;
import spring.com.service.MemberService;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
    
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Inject
    private MemberService service;
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    //로그인 메인 페이지로
    @RequestMapping(value = "/login_main/**", method = RequestMethod.GET)
    public String goToLogin(
    		Locale locale, Model model, HttpServletRequest request) throws Exception{
 
        logger.info("goToLogin");
 
        return "login_main";
    }
    
    //회원가입 메인 페이지로
    @RequestMapping(value = "/signin_main/**")
    public String goToSignin_main(
    		Locale locale, Model model, HttpServletRequest request) throws Exception{
 
        logger.info("goToSignin_main");
 
        return "signin_main";
    }
    //로그인 검증
    @RequestMapping(value = "/logined/**")
    public String login_Check(
    	    @RequestParam("id") String id,
    	    @RequestParam("pw") String pw,
    		Locale locale, Model model, HttpServletRequest request,
    		HttpSession session) throws Exception{
 
        logger.info("login_Check");
        
        boolean result=service.loginCheck(id,pw);
        System.out.println("id:"+id);
        System.out.println("pw:"+pw);
      
        if(result==true) {
        	session.setAttribute("id",id);
        	System.out.println("세션값:"+id);
        	String session_id=(String)session.getAttribute("id");
        	System.out.println("꺼내봄:"+session_id);
        	
        	return "logined";
        }else if(result==false) {
        	return "login_failed";
        }
        
        return "logined";
    }
    
   
}

