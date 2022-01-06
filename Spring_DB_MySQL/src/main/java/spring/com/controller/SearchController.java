package spring.com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
 
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.com.dto.ClothesVO;
import spring.com.dto.CriteriaVO;
import spring.com.service.ClothesService;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class SearchController {
    
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Inject
    private ClothesService service;
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    
    @RequestMapping(value = "/search/**", method = RequestMethod.GET)
    public String serarch(
            @RequestParam("search") String search,
            @RequestParam("nowPage") int nowPage,
    		Locale locale, Model model, HttpServletRequest request) throws Exception{
 
        logger.info("search");
        logger.info("�˻���:"+search);
        logger.info("����������:"+nowPage);
        
        //����¡ ó��
        //���� ������,��row, perrow,
        //int lastPage = totalRowCount / pagePerRow;
        //if (totalRowCount % pagePerRow != 0) {lastPage++;}
        //�����������ְ�, �������� �ְ�.. pagePerRow..lastPage..
        int pagePerRow = 5;
        int totalRow = service.totalRow(search);
        logger.info("totalRow:"+totalRow);
        //List<ClothesVO> clothesList = service.selectAllClothes();
        //�˻����
        ArrayList<ClothesVO> searchClothesList = (ArrayList<ClothesVO>)service.searchClothesList(search,pagePerRow,nowPage);
        for(int i=0; i<searchClothesList.size(); i++) {
        	searchClothesList.get(i).showinfo();
        }
        model.addAttribute("clothesList", searchClothesList);
        
     
        //model.addAttribute("totalNumOfData",totalNumOfData);
        
        //��̷� ���� �����Ͷ�..?
        //���� ������, �����������, ����� ����¡�Ұ��ΰ�?
        CriteriaVO cvo = new CriteriaVO();
        int numberOfPage = cvo.getNumOfPage(totalRow);
        int []testArray= new int[5];
        int countPage=5;
        int startPage = ((nowPage-1)/countPage)*countPage+1;
        int endPage= startPage+countPage-1;
        System.out.println("nowPage:"+nowPage);
        System.out.println("startPage:"+startPage);
        System.out.println("endPage:"+endPage);
        System.out.println("numberOfPage:"+numberOfPage);
        //������ ����Ʈ���� ���ϱ�
        if(endPage>numberOfPage) {
        	endPage=numberOfPage;
        }
        for(int i=startPage-1;i<=endPage-1;i++) {
            	testArray[i]=i+1;
            	
        }
        System.out.println("nowPage:"+nowPage);
        System.out.println("startPage:"+startPage);
        System.out.println("endPage:"+endPage);
        System.out.println("numberOfPage:"+numberOfPage);
        for(int i=0;i<=endPage;i++) {
        	if(testArray[i]==0) {
        		testArray=Arrays.copyOf(testArray, testArray.length-((5-endPage)));
        	}
        }
        
        System.out.println(Arrays.toString(testArray));
        model.addAttribute("testArray",testArray);
        return "clotheslist";
    }
    
}

