package spring.com.dao;

import java.util.List;

import spring.com.dto.MemberVO;
 
public interface MemberDAO {
    
    public List<MemberVO> selectMember() throws Exception;
}
