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
	public boolean loginCheck(String id, String pw) throws Exception{
    	String db_pw=sqlSession.selectOne(Namespace+".loginCheck",id);
    	System.out.println("db_id:"+db_pw);
    	if(db_pw==null) {
    		return false;
    	}
    	
    	if(db_pw.equals(pw)==true) {
    		return true;
    	} else {
    		return false;
    	}
    	
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

}

	
