package spring.com.service;

import java.util.List;

import javax.inject.Inject;
 
import org.springframework.stereotype.Service;
 
import spring.com.dao.MemberDAO;
import spring.com.dto.MemberVO;
 
@Service
public class MemberServiceImpl implements MemberService {
 
    @Inject
    private MemberDAO dao;
    
    @Override
    public List<MemberVO> selectAllMember() throws Exception {
 
        return dao.selectAllMember();
    }
    
    @Override
    public boolean loginCheck(String id, String pw) throws Exception {
    	
    	String userPW = dao.loginCheck(id,pw);
    	if(userPW==null) {
    		return false;
    	}
    	if(userPW.equals(pw)==true) {
    		return true;
    	} else {
    		return false;
    	}
    };
    
    @Override
	public int signup(String id,String pw,String name,String address) throws Exception{
    	
    	int m_num=dao.getm_num();
    	return dao.signin(m_num+1,id,pw,name,address);
    };
    
    @Override
	public int checkid(String id) throws Exception{
    	
    	return dao.checkid(id);
    };
    
    
    @Override
    public Boolean checkUser(String id,String pw) throws Exception{
    	System.out.println("checkUser id ="+id);
    	System.out.println("checkUser pw ="+pw);
    	String m_num=dao.getUserM_num(id);
    	String userPW=dao.checkUserPW(m_num);
    	
    	System.out.println("m_num ="+m_num);
    	System.out.println("userPW ="+userPW);
    	if(userPW.equals(pw)==true) {
    		return true;
    	}
    	else {
    		return false;
    	}
    };
    //�� getM_num�� �׳� ���� ���񽺰� �ƴ϶� controller���� �߾�� �߳�? dao �ִ°� �°���?
    @Override
	public String getM_number(String id) throws Exception{
    	String m_num=dao.getUserM_num(id);
    	return m_num;
    };
    
    @Override
	public List<MemberVO> loadMemberInfo(String getM_num) throws Exception{
    	return dao.loadMemberInfo(getM_num);
    };

    @Override
	public void withdrawal(String id) throws Exception{
    	dao.withdrawal(id);
    };

}
