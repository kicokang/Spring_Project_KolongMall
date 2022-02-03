package spring.com.dao;

import java.util.List;

import spring.com.dto.MemberVO;
 
public interface MemberDAO {
    
    public List<MemberVO> selectAllMember() throws Exception;

	public String loginCheck(String id, String pw) throws Exception;
	
	public int signin(int m_num,String id,String pw,String name,String address) throws Exception;
	
	public int getm_num() throws Exception;

	public int checkid(String id) throws Exception;

	public String getUserM_num(String id) throws Exception;
	
	public String checkUserPW(String m_num) throws Exception;

	public List<MemberVO> loadMemberInfo(String getM_num) throws Exception;

}
