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
    public String getUserM_num(String pw) throws Exception{
    	String m_num=sqlSession.selectOne(Namespace+".checkUserM_num",pw);
		return m_num;
    };

    @Override
    public String checkUserPW(String m_num) throws Exception{
    	String userPW=sqlSession.selectOne(Namespace+".checkUserPW",m_num);
		return userPW;
    };
    
    @Override
	public List<MemberVO> loadMemberInfo(String getM_num) throws Exception{
    	
    	return sqlSession.selectList(Namespace+".loadMemberInfo",getM_num);
    };
    
}

	
