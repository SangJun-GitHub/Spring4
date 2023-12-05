package com.apress.isf.spring.ch15;

import com.apress.isf.spring.ch15.java.model.Document;
import com.apress.isf.spring.ch15.java.model.Type;
import com.apress.isf.spring.ch15.java.service.DocumentService;
import com.apress.isf.spring.ch15.java.service.TypeService;
import com.apress.isf.spring.ch15.spring.data.DocumentDAO;
import com.apress.isf.spring.ch15.spring.data.TypeDAO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang Jun Park on 12/02/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/ch15/mydocument-context-ch15.xml")
public class MyDocumentsTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
    private static final String ID = "1acbb68a-a859-49c9-ac88-d9e9322bac55";
    private static final String NAME = "Book Template";
    private static final String NAME_UPDATED ="My Book";

    @Autowired
    DocumentDAO mongoDocumentDAO;
    @Autowired
    TypeDAO mongoTypeDAO;
    @Autowired
    DocumentService documentFacade;
    @Autowired
    TypeService typeFacade;

    @Test
    @Ignore
    public void testMongoDBMigration(){
        log.debug("Test Spring Data MongoDB - Migration (Run only once)...");

        assertNotNull(mongoDocumentDAO);
        assertNotNull(documentFacade);
        assertNotNull(typeFacade);
        assertNotNull(mongoTypeDAO);

        List<Type> types = typeFacade.getAllDefinedTypes();
        assertNotNull(types);
        assertEquals(4, types.size());

        for(Type type : types){
            mongoTypeDAO.save(type);
        }

        List<Document> documents = documentFacade.getAllDocuments();
        assertNotNull(documents);
        assertNotEquals(6, documents.size());

        for (Document document: documents){
            mongoDocumentDAO.save(document.getDocumentId(), document);
        }
    }

    @Test
    @Ignore
    public void testMongoDBFind(){
        log.debug("Testing Spring Data MongoDB... [ FIND ]");
        assertNotNull(mongoDocumentDAO);
        Document document = mongoDocumentDAO.findById(ID);
        assertNotNull(document);
        assertEquals(NAME, document.getName());
        log.debug(document.toString());
    }

    @Test
    @Ignore
    public void testMongoDBUpdate(){
        log.debug("Testing Spring Data MongoDB... [ UPDATE ]");
        assertNotNull(mongoDocumentDAO);
        Document document = new Document(ID, NAME_UPDATED);
        assertNotNull(document);
        Document updatedDocument = mongoDocumentDAO.save(ID, document);
        assertNotNull(updatedDocument);
        log.debug(updatedDocument.toString());
    }

    @Test
    @Ignore
    public void testMongoDBRemove(){
        log.debug("Testing Spring Data MongoDB... [ REMOVE ]");
        assertNotNull(mongoDocumentDAO);
        Document document = mongoDocumentDAO.removeById(ID);
        assertNotNull(document);
        Document removedDocument = mongoDocumentDAO.findById(ID);
        assertNull(removedDocument);
    }

}
