package com.apress.isf.spring.ch12.spring.web;

import com.apress.isf.spring.ch01.HelloWorldController;
import com.apress.isf.spring.ch12.java.model.Document;
import com.apress.isf.spring.ch12.java.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/22/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@Controller
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    DocumentService documentFacade;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Document> getDocuments(){
        return documentFacade.getAllDocuments();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Document findDocument(@PathVariable String id){
        return documentFacade.findDocumentById(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Document addDocument(@RequestBody Document document) {
        String id = document.getDocumentId();
        return documentFacade.saveDocument(id,document);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody Document updateDocument(@RequestBody Document document, @PathVariable String id){
        return documentFacade.saveDocument(id, document);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Document removeDocument(@PathVariable String id){
        return documentFacade.removeDocumentById(id);
    }

}
