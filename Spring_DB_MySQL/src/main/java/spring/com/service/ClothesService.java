package spring.com.service;

import java.util.ArrayList;
import java.util.List;

import spring.com.dto.ClothesVO;
 
public interface ClothesService {
    
    public List<ClothesVO> selectAllClothes() throws Exception;

	public List<ClothesVO> searchClothesList(String search, int pagePerRow, int nowPage) throws Exception;

	int totalRow(String search) throws Exception;
}


