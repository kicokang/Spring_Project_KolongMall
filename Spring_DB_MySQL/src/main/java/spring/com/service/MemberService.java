package spring.com.service;

import java.util.List;

import spring.com.dto.MemberVO;
 
public interface MemberService {
    
    public List<MemberVO> selectAllMember() throws Exception;

	public boolean loginCheck(String id, String pw) throws Exception;
	
	public int signup(String id,String pw,String name,String address) throws Exception;

	public int checkid(String id) throws Exception;

	public Boolean checkUser(String pw) throws Exception;
}


