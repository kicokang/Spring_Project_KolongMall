package spring.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import spring.com.dto.ClothesVO;
import spring.com.dto.CriteriaVO;
import spring.com.dto.MemberVO;
 
@Repository
public class ClothesDAOImpl implements ClothesDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "spring.com.mapper.clothesMapper";
    
    @Override
    public List<ClothesVO> selectAllClothes() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectAllClothes");
    }

    @Override
	public int totalRow(String search) throws Exception{
    	
    	return sqlSession.selectOne(Namespace+".totalRow",search);
    }
    
    @Override
	public List<ClothesVO> searchClothesList(String search,int pagePerRow, int nowPage) throws Exception{
    	
    	CriteriaVO vo =new CriteriaVO(search,nowPage,pagePerRow);
    	vo.setLimit1();
    	List<ClothesVO> record=sqlSession.selectList(Namespace+".searchClothesList",vo);
    	return record;
    }

}

	
