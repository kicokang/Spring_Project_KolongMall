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

	// 아이디 중복 확인 메서드
	@RequestMapping(value = "/idcheck.do", method = { RequestMethod.POST })
	public @ResponseBody Map<Object, Object> checkid(String checkID) throws Exception {

		logger.info("checkid");
		int cnt = 0;
		Map<Object, Object> map = new HashMap<>();
		cnt = service.checkid(checkID);
		System.out.println(checkID);
		map.put("cnt", cnt);

		return map;
	}

	// 회원가입
	@RequestMapping(value = "/signin/**", method = RequestMethod.POST)
	public String signin(@RequestParam("checkid") String id, @RequestParam("pw") String pw,
			@RequestParam("pw") String pw2, @RequestParam("name") String name, @RequestParam("address") String address,
			Locale locale, Model model, HttpServletRequest request) throws Exception {

		logger.info("signin");
		System.out.println("id:" + id);
		int record = 0;
		if (pw == pw2) {
			System.out.println(pw + "과" + pw2 + "일치");
			record = service.signup(id, pw, name, address);
			return "signin";
		} else {
			System.out.println(pw + "과" + pw2 + "불일치");
		}

		System.out.println("record:" + record);
		return "signin";
	}

	// 정보 수정 전 본인확인, 비밀번호 입력받아 확인...파라미터 받는게 input 갯수와 다르면 못받음..
	@RequestMapping(value = "/checkuser/**")
	public String checkUser(@RequestParam("pw") String pw,@RequestParam("session_id") String id, Locale locale, Model model, HttpServletRequest request)
			throws Exception {

		logger.info("checkUser");
		System.out.println("id:" + id);
		System.out.println("pw:" + pw);
		//회원정보 확인 코드
		Boolean confrimUser = service.checkUser(id,pw);
		System.out.println("confrimUser:" + confrimUser);

		model.addAttribute("confrimUser", confrimUser);
		
		//개인정보 불러오기 코드
		String getM_num=service.getM_number(id);
		System.out.println("loadUserInfoDo에서 getM_num="+getM_num);
		List<MemberVO>memberInfo= service.loadMemberInfo(getM_num);

		model.addAttribute("memberInfo", memberInfo);

		return "myinfo";
	}

	// 개인정보 가져오기...ajax 연동인데 지금 필요없음..
	@RequestMapping(value = "/loadUserInfo.do", method = { RequestMethod.POST })
	public @ResponseBody Map<Object, Object>loadUserInfoDo(String id,String pw ,  Model model)throws Exception {
//Map<Object, Object>  string 대신넣어져 있음
		logger.info("loadUserInfoDo");
		//vo에 서비스에서 가져온 객체정보를 저장해야지
		System.out.println("id="+id+"pw="+pw);
		//jap식 코드
		String getM_num=service.getM_number(id);
		//System.out.println("loadUserInfoDo에서 getM_num="+getM_num);
		//List<MemberVO>memberInfo= service.loadMemberInfo(getM_num);

		//model.addAttribute("memberInfo", memberInfo);
		
		//ajax 코드
		Map<Object, Object> map = new HashMap<>();
		List<MemberVO> cnt = service.loadMemberInfo(getM_num);

		map.put("cnt",cnt);

		return map;
	}
	//회원 탈퇴
	@RequestMapping(value = "/")
	public String withdrawal(@RequestParam("session_id") String id,
			Locale locale, Model model, HttpServletRequest request) throws Exception {

		logger.info("withdrawal");
		System.out.println("signout id:" + id);
		
		return "index";
	}
}
