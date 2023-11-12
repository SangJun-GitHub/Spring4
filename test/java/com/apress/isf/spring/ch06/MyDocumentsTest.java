package com.apress.isf.spring.ch06;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Sang Jun Park on 11/12/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MyDocumentsTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
    private ClassPathXmlApplicationContext context;

    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("META-INF/ch05/mydocuments-context-ch05.xml");
    }

    @Test
    public void testMenu(){
        log.debug("About to read the Resource file: menu.txt");
        Resource resource = context.getResource("classpath:META-INF/ch06/data/menu.txt");

        try{
            InputStream stream = resource.getInputStream();
            Scanner scanner = new Scanner(stream);
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
