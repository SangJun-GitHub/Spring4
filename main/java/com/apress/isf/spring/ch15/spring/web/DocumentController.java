package com.apress.isf.spring.ch15.spring.web;

import com.apress.isf.spring.ch15.java.model.Document;
import com.apress.isf.spring.ch15.java.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sang Jun Park on 12/04/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Controller
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    DocumentService documentFacade;

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody List<Document> getDocuments(){
        return documentFacade.getAllDocuments();
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public @ResponseBody Document findDocument(@PathVariable String id){
        return documentFacade.findDocumentById(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Document addDocument(@RequestBody Document document){
        String id = document.getDocumentId();
        return documentFacade.saveDocument(id,document);
    }

    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public @ResponseBody Document updateDocument(@RequestBody Document document, @PathVariable String id){
        return documentFacade.saveDocument(id,document);
    }

    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public @ResponseBody Document removeDocument(@PathVariable String id){
        return documentFacade.removeDocumentById(id);
    }
}
