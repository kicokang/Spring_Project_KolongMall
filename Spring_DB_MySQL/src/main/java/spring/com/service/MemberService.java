package spring.com.service;

import java.util.List;

import spring.com.dto.MemberVO;
 
public interface MemberService {
    
    public List<MemberVO> selectMember() throws Exception;
}


