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
    	
    	return dao.loginCheck(id,pw);
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

}
