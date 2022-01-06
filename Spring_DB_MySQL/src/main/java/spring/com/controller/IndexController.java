package spring.com.controller;

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
import spring.com.service.ClothesService;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
    
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Inject
    private ClothesService service;
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Locale locale, Model model) throws Exception{
 
        logger.info("index");
        
        List<ClothesVO> clothesList = service.selectAllClothes();
        
        model.addAttribute("clothesList", clothesList);
 
        return "index";
    }
 
    
}

