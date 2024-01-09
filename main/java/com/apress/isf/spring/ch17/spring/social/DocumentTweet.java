package com.apress.isf.spring.ch17.spring.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.social.twitter.api.Twitter;


/**
 * Created by Sang Jun Park on 01/08/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Component("documentTweet")
public class DocumentTweet {
    @Autowired
    Twitter tweet;

    public void tweet(String text){
        tweet.timelineOperations().updateStatus(text);
    }
}
