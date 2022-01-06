package spring.com.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
 
import org.springframework.stereotype.Service;
 
import spring.com.dao.ClothesDAO;
import spring.com.dto.ClothesVO;
 
@Service
public class ClothesServiceImpl implements ClothesService {
 
    @Inject
    private ClothesDAO dao;
    
    @Override
    public List<ClothesVO> selectAllClothes() throws Exception {
 
        return dao.selectAllClothes();
    }
    
    @Override
	public int totalRow(String search) throws Exception{
    	return dao.totalRow(search);
    }
    
    @Override
    public List<ClothesVO> searchClothesList(String search,int pagePerRow, int nowPage) throws Exception{
    	return dao.searchClothesList(search,pagePerRow,nowPage);
    }

 
}
