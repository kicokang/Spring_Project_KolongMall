package spring.com.dao;

import java.util.List;

import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import spring.com.dto.MemberVO;
 
@Repository
public class MemberDAOImpl implements MemberDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "spring.com.mapper.MemberMapper";
    
    @Override
    public List<MemberVO> selectAllMember() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectAllMember");
    }
    
    @Override
	public String loginCheck(String id, String pw) throws Exception{
    	String db_pw=sqlSession.selectOne(Namespace+".loginCheck",id);
    	return db_pw;
    };
    
    @Override
    public int getm_num() throws Exception {
    	int m_num=sqlSession.selectOne(Namespace+".getm_num");    			
    	return m_num;
    };
    
    @Override
	public int signin(int m_num,String id,String pw,String name,String address) throws Exception{

    	MemberVO vo =new MemberVO(m_num,id,pw,name,address);
    	int record=sqlSession.insert(Namespace+".signin",vo);
    	return record;
    };

    @Override
	public int checkid(String id) throws Exception{
    	int check=sqlSession.selectOne(Namespace+".checkid",id);
    	return check;
    };
    
    @Override
    public String getUserM_num(String id) throws Exception{
    	System.out.println("getuserM_num 에서 id = "+id);
    	
    	try {
        	int m_num=sqlSession.selectOne(Namespace+".checkUserM_num",id);
        	String string_m_num=Integer.toString(m_num);
        	System.out.println("getuserM_num 에서 string_m_num = "+string_m_num);
    		return string_m_num;
		} catch (Exception e) {
			return null;
		}
    	
    };

    @Override
    public String checkUserPW(String m_num) throws Exception{
    	System.out.println("m_num = "+m_num);
    	String userPW=sqlSession.selectOne(Namespace+".checkUserPW",m_num);
    	System.out.println("userPW = "+userPW);
		return userPW;
    };
    
    @Override
	public List<MemberVO> loadMemberInfo(String getM_num) throws Exception{
    	
    	return sqlSession.selectList(Namespace+".loadMemberInfo",getM_num);
    };
    
}

	
