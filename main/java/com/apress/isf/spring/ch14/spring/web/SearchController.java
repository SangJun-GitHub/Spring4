package com.apress.isf.spring.ch14.spring.web;

import com.apress.isf.spring.ch14.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sang Jun Park on 11/30/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    DocumentDAO documentDAO;

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public String searchAll(Model model){
        model.addAttribute("docs", documentDAO.getAll());
        return "search/all";
    }
}
